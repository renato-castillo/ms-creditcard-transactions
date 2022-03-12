package com.bootcamp.creditcard.transactions.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class MovementRecord extends BaseEntity {



    private String documentNumber;

    private String documentType;

}
