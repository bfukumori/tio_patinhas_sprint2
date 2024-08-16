package tiopatinhas.models;

public class Conta {
    private String tipoConta;
    private String numeroConta;

    public String getTipoConta() {
        return tipoConta;
    }

    public Conta setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
        return this;
    }

    public Conta(String tipoConta, String numeroConta) {
        this.tipoConta = tipoConta;
        this.numeroConta = numeroConta;
    }
}
