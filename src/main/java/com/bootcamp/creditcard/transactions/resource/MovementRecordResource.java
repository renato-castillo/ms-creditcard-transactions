package com.bootcamp.creditcard.transactions.resource;

import com.bootcamp.creditcard.transactions.dto.MovementDto;
import com.bootcamp.creditcard.transactions.dto.TransactionDto;
import com.bootcamp.creditcard.transactions.entity.MovementRecord;
import com.bootcamp.creditcard.transactions.service.IMovementRecordService;
import com.bootcamp.creditcard.transactions.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class MovementRecordResource extends MapperUtil {

    @Autowired
    private IMovementRecordService movementRecordService;

    public Mono<TransactionDto> createMovement(MovementDto movementDto) {

        /*
         * BUSCO SALDOS POR CREDIT CARD IDENTIFIER Y DATOS DEL CLIENTE
         * SI EL AMOUNT ES MAYOR O IGUAL AL SALDO, REALIZO TRANSACCIÓN
         * DE LO CONTRARIO THROW EXCEPTION
         * */

        MovementRecord movementRecord = new MovementRecord();
        movementRecord.setCreditCardIdentifier(movementDto.getCreditCardIdentifier());
        movementRecord.setAmount(movementDto.getAmount());
        movementRecord.setDocumentNumber(movementDto.getDocumentNumber());
        movementRecord.setDocumentType(movementDto.getDocumentType());
        movementRecord.setServiceName(movementDto.getServiceName());
        movementRecord.setCreatedAt(LocalDateTime.now());

        return movementRecordService.save(movementRecord).map(x -> {
            TransactionDto transactionDto = new TransactionDto();
            transactionDto.setTransactionId(x.getId());
            transactionDto.setCreditCardIdentifier(x.getCreditCardIdentifier());

            return transactionDto;
        });
    }

    public Mono<MovementDto> update(MovementDto movementDto) {

        return movementRecordService.findById(movementDto.getTransactionId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> {
                    MovementRecord movementRecord = map(movementDto, MovementRecord.class);
                    movementRecord.setCreatedAt(x.getCreatedAt());
                    movementRecord.setUpdatedAt(LocalDateTime.now());

                    return movementRecordService.save(movementRecord).map(y -> map(y, MovementDto.class));
                });
    }

    public Mono<Void> delete(MovementDto movementDto) {
        return movementRecordService.findById(movementDto.getTransactionId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> movementRecordService.deleteById(movementDto.getTransactionId()));
    }

    public Mono<MovementDto> findById(String id) {
        return movementRecordService.findById(id).map(x -> map(x, MovementDto.class));
    }

    public Flux<MovementDto> findAll() {

        return movementRecordService.findAll()
                .map(x -> map(x, MovementDto.class));
    }
}
