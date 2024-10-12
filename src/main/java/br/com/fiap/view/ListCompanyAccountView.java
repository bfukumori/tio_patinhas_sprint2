package br.com.fiap.view;

import br.com.fiap.dao.CompanyAccountDAO;
import br.com.fiap.model.CompanyAccount;

import java.sql.SQLException;
import java.util.List;

public class ListCompanyAccountView {
    public static void execute(CompanyAccountDAO companyAccountDAO) throws SQLException {
        List<CompanyAccount> accounts = companyAccountDAO.getAll();
        for (CompanyAccount account : accounts) {
            System.out.println(account);
        }
    }
}
