package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.CompanyAccount;
import br.com.fiap.model.CryptoAsset;
import br.com.fiap.model.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WalletDAO {
    private final Connection connection;
    private final CompanyAccountDAO companyAccountDAO;
    private final CryptoAssetDAO cryptoAssetDAO;

    public WalletDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
        companyAccountDAO = new CompanyAccountDAO();
        cryptoAssetDAO = new CryptoAssetDAO();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Wallet parseWallet(ResultSet rs) throws SQLException {
        UUID id = UUID.fromString(rs.getString("id"));
        UUID companyAccountId = UUID.fromString(rs.getString("company_account_id"));
        UUID cryptoAssetId = UUID.fromString(rs.getString("crypto_asset_id"));

        CompanyAccount companyAccount = companyAccountDAO.findById(companyAccountId);
        CryptoAsset cryptoAsset = cryptoAssetDAO.findById(cryptoAssetId);

        return new Wallet(id, companyAccount, cryptoAsset);
    }

    public void register(Wallet wallet) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO t_tio_patinhas_wallets (id,company_account_id,crypto_asset_id) VALUES (?,?,?)");

        stm.setString(1, wallet.getId().toString());
        stm.setString(2, wallet.getCompanyAccount().getId().toString());
        stm.setString(3, wallet.getCryptoAsset().getId().toString());

        stm.executeUpdate();
    }

    public Wallet findById(UUID id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM t_tio_patinhas_wallets WHERE id = ?");
        stm.setString(1, id.toString());

        ResultSet rs = stm.executeQuery();

        if (!rs.next()) {
            throw new SQLException("Wallet not found");
        }

        return parseWallet(rs);
    }

    public List<Wallet> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM t_tio_patinhas_wallets");
        ResultSet rs = stm.executeQuery();
        List<Wallet> wallets = new ArrayList<>();

        while (rs.next()) {
            wallets.add(parseWallet(rs));
        }

        return wallets;
    }

    public void delete(UUID id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("DELETE FROM t_tio_patinhas_wallets WHERE id = ?");
        stm.setString(1, id.toString());

        int line = stm.executeUpdate();

        if (line == 0) {
            throw new SQLException("Wallet not found to be removed.");
        }
    }
}
