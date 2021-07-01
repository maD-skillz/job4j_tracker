package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы, которая хранит в себе список пользоватлей, их
 * аккаунты, паспорта, реквизиты, также имеется возможность перевода средств по реквизитам.
 * @author EGOR POPOV
 * @version 1.0
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Этот метод добавляет пользователя в систему.
     * @param user добавляет пользователя.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Этот метод добавляет новый счёт к пользователю, находя его по паспорту.
     * @param passport поиск паспорта.
     * @param account добавляет счёт.
     */
    public void addAccount(String passport, Account account) {
        User findPassport = findByPassport(passport);
        if (findPassport != null) {
            List<Account> accounts = users.get(findPassport);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * @param passport поиск паспорта.
     * @return возвращает найденный паспорт.
     */
    public User findByPassport(String passport) {
        for (User passportFind : users.keySet()) {
            if (passport.equals(passportFind.getPassport())) {
                return passportFind;
            }
        }
        return null;
    }

    /**
     * Метод ищет счёт пользователя по реквизитам.
     * @param passport поиск по паспорту.
     * @param requisite сравнение по реквизитам.
     * @return возвращает найденный счёт.
     */
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

    /**
     * Метод переводит деньги пользователя с одонго счёта на другой.
     * @param srcPassport паспорт отправителя.
     * @param srcRequisite реквизиты отправителя.
     * @param destPassport паспорт получателя.
     * @param destRequisite реквизиты получателя.
     * @param amount сумма сделки.
     * @return проверка на то, что сделка состоялась.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcUser = findByRequisite(srcPassport, srcRequisite);
        Account destUser = findByRequisite(destPassport, destRequisite);
        if (srcUser != null && destUser != null && srcUser.getBalance() >= amount) {
            destUser.setBalance(destUser.getBalance() + amount);
            srcUser.setBalance(srcUser.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}