package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User findPassport = findByPassport(passport);
        if (findPassport != null) {
            users.get(findPassport).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User passportFind : users.keySet()) {
            if (passport.equals(passportFind.getPassport()))
                return passportFind;
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account found : accounts) {
                if (found.getRequisite().equals(requisite)) {
                    result = found;
                }
            }
        }
        return result;
    }


    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account user1 = findByRequisite(srcPassport, srcRequisite);
        Account user2 = findByRequisite(destPassport, destRequisite);
        if (user1 != null && user2 != null && user1.getBalance() > 0) {
            double user1Balance = user1.getBalance();
            double user2Balance = user2.getBalance();
            amount = user1Balance + user2Balance;
            user2.setBalance(amount);
        }
        return rsl;
    }
}