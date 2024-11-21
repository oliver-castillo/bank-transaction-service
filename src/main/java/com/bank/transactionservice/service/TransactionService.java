package com.bank.transactionservice.service;

import com.bank.transactionservice.model.dto.request.TransactionRequest;
import com.bank.transactionservice.model.dto.response.OperationResponse;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Mono<OperationResponse> save(TransactionRequest request);
}
