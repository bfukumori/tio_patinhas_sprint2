package br.com.fiap.view;

import br.com.fiap.dao.CryptoAssetDAO;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class DeleteCryptoAssetView {
    public static void execute(Scanner sc, CryptoAssetDAO dao) throws SQLException {

        ListCryptoAssetView.execute(dao);

        System.out.print("Enter asset id: ");
        String id = sc.nextLine();
        UUID uuid = UUID.fromString(id);
        dao.delete(uuid);
    }
}
