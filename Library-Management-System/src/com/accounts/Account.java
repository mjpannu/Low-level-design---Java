package com.accounts;

import com.enums.AccountStatus;

public abstract class Account {

    private String id;
    private String password;
    private AccountStatus status;
    private Person person;
}
