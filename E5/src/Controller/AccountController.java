package Controller;

import Entity.Account;

import java.util.List;

public class AccountController {
    private static List<Account> accounts;

    public AccountController(List<Account> accounts) {
        AccountController.accounts = accounts;
    }

    public List<Account> searchByIDorName(String keyword) {
        return accounts.stream()
                .filter(account -> String.valueOf(account.getId_Account()).toLowerCase().contains(keyword) ||
                        account.getName().toLowerCase().contains(keyword))
                .toList();
    }


}