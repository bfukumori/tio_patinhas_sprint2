package br.com.fiap.model;

import java.util.UUID;

public class CompanyAccount {
    private final UUID id;
    private final User owner;
    private final String companyName;
    private final String companyIdentifier;

    public CompanyAccount(UUID id, User owner, String companyName) {
        this.id = id;
        this.owner = owner;
        this.companyName = companyName;
        this.companyIdentifier = generateAccountNumber();
    }

    public CompanyAccount(User owner, String companyName) {
        this.id = UUID.randomUUID();
        this.owner = owner;
        this.companyName = companyName;
        this.companyIdentifier = generateAccountNumber();
    }

    private String generateAccountNumber() {
        if (this.owner == null) {
            throw new IllegalStateException("Owner cannot be null when generating account number.");
        }
        // Generate a simple account number using the owner's document
        return "ACC-" + this.owner.getDocument().substring(0,4) + "-" + this.id.toString().substring(0, 6).toUpperCase();
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

    @Override
    public String toString() {
        return "CompanyAccount{" +
                "id=" + id +
                ", owner=" + owner.getName() +
                ", companyName='" + companyName + '\'' +
                ", companyIdentifier='" + companyIdentifier + '\'' +
                '}';
    }
}
