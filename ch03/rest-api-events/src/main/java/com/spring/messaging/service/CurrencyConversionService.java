package com.spring.messaging.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import com.spring.messaging.domain.CurrencyExchange;
import com.spring.messaging.domain.Rate;
import com.spring.messaging.event.CurrencyConversionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.spring.messaging.annotation.ToUpper;
import com.spring.messaging.domain.CurrencyConversion;
import com.spring.messaging.exception.BadCodeRuntimeException;
import com.spring.messaging.repository.RateRepository;

@Service
public class CurrencyConversionService {
	
	@Autowired
	RateRepository repository;
	@Autowired
	ApplicationEventPublisher publisher;
	
	public CurrencyConversion convertFromTo(@ToUpper String base, @ToUpper String code,Float amount) {
		Rate baseRate = new Rate(CurrencyExchange.BASE_CODE,1.0F,new Date());
		Rate codeRate = new Rate(CurrencyExchange.BASE_CODE,1.0F,new Date());
		
		if(!CurrencyExchange.BASE_CODE.equals(base))
			baseRate = repository.findByDateAndCode(new Date(), base);
		
		if(!CurrencyExchange.BASE_CODE.equals(code))
			codeRate = repository.findByDateAndCode(new Date(), code);
		
		if(null == codeRate || null == baseRate)
			throw new BadCodeRuntimeException("Bad Code Base, unknown code: " + base, new CurrencyConversion(base,code,amount,-1F));

		CurrencyConversion result = new CurrencyConversion(base,code,amount,(codeRate.getRate()/baseRate.getRate()) * amount);

		publisher.publishEvent(new CurrencyConversionEvent(this, result));
		
		return result;
	}
	
	public Rate[] calculateByCode(@ToUpper String code, Date date){
		List<Rate> rates = repository.findByDate(date);
		if(code.equals(CurrencyExchange.BASE_CODE))
			return rates.toArray(new Rate[0]);
		
		Rate baseRate = rates.stream()
			 .filter(rate -> rate.getCode().equals(code)).findFirst().orElse(null);
		
		if(null == baseRate)
			throw new BadCodeRuntimeException("Bad Base Code, unknown code: " + code, new Rate(code,-1F,date));
		
		return Stream.concat(rates.stream()
			 .filter(n -> !n.getCode().equals(code))
			 .map(n -> new Rate(n.getCode(),n.getRate()/baseRate.getRate(),date)),Stream.of(new Rate(CurrencyExchange.BASE_CODE,1/baseRate.getRate(),date)))
			 .toArray(size -> new Rate[size]);
	}
	
}
