package com.bank.transactionservice.mapper;

import com.bank.transactionservice.model.document.Transaction;
import com.bank.transactionservice.model.dto.request.TransactionRequest;
import com.bank.transactionservice.model.dto.response.TransactionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {
    Transaction toDocument(TransactionRequest request);

    TransactionResponse toResponse(Transaction document);
}
