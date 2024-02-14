package ru.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String department : departments) {
            String[] subDep = department.split("/");
            String code = subDep[0];
            temp.add(code);
            for (int i = 1; i < subDep.length; i++) {
                code += "/" + subDep[i];
                temp.add(code);
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
