package ru.ex;

public class FindMaxLength {
    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (String element : shops) {
            if (element != null) {
                max = Math.max(element.length(), max);
            }
        }
        System.out.println("Max length : " + max);
    }
}