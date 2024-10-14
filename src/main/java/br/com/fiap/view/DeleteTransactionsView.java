package br.com.fiap.view;

import br.com.fiap.dao.TransactionDAO;
import br.com.fiap.dao.UserDAO;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class DeleteTransactionsView {
    public static void execute(Scanner sc, TransactionDAO transactionDAO) throws SQLException {

        ListTransactionView.execute(transactionDAO);

        System.out.print("Enter user id: ");
        String id = sc.nextLine();
        UUID uuid = UUID.fromString(id);
        transactionDAO.delete(uuid);
    }
}
