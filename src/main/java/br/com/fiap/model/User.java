package br.com.fiap.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {


    private UUID id;
    private String name;
    private String email;
    private String password;
    private String document;
    private boolean twoFactorAuthEnabled;
    private LocalDateTime createdAt;
    private List<CompanyAccount> companyAccounts;


    public User(String name, String email, String document, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.document = document;
        this.password = password;
        this.twoFactorAuthEnabled = false;
        this.createdAt = LocalDateTime.now();
        this.companyAccounts = new ArrayList<>();
    }

    public User(UUID id, String name, String email, String document, String password, List<CompanyAccount> companyAccounts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.document = document;
        this.password = password;
        this.twoFactorAuthEnabled = false;
        this.createdAt = LocalDateTime.now();
        this.companyAccounts = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTwoFactorAuthEnabled() {
        return twoFactorAuthEnabled;
    }

    public void setTwoFactorAuthEnabled(boolean twoFactorAuthEnabled) {
        this.twoFactorAuthEnabled = twoFactorAuthEnabled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<CompanyAccount> getCompanyAccounts() {
        return companyAccounts;
    }

    public void setCompanyAccounts(List<CompanyAccount> companyAccounts) {
        this.companyAccounts = companyAccounts;
    }

    public void enableTwoFactorAuth() {
        this.twoFactorAuthEnabled = true;
    }

    public void disableTwoFactorAuth() {
        this.twoFactorAuthEnabled = false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", document='" + document + '\'' +
                ", password='" + password + '\'' +
                ", twoFactorAuthEnabled=" + twoFactorAuthEnabled +
                ", createdAt=" + createdAt +
                ", companyAccountCount=" + (companyAccounts != null ? companyAccounts.size() : 0) +
                '}';
    }
}
