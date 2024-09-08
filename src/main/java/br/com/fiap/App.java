package br.com.fiap;

import br.com.fiap.model.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    private static void exibirMenu() {
        System.out.println("""
                Menu Principal:\s
                1. Cadastrar Usuário
                2. Exibir Usuário
                3. Adicionar Saldo Conta Corrente
                4. Adicionar Saldo Conta Investimento
                5. Cadastrar Ativo
                6. Cadastrar Ordem
                7. Exibir Saldos
                8. Finalizar Programa
                """);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op;
        do {
            exibirMenu();
            op = sc.nextInt();
            switch (op) {
                case 1:
                    LocalDate dataNascimento = LocalDate.of(1990, 5, 15);
                    Usuario user = new Usuario("Fulano", "Fulano@gmail.com","Ful@no123", dataNascimento, 12345678902L,81999998888L);

            }
        } while (op != 8);

    }


}
