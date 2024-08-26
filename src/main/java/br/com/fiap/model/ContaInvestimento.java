package br.com.fiap.model;

import java.util.ArrayList;

public class ContaInvestimento extends Conta2 {
    private ArrayList<Ativo> ativos = new ArrayList<>();

    public void adicionarAtivo(Ativo ativo) {
        ativos.add(ativo);
    }

    public void removerAtivo(Ativo ativo) {
        ativos.removeIf(item -> ativo.getIdAtivo() == item.getIdAtivo() );
    }
}
