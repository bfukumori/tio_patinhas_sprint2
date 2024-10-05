package br.com.fiap.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private UUID id = UUID.randomUUID();
    private final TransactionType transactionType;
    private final BigDecimal quantity;
    private final BigDecimal priceAtTransaction;
    private LocalDateTime transactionDate = LocalDateTime.now();
    private final Wallet fromWallet;
    private final Wallet toWallet;

    public Transaction(UUID id, TransactionType transactionType, BigDecimal quantity, BigDecimal priceAtTransaction, Wallet fromWallet, Wallet toWallet, LocalDateTime transactionDate) {
        this.id = id;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.priceAtTransaction = priceAtTransaction;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.transactionDate = transactionDate;
    }

    public Transaction(TransactionType transactionType, BigDecimal quantity, BigDecimal priceAtTransaction, Wallet fromWallet, Wallet toWallet) {
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.priceAtTransaction = priceAtTransaction;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
    }

    public UUID getId() {
        return id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getPriceAtTransaction() {
        return priceAtTransaction;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public Wallet getFromWallet() {
        return fromWallet;
    }

    public Wallet getToWallet() {
        return toWallet;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transactionType=" + transactionType +
                ", quantity=" + quantity +
                ", priceAtTransaction=" + priceAtTransaction +
                ", transactionDate=" + transactionDate +
                ", fromWallet=" + fromWallet +
                ", toWallet=" + toWallet +
                '}';
    }
}
