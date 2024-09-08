package br.com.fiap.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Wallet {
    private UUID id;
    private CompanyAccount companyAccount;
    private CryptoAsset cryptoAsset;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public Wallet(UUID id, CompanyAccount companyAccount, CryptoAsset cryptoAsset, BigDecimal balance) {
        this.id = id;
        this.companyAccount = companyAccount;
        this.cryptoAsset = cryptoAsset;
        this.balance = balance != null ? balance : BigDecimal.ZERO;
        this.transactions = new ArrayList<>();
    }

    public Wallet(CompanyAccount companyAccount, CryptoAsset cryptoAsset, BigDecimal balance) {
        this.id = UUID.randomUUID();
        this.companyAccount = companyAccount;
        this.cryptoAsset = cryptoAsset;
        this.balance = BigDecimal.ZERO;
        this.transactions = new ArrayList<>();

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CompanyAccount getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(CompanyAccount companyAccount) {
        this.companyAccount = companyAccount;
    }

    public CryptoAsset getCryptoAsset() {
        return cryptoAsset;
    }

    public void setCryptoAsset(CryptoAsset cryptoAsset) {
        this.cryptoAsset = cryptoAsset;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        if (balance != null && balance.compareTo(BigDecimal.ZERO) >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        this.transactions.remove(transaction);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", companyAccount=" + companyAccount.getCompanyName() +
                ", cryptoAsset=" + cryptoAsset.getAssetName() +
                ", balance=" + balance +
                ", transactionCount=" + (transactions != null ? transactions.size() : 0) +
                '}';
    }
}
