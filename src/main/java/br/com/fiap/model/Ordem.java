package br.com.fiap.model;

import java.util.Date;

public class Ordem {
    int idOrdem;
    String tipo;
    Date data;
    float montante;
    String status;

    public Ordem(int idOrdem, String tipo, float montante, String status) {
        this.idOrdem = idOrdem;
        this.tipo = tipo;
        this.montante = montante;
        this.status = status;
        this.data = new Date();
    }

    public int getIdOrdem() {
        return idOrdem;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getData() {
        return data;
    }

    public float getMontante() {
        return montante;
    }

    public String getStatus() {
        return status;
    }

    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setData() {
        this.data = new Date();
    }

    public void setMontante(float montante) {
        this.montante = montante;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
