package ru.job4j.bank;

import java.util.*;
import java.util.Optional;

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
        Optional<User> findPassport = findByPassport(passport);
        if (findPassport.isPresent()) {
            List<Account> accounts = users.get(findPassport.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счёт пользователя по реквизитам.
     * @param passport поиск по паспорту.
     * @param requisite сравнение по реквизитам.
     * @return возвращает найденный счёт.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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