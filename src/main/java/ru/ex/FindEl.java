package ru.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                return index;
            }
        }
        throw new ElementNotFoundException("Такого индекса не существует");
    }

    public static void main(String[] args) {
        String[] array = {"One", "Two", "Six", "Five"};
        try {
            int index = indexOf(array, "Six");
            System.out.println("Индекс элемента: " + index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
