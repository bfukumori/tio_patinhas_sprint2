package br.com.fiap.view;

import br.com.fiap.dao.TransactionDAO;
import br.com.fiap.dao.WalletDAO;
import br.com.fiap.model.Transaction;
import br.com.fiap.model.TransactionType;
import br.com.fiap.model.Wallet;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class CreateTransactionView {
    public static void execute(Scanner sc, WalletDAO walletDAO, TransactionDAO transactionDAO) throws SQLException {
        System.out.print("Enter from wallet ID (UUID): ");
        UUID fromWalletId = UUID.fromString(sc.nextLine());
        Wallet fromWallet = walletDAO.findById(fromWalletId);

        System.out.print("Enter to wallet ID (UUID): ");
        UUID toWalletId = UUID.fromString(sc.nextLine());
        Wallet toWallet = walletDAO.findById(toWalletId);

        System.out.print("Enter transaction type (BUY/SELL/TRANSFER): ");
        TransactionType transactionType = TransactionType.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Enter quantity: ");
        BigDecimal quantity = new BigDecimal(sc.nextLine());
        System.out.print("Enter price at transaction: ");
        BigDecimal priceAtTransaction = new BigDecimal(sc.nextLine());

        Transaction transaction = new Transaction(transactionType, quantity, priceAtTransaction, fromWallet, toWallet);

        transactionDAO.register(transaction);

        System.out.println("Transaction added: " + transaction);
    }
}
