package ru.pojo;

public class College extends Student {

    public static void main(String[] args) {
        College student = new College();
        student.setStudentName("Иванов Иван");
        student.setGroup(115698);
        student.setYear(2018);

        System.out.println("Студент " + student.getStudentName() + " из группы " + student.getGroup() + " поступил в " + student.getYear() + " году.");
    }
}
