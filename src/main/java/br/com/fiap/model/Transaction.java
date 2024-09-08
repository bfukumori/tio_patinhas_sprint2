package br.com.fiap.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private TransactionType transactionType;
    private BigDecimal quantity;
    private BigDecimal priceAtTransaction;
    private Timestamp transactionDate;
    private Wallet fromWallet;
    private Wallet toWallet;

    public Transaction(UUID id, TransactionType transactionType, BigDecimal quantity, BigDecimal priceAtTransaction, Timestamp transactionDate, Wallet fromWallet, Wallet toWallet) {
        this.id = id;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.priceAtTransaction = priceAtTransaction;
        this.transactionDate = transactionDate;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
    }

    public Transaction(TransactionType transactionType, BigDecimal quantity, BigDecimal priceAtTransaction, Timestamp transactionDate, Wallet fromWallet, Wallet toWallet) {
        this.id = UUID.randomUUID();
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.priceAtTransaction = priceAtTransaction;
        this.transactionDate = transactionDate;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceAtTransaction() {
        return priceAtTransaction;
    }

    public void setPriceAtTransaction(BigDecimal priceAtTransaction) {
        this.priceAtTransaction = priceAtTransaction;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Wallet getFromWallet() {
        return fromWallet;
    }

    public void setFromWallet(Wallet fromWallet) {
        this.fromWallet = fromWallet;
    }

    public Wallet getToWallet() {
        return toWallet;
    }

    public void setToWallet(Wallet toWallet) {
        this.toWallet = toWallet;
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
