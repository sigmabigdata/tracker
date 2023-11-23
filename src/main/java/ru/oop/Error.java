package ru.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Компьютер включен: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Ошибка: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 1, "Отказ системы");
        Error error2 = new Error();
        error.printInfo();
        System.out.println();
        error2.printInfo();
    }
}
