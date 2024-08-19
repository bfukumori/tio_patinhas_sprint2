package br.com.fiap.model;

import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

public class Usuario {
    private UUID idUsuario;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dtNascimento;
    private long cpf;
    private long telefone;
    private List<Conta> contas;


    public UUID getIdUsuario() {
        return idUsuario;
    }

    public Usuario setIdUsusario(UUID idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public Usuario setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
        return this;
    }

    public long getCpf() {
        return cpf;
    }

    public Usuario setCpf(long cpf) {
        this.cpf = cpf;
        return this;
    }

    public long getTelefone() {
        return telefone;
    }

    public Usuario setTelefone(long telefone) {
        this.telefone = telefone;
        return this;
    }

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, LocalDate dtNascimento, long cpf, long telefone) {
        this.idUsuario = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public void alterarSenha(String senha) {
        setSenha(senha);
    }

    public Conta criarConta(String tipoConta) {
        String numeroConta = gerarNumeroConta();
        Conta novaConta = new Conta(tipoConta, numeroConta);
        contas.add(novaConta);
        return novaConta;
    }

    private String gerarNumeroConta() {
        String cpfString = String.valueOf(cpf);
        String ultimosQuatroDigitos = cpfString.substring(7);
        return idUsuario.toString().substring(0, 3) + ultimosQuatroDigitos;
    }

    public List<Conta> listarContas() {
        return contas;
    }

}
