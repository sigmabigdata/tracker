package ru.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета. Эта модель содержит поля: баланс и реквизиты
 */
public class Account {
    /**
     * Поле содержит номер счета
     */
    private String requisite;
    /**
     * Поле содержит баланс
     */
    private double balance;

    /**
     * Конструктор модели банковского счета, включает в себя параметры : баланс и реквизиты.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
