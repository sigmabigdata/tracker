package ru.pojo;

public class Shop {

    public static int indexOfNull(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            Product pr = products[i];
            if (products[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
