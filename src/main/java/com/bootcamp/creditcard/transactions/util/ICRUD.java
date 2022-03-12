package com.bootcamp.creditcard.transactions.util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICRUD<T,V> {

    Mono<T> save(T t);

    Mono<Void> deleteById(V id);

    Mono<T> findById(V id);

    Flux<T> findAll();
}
