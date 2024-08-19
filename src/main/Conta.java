package main;

import java.math.BigDecimal;

public class Conta {
    private BigDecimal saldo;
    private long numeroConta;
    private Usuario usuario;

    public Conta() {
    }

    public Conta(String saldo, long numeroConta, Usuario usuario) {
        this.saldo = new BigDecimal(saldo);
        this.numeroConta = numeroConta;
        this.usuario = usuario;
    }

    public Conta(BigDecimal saldo, long numeroConta, Usuario usuario) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.usuario = usuario;
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
