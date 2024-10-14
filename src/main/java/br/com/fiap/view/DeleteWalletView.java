package br.com.fiap.view;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.dao.WalletDAO;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class DeleteWalletView {
    public static void execute(Scanner sc, WalletDAO walletDAO) throws SQLException {

        ListWalletView.execute(walletDAO);

        System.out.print("Enter user id: ");
        String id = sc.nextLine();
        UUID uuid = UUID.fromString(id);
        walletDAO.delete(uuid);
    }
}
