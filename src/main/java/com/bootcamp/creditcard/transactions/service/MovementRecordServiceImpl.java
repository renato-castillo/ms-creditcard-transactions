package com.bootcamp.creditcard.transactions.service;

import com.bootcamp.creditcard.transactions.entity.MovementRecord;
import com.bootcamp.creditcard.transactions.repository.IMovementRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementRecordServiceImpl implements IMovementRecordService {

    @Autowired
    private IMovementRecordRepository movementRecordRepository;

    @Override
    public Mono<MovementRecord> save(MovementRecord movementRecord) {
        return movementRecordRepository.save(movementRecord);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return movementRecordRepository.deleteById(id);
    }

    @Override
    public Mono<MovementRecord> findById(String id) {
        return movementRecordRepository.findById(id);
    }

    @Override
    public Flux<MovementRecord> findAll() {
        return movementRecordRepository.findAll();
    }
}
