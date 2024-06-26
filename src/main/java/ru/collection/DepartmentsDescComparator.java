package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArr = left.split("/");
        String[] rightArr = right.split("/");
        int result = rightArr[0].compareTo(leftArr[0]);
        if (result != 0) {
            return result;
        }

        for (int i = 1; i < Math.min(leftArr.length, rightArr.length); i++) {
            result = leftArr[i].compareTo(rightArr[i]);
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(leftArr.length, rightArr.length);
    }
}
