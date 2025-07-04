package ca.test.bankapp.service.impl;

import ca.test.bankapp.service.FeesService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FeesServiceImpl implements FeesService {

    @Override
    public BigDecimal computeFees(BigDecimal amount) {
        return null;
    }

}
