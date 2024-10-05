package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.*;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionDAO {
    private final Connection connection;
    private final WalletDAO walletDAO;

    public TransactionDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
        walletDAO = new WalletDAO();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Transaction parseTransaction(ResultSet rs) throws SQLException {
        UUID id = UUID.fromString(rs.getString("id"));
        UUID fromWalletId = UUID.fromString(rs.getString("from_wallet_id"));
        UUID toWalletId = UUID.fromString(rs.getString("to_wallet_id"));
        TransactionType transactionType = TransactionType.valueOf(rs.getString("transaction_type"));
        BigDecimal quantity = rs.getBigDecimal("quantity");
        BigDecimal priceAtTransaction = rs.getBigDecimal("price_at_transaction");
        LocalDateTime transactionDate = rs.getTimestamp("transaction_date").toLocalDateTime();

        Wallet fromWallet = walletDAO.findById(fromWalletId);
        Wallet toWallet = walletDAO.findById(toWalletId);

        return new Transaction(id, transactionType, quantity, priceAtTransaction, fromWallet, toWallet,transactionDate);
    }

    public void register(Transaction transaction) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO t_tio_patinhas_transactions (id,transaction_type,quantity, price_at_transaction, transaction_date, from_wallet_id, to_wallet_id) VALUES (?,?,?,?,?,?,?)");

        stm.setString(1, transaction.getId().toString());
        stm.setObject(2, transaction.getTransactionType());
        stm.setBigDecimal(3, transaction.getQuantity());
        stm.setBigDecimal(4, transaction.getPriceAtTransaction());
        stm.setTimestamp(5, Timestamp.valueOf(transaction.getTransactionDate()));
        stm.setString(6, transaction.getFromWallet().getId().toString());
        stm.setString(7, transaction.getToWallet().getId().toString());

        stm.executeUpdate();
    }

    public Transaction findById(UUID id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM t_tio_patinhas_transactions WHERE id = ?");
        stm.setString(1, id.toString());

        ResultSet rs = stm.executeQuery();

        if (!rs.next()) {
            throw new SQLException("Wallet not found");
        }

        return parseTransaction(rs);
    }

    public List<Transaction> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM t_tio_patinhas_transactions");
        ResultSet rs = stm.executeQuery();
        List<Transaction> transactions = new ArrayList<>();

        while (rs.next()) {
            transactions.add(parseTransaction(rs));
        }

        return transactions;
    }

    public void delete(UUID id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM t_tio_patinhas_transactions WHERE id = ?");
        stm.setString(1, id.toString());

        int line = stm.executeUpdate();

        if (line == 0) {
            throw new SQLException("Transaction not found to be removed.");
        }
    }
}
