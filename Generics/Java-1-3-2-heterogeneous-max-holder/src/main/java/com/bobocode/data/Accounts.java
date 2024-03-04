package com.bobocode.data;

import com.bobocode.model.Account;

import java.math.BigDecimal;

public class Accounts {

    public static Account generateAccount() {
        return new Account(BigDecimal.valueOf(100L));
    }

}
