package com.bootcamp.creditcard.transactions.repository;

import com.bootcamp.creditcard.transactions.entity.MovementRecord;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IMovementRecordRepository extends ReactiveMongoRepository<MovementRecord, String> {
}
