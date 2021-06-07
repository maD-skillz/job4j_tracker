package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        ArrayList<Account> newUser = new ArrayList<>();
        if (!users.get(user).equals(newUser)) {
            users.put(user, newUser);
        }
    }

    public void addAccount(String passport, Account account) {
       User findPassport = findByPassport(passport);
       if (!findPassport.equals(users.get(account)))
        users.get(findPassport).add(account);
    }

    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (passport.equals(key))
            return key;
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        for (User user : users.keySet()) {
            List<Account> userList = users.get(user);
            if (userList.equals(requisite))
                return ;
        }
        return null;
    }



    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (!srcRequisite.contains("0")) {

        }
        return rsl;
    }
}