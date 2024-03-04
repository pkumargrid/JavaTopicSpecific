package com.bobocode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Account {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate month;
    private Sex sex;
    private LocalDate creationDate;
    private BigDecimal balance;
}
