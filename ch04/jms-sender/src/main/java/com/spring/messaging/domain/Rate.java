package com.spring.messaging.domain;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Rate {

	private String code;
	private Float rate;
	private Date date;

	public Rate() {
	}

	public Rate(String base, Float rate, Date date) {
		super();
		this.code = base;
		this.rate = rate;
		this.date = date;
	}
	
	@Override
	public String toString() {
		String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return "Rate [code=" + code + ", rate=" + rate + ", date=" + format + "]";
	}
}
