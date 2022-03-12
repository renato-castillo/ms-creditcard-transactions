package com.bootcamp.creditcard.transactions.resource;

import com.bootcamp.creditcard.transactions.service.IMovementRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class MovementRecordResource {

    @Autowired
    private IMovementRecordService movementRecordService;
}
