package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftarr = left.split("/");
        String[] rightarr = right.split("/");
        int result = rightarr[0].compareTo(leftarr[0]);
        if (result != 0) {
            return result;
        }

        for (int i = 1; i < Math.min(leftarr.length, rightarr.length); i++) {
            result = leftarr[i].compareTo(rightarr[i]);
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(leftarr.length, rightarr.length);
    }
}
