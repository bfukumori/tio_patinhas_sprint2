package br.com.fiap.model;

import java.math.BigDecimal;

public class Conta2 {
    private BigDecimal saldo;
    private long numeroConta;
    private Usuario usuario;

    public Conta2() {
    }

    public Conta2(String saldo, long numeroConta, Usuario usuario) {
        this.saldo = new BigDecimal(saldo);
        this.numeroConta = numeroConta;
        this.usuario = usuario;
    }

    public Conta2(BigDecimal saldo, long numeroConta, Usuario usuario) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.usuario = usuario;
    }

    public Conta2(String tipoConta, Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(long numeroConta) {
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

    public void transferir(Conta2 conta, BigDecimal valor) {
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