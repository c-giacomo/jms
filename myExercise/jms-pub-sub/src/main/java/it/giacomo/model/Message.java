package it.giacomo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Message {
    private String name;
    private String surname;
}
