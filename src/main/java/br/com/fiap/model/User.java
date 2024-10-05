package br.com.fiap.model;

import br.com.fiap.utils.CpfUtils;

import java.util.UUID;

public class User {

    private final UUID id;
    private String name;
    private String email;
    private String document;
    private boolean twoFactorAuthEnabled = false;

    public User(UUID id, String name, String email, String document, boolean twoFactorAuthEnabled) {
        this.id = id;
        this.name = name;
        this.email = email;
        setDocument(document);
        this.twoFactorAuthEnabled = twoFactorAuthEnabled;
    }

    public User(String name, String email, String document) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        setDocument(document);
    }

    public UUID getId() {
        return id;
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
        if (CpfUtils.isValidCpf(document)) {
            this.document = CpfUtils.removeFormatting(document);
        } else {
            throw new IllegalArgumentException("CPF inválido.");
        }
    }

    public boolean isTwoFactorAuthEnabled() {
        return twoFactorAuthEnabled;
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
                ", document='" + CpfUtils.formatCpf(document) + '\'' +
                ", twoFactorAuthEnabled=" + twoFactorAuthEnabled +
                '}';
    }
}
