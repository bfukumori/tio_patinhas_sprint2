package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.User;
import br.com.fiap.utils.PasswordUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDAO {
    private final Connection connection;

    public UserDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private User parseUser(ResultSet rs) throws SQLException {
        UUID id = UUID.fromString(rs.getString("id"));
        String name = rs.getString("name");
        String email = rs.getString("email");
        String document = rs.getString("document");
        boolean twoFactorAuthEnabled = rs.getInt("twoFactorAuthEnabled") == 1;

        return new User(id, name, email, document, twoFactorAuthEnabled);
    }

    public void register(User user, String password) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO t_tio_patinhas_users (id, name, email, document, password) VALUES (?, ?, ?, ?, ?)");

        stm.setString(1, user.getId().toString());
        stm.setString(2, user.getName());
        stm.setString(3, user.getEmail());
        stm.setString(4, user.getDocument());
        stm.setString(5, PasswordUtils.hashPassword(password));

        stm.executeUpdate();
    }

    public User findByEmail(String email) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT id,name,email,document FROM t_tio_patinhas_users WHERE email = ?");
        stm.setString(1, email);

        ResultSet rs = stm.executeQuery();

        if (!rs.next()) {
            throw new SQLException("User not found");
        }

        return parseUser(rs);
    }

    public User findById(UUID id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT id,name,email,document,two_factor_auth_enabled FROM t_tio_patinhas_users WHERE id = ?");
        stm.setString(1, id.toString());

        ResultSet rs = stm.executeQuery();

        if (!rs.next()) {
            throw new SQLException("User not found");
        }

        return parseUser(rs);
    }

    public List<User> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT id,name,email,document, two_factor_auth_enabled FROM t_tio_patinhas_users");
        ResultSet rs = stm.executeQuery();
        List<User> users = new ArrayList<>();

        while (rs.next()) {
            users.add(parseUser(rs));
        }

        return users;
    }

    public void update(User user) throws SQLException {

        PreparedStatement stm = connection.prepareStatement("UPDATE t_tio_patinhas_users SET name = ?, email = ?, document = ?, two_factor_auth_enabled = ? WHERE id = ?");
        stm.setString(1, user.getName());
        stm.setString(2, user.getEmail());
        stm.setString(3, user.getDocument());
        stm.setInt(4, user.isTwoFactorAuthEnabled() ? 1 : 0);
        stm.setString(5, user.getId().toString());

        stm.executeUpdate();
    }

    public void delete(UUID id) throws SQLException {

        PreparedStatement stm = connection.prepareStatement("DELETE FROM t_tio_patinhas_users WHERE id = ?");
        stm.setString(1, id.toString());

        int line = stm.executeUpdate();

        if (line == 0) {
            throw new SQLException("User not found to be removed.");
        }
    }
}

