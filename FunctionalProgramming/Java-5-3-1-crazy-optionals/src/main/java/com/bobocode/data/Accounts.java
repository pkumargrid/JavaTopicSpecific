package com.bobocode.data;

import com.bobocode.model.Account;
import com.bobocode.model.CreditAccount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Accounts {

    public static Account generateAccount() {
        return new Account(BigDecimal.valueOf(100L));
    }

    public static CreditAccount generateCreditAccount() {
        return new CreditAccount(BigDecimal.valueOf(100L));
    }

    public static List<Account> generateAccountList(int i) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(new BigDecimal("1000.00"), "dummy1@example.com"));
        accounts.add(new Account(new BigDecimal("2500.50"), "dummy2@example.com"));
        accounts.add(new Account(new BigDecimal("150.75"), "dummy3@example.com"));
        accounts.add(new Account(new BigDecimal("0.001"), "dummy4@example.com"));
        accounts.add(new Account(new BigDecimal("3000.00"), "dummy5@example.com"));
        return accounts;
    }

    public static List<CreditAccount> generateCreditAccountList(int i) {
        CreditAccount account1 = new CreditAccount(new BigDecimal("1000.50"));
        CreditAccount account2 = new CreditAccount(new BigDecimal("2000.75"));
        CreditAccount account3 = new CreditAccount(new BigDecimal("1500.25"));
        CreditAccount account4 = new CreditAccount(new BigDecimal("3000.30"));
        CreditAccount account5 = new CreditAccount(new BigDecimal("2500.20"));

        return Arrays.asList(account1, account2, account3, account4, account5);
    }
}
