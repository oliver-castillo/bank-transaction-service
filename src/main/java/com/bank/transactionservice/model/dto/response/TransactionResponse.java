package com.bank.transactionservice.model.dto.response;

import com.bank.transactionservice.model.enums.TransactionStatus;
import com.bank.transactionservice.model.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TransactionResponse {
    private String clientId;
    private String productId;
    private Double amount;
    private TransactionType type;
    private TransactionStatus status;
}
