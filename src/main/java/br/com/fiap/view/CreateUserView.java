package br.com.fiap.view;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateUserView {
    public static void execute(Scanner sc, UserDAO dao) throws SQLException {
        System.out.print("Enter user name: ");
        String name = sc.nextLine();

        System.out.print("Enter user email: ");
        String email = sc.nextLine();

        System.out.print("Enter user document: ");
        String document = sc.nextLine();

        System.out.print("Enter user password: ");
        String password = sc.nextLine();

        User user = new User(name, email, document);

        dao.register(user, password);

        System.out.println("User created: " + user);
    }
}
