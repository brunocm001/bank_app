package ca.test.bankapp.service;

import java.math.BigDecimal;

public interface FeesService {
    BigDecimal computeFees(BigDecimal amount);
}
