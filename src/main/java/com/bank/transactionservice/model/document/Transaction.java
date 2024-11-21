package com.bank.transactionservice.model.document;

import com.bank.transactionservice.model.enums.TransactionStatus;
import com.bank.transactionservice.model.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String clientId;
    private String productId;
    private Double amount;
    private TransactionType type;
    private TransactionStatus status;

    public Transaction(TransactionType type) {
        this.type = type;
    }
}
