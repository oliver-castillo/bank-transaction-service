package com.bank.transactionservice.service;

import com.bank.transactionservice.mapper.TransactionMapper;
import com.bank.transactionservice.model.dto.request.TransactionRequest;
import com.bank.transactionservice.model.dto.response.OperationResponse;
import com.bank.transactionservice.repository.TransactionRepository;
import com.bank.transactionservice.util.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class DefaultTransactionService implements TransactionService {
    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    @Override
    public Mono<OperationResponse> save(TransactionRequest request) {
        return repository.save(mapper.toDocument(request))
                .map(transaction -> new OperationResponse(Message.CREATED_SUCCESSFULLY, HttpStatus.CREATED));
    }
}
