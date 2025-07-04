package ca.test.bankapp.service;

import ca.test.bankapp.entity.User;

import java.math.BigDecimal;

public interface BankService {

    boolean credit(User user, BigDecimal amount);
    boolean debit(User user, BigDecimal amount);

}
