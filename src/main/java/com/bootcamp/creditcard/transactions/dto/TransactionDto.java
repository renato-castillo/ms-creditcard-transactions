package com.bootcamp.creditcard.transactions.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

    private String transactionId;

    private Float amount;

    private String creditCardIdentifier;

    private String serviceName;

}
