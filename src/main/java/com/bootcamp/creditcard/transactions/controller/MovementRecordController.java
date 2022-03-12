package com.bootcamp.creditcard.transactions.controller;

import com.bootcamp.creditcard.transactions.resource.MovementRecordResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movementrecord")
public class MovementRecordController {

    @Autowired
    private MovementRecordResource movementRecordResource;


}
