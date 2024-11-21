package com.bank.transactionservice.model.dto.request;

import com.bank.transactionservice.model.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TransactionRequest {
    @NotBlank
    private String clientId;
    @NotNull
    private Double amount;
    @NotBlank
    private String productId;
    private TransactionType type;
}
