package com.bootcamp.creditcard.transactions.service;

import com.bootcamp.creditcard.transactions.entity.MovementRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementRecordServiceImpl implements IMovementRecordService {

    @Autowired
    private IMovementRecordService recordService;

    @Override
    public Mono<MovementRecord> save(MovementRecord movementRecord) {
        return recordService.save(movementRecord);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return recordService.deleteById(id);
    }

    @Override
    public Mono<MovementRecord> findById(String id) {
        return recordService.findById(id);
    }

    @Override
    public Flux<MovementRecord> findAll() {
        return recordService.findAll();
    }
}
