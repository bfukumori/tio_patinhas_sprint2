package br.com.fiap.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Wallet {
    private UUID id = UUID.randomUUID();
    private final CompanyAccount companyAccount;
    private CryptoAsset cryptoAsset;
    private BigDecimal quantity = BigDecimal.ZERO;
    private final BigDecimal balance = quantity.multiply(cryptoAsset.getCurrentPrice());

    public Wallet(UUID id, CompanyAccount companyAccount, CryptoAsset cryptoAsset) {
        this.id = id;
        this.companyAccount = companyAccount;
        this.cryptoAsset = cryptoAsset;
    }

    public Wallet(CompanyAccount companyAccount, CryptoAsset cryptoAsset) {
        this.companyAccount = companyAccount;
        this.cryptoAsset = cryptoAsset;
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

    public CryptoAsset getCryptoAsset() {
        return cryptoAsset;
    }

    public void setCryptoAsset(CryptoAsset cryptoAsset) {
        this.cryptoAsset = cryptoAsset;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal balance) {
        if (balance != null && balance.compareTo(BigDecimal.ZERO) >= 0) {
            this.quantity = balance;
        } else {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", companyAccount=" + companyAccount.getCompanyName() +
                ", cryptoAsset=" + cryptoAsset.getAssetName() +
                ", balance=" + balance +
                '}';
    }
}
