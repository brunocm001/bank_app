package ca.test.bankapp.service.impl;

import ca.test.bankapp.entity.User;
import ca.test.bankapp.repository.AccountRepository;
import ca.test.bankapp.repository.AccountingJournalRepository;
import ca.test.bankapp.service.BankService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@SuppressWarnings("FieldCanBeLocal")
@Service
public class BankServiceImpl implements BankService {

    private final AccountRepository accountRepository;
    private final AccountingJournalRepository accountingJournalRepository;

    public BankServiceImpl(AccountRepository accountRepository, AccountingJournalRepository accountingJournalRepository) {
        this.accountRepository = accountRepository;
        this.accountingJournalRepository = accountingJournalRepository;
    }

    @Override
    public boolean credit(User user, BigDecimal amount) {
        return false;
    }

    @Override
    public boolean debit(User user, BigDecimal amount) {
        return false;
    }

}
