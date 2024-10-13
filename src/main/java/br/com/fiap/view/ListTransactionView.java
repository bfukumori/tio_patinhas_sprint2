package br.com.fiap.view;

import br.com.fiap.dao.CompanyAccountDAO;
import br.com.fiap.dao.TransactionDAO;
import br.com.fiap.model.CompanyAccount;
import br.com.fiap.model.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ListTransactionView {
    public static void execute(TransactionDAO transactionDAO) throws SQLException {
        List<Transaction> transactions = transactionDAO.getAll();
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
