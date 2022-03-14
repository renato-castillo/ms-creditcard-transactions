package com.bootcamp.creditcard.transactions.controller;

import com.bootcamp.creditcard.transactions.dto.MovementDto;
import com.bootcamp.creditcard.transactions.dto.TransactionDto;
import com.bootcamp.creditcard.transactions.resource.MovementRecordResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/movementrecord")
public class MovementRecordController {

    @Autowired
    private MovementRecordResource movementRecordResource;

    @GetMapping
    public Flux<MovementDto> findAll() {
        return movementRecordResource.findAll();
    }

    @GetMapping("/{id}")
    public Mono<MovementDto> findById(@PathVariable String id) {
        return movementRecordResource.findById(id);
    }

    @PostMapping
    public Mono<TransactionDto> createMovement(MovementDto movementDto) {
        return movementRecordResource.createMovement(movementDto);
    }

    @PutMapping
    public Mono<MovementDto> updateMovement(MovementDto movementDto) {
        return movementRecordResource.update(movementDto);
    }

    @DeleteMapping
    private Mono<Void> delete(MovementDto movementDto) {
        return movementRecordResource.delete(movementDto);
    }



}
