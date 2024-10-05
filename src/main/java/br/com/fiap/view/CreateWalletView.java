package br.com.fiap.view;

import br.com.fiap.dao.CompanyAccountDAO;
import br.com.fiap.dao.CryptoAssetDAO;
import br.com.fiap.dao.WalletDAO;
import br.com.fiap.model.CompanyAccount;
import br.com.fiap.model.CryptoAsset;
import br.com.fiap.model.Wallet;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class CreateWalletView {
    public static void execute(Scanner sc, CompanyAccountDAO companyAccountDAO, CryptoAssetDAO cryptoAssetDAO, WalletDAO walletDao) throws SQLException {
        System.out.print("Enter company account ID (UUID): ");
        UUID companyAccountId = UUID.fromString(sc.nextLine());

        CompanyAccount companyAccount = companyAccountDAO.findById(companyAccountId);

        System.out.print("Enter crypto asset ID (UUID): ");
        UUID cryptoAssetId = UUID.fromString(sc.nextLine());

        CryptoAsset cryptoAsset = cryptoAssetDAO.findById(cryptoAssetId);

        Wallet wallet = new Wallet(companyAccount, cryptoAsset);

        walletDao.register(wallet);

        System.out.println("Wallet created: " + wallet);
    }
}
