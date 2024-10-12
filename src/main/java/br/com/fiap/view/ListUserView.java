package br.com.fiap.view;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.model.User;

import java.sql.SQLException;
import java.util.List;

public class ListUserView {
    public static void execute(UserDAO dao) throws SQLException {
        List<User> users = dao.getAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
