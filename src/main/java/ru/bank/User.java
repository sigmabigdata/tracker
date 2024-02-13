package ru.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка. Эта модель содержит поля: номер паспорта и ФИО.
 *
 * @author ANATOLIY DYRUL
 * @version 1.0
 */

public class User {
    /**
     * Поле содержит номер паспорта.
     */
    private String passport;
    /**
     * Поле содержит ФИО пользователя банка.
     */
    private String username;

    /**
     * Конструктор объекта - пользователя банка.
     *
     * @param passport номер паспорта пользователя банка.
     * @param username ФИО пользователя банка.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
