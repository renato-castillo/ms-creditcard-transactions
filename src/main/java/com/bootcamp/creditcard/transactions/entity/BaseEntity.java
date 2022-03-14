package com.bootcamp.creditcard.transactions.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseEntity {

    @Id
    private String id;

    private Float amount;

    private String creditCardIdentifier;

    private String documentNumber;

    private String documentType;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
