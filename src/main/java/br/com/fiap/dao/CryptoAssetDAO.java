package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.CryptoAsset;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CryptoAssetDAO {
    private final Connection connection;

    public CryptoAssetDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private CryptoAsset parseCryptoAsset(ResultSet rs) throws SQLException {
        UUID id = UUID.fromString(rs.getString("id"));
        String assetName = rs.getString("asset_name");
        String symbol = rs.getString("symbol");
        BigDecimal currentPrice = rs.getBigDecimal("current_price");


        return new CryptoAsset(id, assetName, symbol, currentPrice);
    }

    public void register(CryptoAsset cryptoAsset) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO t_crypto_assets (id,asset_name,symbol,current_price) VALUES (?,?,?,?)");

        stm.setString(1, cryptoAsset.getId().toString());
        stm.setString(2, cryptoAsset.getAssetName());
        stm.setString(3, cryptoAsset.getSymbol());
        stm.setBigDecimal(4, cryptoAsset.getCurrentPrice());

        stm.executeUpdate();
    }

    public CryptoAsset findById(UUID id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM t_crypto_assets WHERE id = ?");
        stm.setString(1, id.toString());

        ResultSet rs = stm.executeQuery();

        if (!rs.next()) {
            throw new SQLException("Crypto asset not found");
        }

        return parseCryptoAsset(rs);
    }

    public List<CryptoAsset> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM t_crypto_assets");
        ResultSet rs = stm.executeQuery();
        List<CryptoAsset> cryptoAssets = new ArrayList<>();

        while (rs.next()) {
            cryptoAssets.add(parseCryptoAsset(rs));
        }

        return cryptoAssets;
    }

    public void delete(UUID id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM t_crypto_assets WHERE id = ?");
        stm.setString(1, id.toString());

        int line = stm.executeUpdate();

        if (line == 0) {
            throw new SQLException("Crypto asset not found to be removed.");
        }
    }
}
