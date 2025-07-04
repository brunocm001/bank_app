package ca.test.bankapp.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDTO {

    private Long id;
    private String accountNumber;
    private String currency;
    private BigDecimal balance;

}
