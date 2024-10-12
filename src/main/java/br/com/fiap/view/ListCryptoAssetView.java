package br.com.fiap.view;

import br.com.fiap.dao.CryptoAssetDAO;
import br.com.fiap.model.CryptoAsset;

import java.sql.SQLException;
import java.util.List;

public class ListCryptoAssetView {
    public static void execute(CryptoAssetDAO dao) throws SQLException {
        List<CryptoAsset> assets = dao.getAll();
        for (CryptoAsset asset : assets) {
            System.out.println(asset);
        }
    }
}
