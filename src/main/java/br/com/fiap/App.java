package br.com.fiap;

import br.com.fiap.dao.*;
import br.com.fiap.view.*;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        UserDAO userDao;
        CompanyAccountDAO companyAccountDao;
        CryptoAssetDAO cryptoAssetDao;
        TransactionDAO transactionDao;
        WalletDAO walletDAO;

        try {
            userDao = new UserDAO();
            companyAccountDao = new CompanyAccountDAO();
            cryptoAssetDao = new CryptoAssetDAO();
            transactionDao = new TransactionDAO();
            walletDAO = new WalletDAO();


            int option;

            do {
                menu();
                option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        CreateUserView.execute(sc, userDao);
                        break;
                    case 2:
                        CreateCompanyAccountView.execute(sc, userDao, companyAccountDao);
                        break;
                    case 3:
                        CreateCryptoAssetView.execute(sc, cryptoAssetDao);
                        break;
                    case 4:
                        CreateWalletView.execute(sc, companyAccountDao, cryptoAssetDao, walletDAO);
                        break;
                    case 5:
                        CreateTransactionView.execute(sc, walletDAO, transactionDao);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } while (option != 0);
            userDao.closeConnection();
            companyAccountDao.closeConnection();
            cryptoAssetDao.closeConnection();
            transactionDao.closeConnection();
            walletDAO.closeConnection();
        } catch (SQLException e) {
            System.err.println("Error connecting to the database" + e.getMessage());
        }
    }

    private static void menu() {
        System.out.println("Menu:");
        System.out.println("1. Create User");
        System.out.println("2. Create Company Account");
        System.out.println("3. Create Crypto Asset");
        System.out.println("4. Create Wallet");
        System.out.println("5. Create Transaction");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
}

