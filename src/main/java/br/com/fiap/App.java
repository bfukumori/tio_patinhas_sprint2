package br.com.fiap;

import br.com.fiap.model.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        List<CompanyAccount> companyAccounts = new ArrayList<>();
        List<CryptoAsset> cryptoAssets = new ArrayList<>();
        List<Wallet> wallets = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create User");
            System.out.println("2. Create Company Account");
            System.out.println("3. Create Crypto Asset");
            System.out.println("4. Create Wallet");
            System.out.println("5. Add Transaction");
            System.out.println("6. List All");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createUser(users);
                    break;
                case 2:
                    createCompanyAccount(users, companyAccounts);
                    break;
                case 3:
                    createCryptoAsset(cryptoAssets);
                    break;
                case 4:
                    createWallet(companyAccounts, cryptoAssets, wallets);
                    break;
                case 5:
                    addTransaction(wallets);
                    break;
                case 6:
                    listAll(users, companyAccounts, cryptoAssets, wallets);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void createUser(List<User> users) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user email: ");
        String email = scanner.nextLine();
        System.out.print("Enter user document: ");
        String document = scanner.nextLine();
        System.out.print("Enter user password: ");
        String password = scanner.nextLine();

        User user = new User(name, email,document, password);
        users.add(user);
        System.out.println("User created: " + user);
    }

    private static void createCompanyAccount(List<User> users, List<CompanyAccount> companyAccounts) {
        System.out.print("Enter user ID (UUID): ");
        UUID userId = UUID.fromString(scanner.nextLine());

        User owner = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        if (owner == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter company name: ");
        String companyName = scanner.nextLine();

        CompanyAccount companyAccount = new CompanyAccount(owner, companyName);
        companyAccounts.add(companyAccount);
        owner.getCompanyAccounts().add(companyAccount);
        System.out.println("Company account created: " + companyAccount);
    }

    private static void createCryptoAsset(List<CryptoAsset> cryptoAssets) {
        System.out.print("Enter asset name: ");
        String assetName = scanner.nextLine();
        System.out.print("Enter symbol: ");
        String symbol = scanner.nextLine();
        System.out.print("Enter current price: ");
        BigDecimal currentPrice = new BigDecimal(scanner.nextLine());

        CryptoAsset cryptoAsset = new CryptoAsset(assetName, symbol, currentPrice);
        cryptoAssets.add(cryptoAsset);
        System.out.println("Crypto asset created: " + cryptoAsset);
    }

    private static void createWallet(List<CompanyAccount> companyAccounts, List<CryptoAsset> cryptoAssets, List<Wallet> wallets) {
        System.out.print("Enter company account ID (UUID): ");
        UUID companyAccountId = UUID.fromString(scanner.nextLine());

        CompanyAccount companyAccount = companyAccounts.stream().filter(ca -> ca.getId().equals(companyAccountId)).findFirst().orElse(null);
        if (companyAccount == null) {
            System.out.println("Company account not found.");
            return;
        }

        System.out.print("Enter crypto asset ID (UUID): ");
        UUID cryptoAssetId = UUID.fromString(scanner.nextLine());

        CryptoAsset cryptoAsset = cryptoAssets.stream().filter(ca -> ca.getId().equals(cryptoAssetId)).findFirst().orElse(null);
        if (cryptoAsset == null) {
            System.out.println("Crypto asset not found.");
            return;
        }

        Wallet wallet = new Wallet(companyAccount, cryptoAsset, BigDecimal.ZERO);
        companyAccount.addWallet(wallet);
        wallets.add(wallet);
        System.out.println("Wallet created: " + wallet);
    }

    private static void addTransaction(List<Wallet> wallets) {
        System.out.print("Enter from wallet ID (UUID): ");
        UUID fromWalletId = UUID.fromString(scanner.nextLine());

        Wallet fromWallet = wallets.stream().filter(w -> w.getId().equals(fromWalletId)).findFirst().orElse(null);
        if (fromWallet == null) {
            System.out.println("From wallet not found.");
            return;
        }

        System.out.print("Enter to wallet ID (UUID): ");
        UUID toWalletId = UUID.fromString(scanner.nextLine());

        Wallet toWallet = wallets.stream().filter(w -> w.getId().equals(toWalletId)).findFirst().orElse(null);
        if (toWallet == null) {
            System.out.println("To wallet not found.");
            return;
        }

        System.out.print("Enter transaction type (BUY/SELL/TRANSFER): ");
        TransactionType transactionType = TransactionType.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter quantity: ");
        BigDecimal quantity = new BigDecimal(scanner.nextLine());
        System.out.print("Enter price at transaction: ");
        BigDecimal priceAtTransaction = new BigDecimal(scanner.nextLine());
        Timestamp transactionDate = Timestamp.valueOf(LocalDateTime.now());

        Transaction transaction = new Transaction(transactionType, quantity, priceAtTransaction, transactionDate, fromWallet, toWallet);
        fromWallet.addTransaction(transaction);
        toWallet.addTransaction(transaction);

        System.out.println("Transaction added: " + transaction);
    }

    private static void listAll(List<User> users, List<CompanyAccount> companyAccounts, List<CryptoAsset> cryptoAssets, List<Wallet> wallets) {
        System.out.println("Users:");
        users.forEach(System.out::println);
        System.out.println("Company Accounts:");
        companyAccounts.forEach(System.out::println);
        System.out.println("Crypto Assets:");
        cryptoAssets.forEach(System.out::println);
        System.out.println("Wallets:");
        wallets.forEach(System.out::println);
    }
}
