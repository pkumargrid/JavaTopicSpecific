package com.bobocode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Account {
    BigDecimal balance;
    String email;

    public Account(BigDecimal bigDecimal) {
        this.balance = bigDecimal;
    }
}
