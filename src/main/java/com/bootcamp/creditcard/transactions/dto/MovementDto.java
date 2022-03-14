package com.bootcamp.creditcard.transactions.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovementDto extends TransactionDto {

    private String documentNumber;

    private String documentType;
}
