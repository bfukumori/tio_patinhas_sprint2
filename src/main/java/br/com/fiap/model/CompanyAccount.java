package br.com.fiap.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompanyAccount {
    private UUID id;
    private User owner;
    private String companyName;
    private String companyIdentifier;
    private List<Wallet> wallets;

    public CompanyAccount(User owner, String companyName) {
        this.id = UUID.randomUUID();
        this.owner = owner;
        this.companyName = companyName;
        this.companyIdentifier = generateAccountNumber();
        this.wallets = new ArrayList<>();
    }

    private String generateAccountNumber() {
        if (this.owner == null) {
            throw new IllegalStateException("Owner cannot be null when generating account number.");
        }
        // Generate a simple account number using the owner's document
        return "ACC-" + this.owner.getDocument() + "-" + this.id.toString().substring(0, 6).toUpperCase();
    }

    public UUID getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyIdentifier() {
        return companyIdentifier;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void addWallet(Wallet wallet) {
        this.wallets.add(wallet);
    }

    @Override
    public String toString() {
        return "CompanyAccount{" +
                "id=" + id +
                ", owner=" + owner.getName() +
                ", companyName='" + companyName + '\'' +
                ", companyIdentifier='" + companyIdentifier + '\'' +
                ", walletCount=" + (wallets != null ? wallets.size() : 0) +
                '}';
    }
}
