package com.bank.transactionservice.controller;

import com.bank.transactionservice.model.dto.request.TransactionRequest;
import com.bank.transactionservice.model.dto.response.OperationResponse;
import com.bank.transactionservice.model.enums.TransactionType;
import com.bank.transactionservice.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class TransactionController {
    private final TransactionService service;

    @PostMapping("{type}")
    public Mono<OperationResponse> save(@PathVariable String type, @RequestBody @Valid TransactionRequest request) {
        request.setType(TransactionType.fromString(type));
        return service.save(request);
    }
}
