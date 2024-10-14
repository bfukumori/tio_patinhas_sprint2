package br.com.fiap.view;

import br.com.fiap.dao.CryptoAssetDAO;
import br.com.fiap.dao.WalletDAO;
import br.com.fiap.model.CryptoAsset;
import br.com.fiap.model.Wallet;

import java.sql.SQLException;
import java.util.List;

public class ListWalletView {
    public static void execute(WalletDAO walletDAO) throws SQLException {
        List<Wallet> wallets = walletDAO.getAll();
        for (Wallet wallet : wallets) {
            System.out.println(wallet);
        }
    }
}
