package ru.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковской системы, посволяющей:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 *
 * @author ANATOLIY DYRUL
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех пользователей осуществляется в коллекции HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Этот метод принимает один параметр: пользователя, т.е. объект класса User. По умолчанию к этому user добавляется пустой список - new ArrayList<Account>().
     * В методе есть быть проверка, что такого пользователя еще нет в системе. Когда он есть, то новый пользователь не добаляется.
     *
     * @param user пользователь банковской системы.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод, который позволяет удалить пользователя из системы по номеру паспорта.
     *
     * @param passport номер паспорта пользователя банковской системы.
     */
    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    /**
     * Метод добавляет новый счет к пользователю
     *
     * @param passport номер паспорта пользователя банковской системы
     * @param account  счет, который необходимо добавить.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = getAccounts(user);
        if (user != null && !accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     *
     * @param passport номер паспорта пользователя банковской системы.
     * @return возвразащает найденного пользователя. Если пользователь не найден возвращается null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * Изначально метод ищет пользователя по паспорту с помощью метода findByPassport.
     * Потом получяет список счетов этого пользователя и в нем находит нужный счет.
     * Прежде чем получать список аккаунтов, метод проверяет что метод findByPassport вернул отличное от null значение
     *
     * @param passport  номер паспорта пользователя банковской системы.
     * @param requisite номер счета пользователя банковской системы
     * @return возвращает счет пользователя банковской системы либо, если счет не найден возвращает null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * Если счёт не найден или не хватает денег на счёте sourcePassport (с которого переводят), то метод должен вернуть false.
     * Метод putIfAbsent позволяет проверить, если ли такой ключ в карте или нет и если его нет, то произвести вставку данных.
     * Метод List.contains позволяет проверить содержит ли наш список элемент, который мы передаем в качестве аргумента в этот метод.
     * При этом метод возвращает true, когда в списке такой элемент присутствует, а иначе метод вернет false.
     * Для модели данных, объекты которой хранятся в этом списке
     * переопределены методы equals() и hashcode().
     *
     * @param sourcePassport       номер паспорта пользователя со счета которого делается денежный перевод
     * @param sourceRequisite      счет пользователя с которого делается денежный перевод
     * @param destinationPassport  номер паспорта пользователя на счет которого делается денежный перевод
     * @param destinationRequisite номер счета пользователя, которому делается денежный перевод
     * @param amount               остаток денежных средств
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null &&
                destinationAccount != null &&
                sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
