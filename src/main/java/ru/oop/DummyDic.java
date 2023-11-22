package ru.oop;

public class DummyDic {
   public String engToRus(String eng) {
       String word = "Неизвестное слово. " + eng;
       return word;
   }

    public static void main(String[] args) {
    DummyDic word = new DummyDic();
        System.out.println(word.engToRus("Dog"));
    }
}
