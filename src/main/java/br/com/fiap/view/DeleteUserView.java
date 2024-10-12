package br.com.fiap.view;

import br.com.fiap.dao.UserDAO;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class DeleteUserView {
    public static void execute(Scanner sc, UserDAO dao) throws SQLException {

        ListUserView.execute(dao);

        System.out.print("Enter user id: ");
        String id = sc.nextLine();
        UUID uuid = UUID.fromString(id);
        dao.delete(uuid);
    }
}
