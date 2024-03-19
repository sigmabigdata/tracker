package ru.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();

        for (String department : departments) {
            String[] codes = department.split("/");
            StringBuilder current = new StringBuilder();

            for (String code : codes) {
                current.append(code);
                temp.add(current.toString());
                current.append("/");
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        Collections.sort(departments);
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}
