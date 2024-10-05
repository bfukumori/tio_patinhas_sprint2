package br.com.fiap.view;

import br.com.fiap.dao.CryptoAssetDAO;
import br.com.fiap.model.CryptoAsset;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateCryptoAssetView {
    public static void execute(Scanner sc, CryptoAssetDAO dao) throws SQLException {
        System.out.print("Enter asset name: ");
        String assetName = sc.nextLine();
        System.out.print("Enter symbol: ");
        String symbol = sc.nextLine();
        System.out.print("Enter current price: ");
        BigDecimal currentPrice = new BigDecimal(sc.nextLine());

        CryptoAsset cryptoAsset = new CryptoAsset(assetName, symbol, currentPrice);

        dao.register(cryptoAsset);
        System.out.println("Crypto asset created: " + cryptoAsset);
    }
}
