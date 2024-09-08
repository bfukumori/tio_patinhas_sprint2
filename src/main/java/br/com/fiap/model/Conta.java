package br.com.fiap.model;

import java.math.BigDecimal;


public class Conta {
    private BigDecimal saldo;
    private String numeroConta;
    private Usuario usuario;
    public Conta() {
    }

    public Conta(String saldo, String numeroConta, Usuario usuario) {
        this.saldo = new BigDecimal(saldo);
        this.numeroConta = numeroConta;
        this.usuario = usuario;
    }

    public Conta(BigDecimal saldo, String numeroConta, Usuario usuario) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.usuario = usuario;
    }

    public Conta(String tipoConta, String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    public void sacar(BigDecimal valor) {
        saldo = saldo.subtract(valor);
    }

    public void transferir(Conta conta, BigDecimal valor) {
        saldo = saldo.subtract(valor);
        conta.depositar(valor);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                ", numeroConta=" + numeroConta +
                '}';
    }
}