package utils;

import java.util.Arrays;

public class SortUtils {
    public static int[] sortWithForLoop(int[] arrs) {
        System.out.println("Start sortWithForLoop with arrs: " + Arrays.toString(arrs));
        try {
            for (int i = 0; i < arrs.length; i++) {
                for (int j = i + 1; j < arrs.length; j++) {
                    int tmp = 0;
                    if (arrs[i] > arrs[j]) {
                        tmp = arrs[i];
                        arrs[i] = arrs[j];
                        arrs[j] = tmp;
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println("Has an error when sortWithForLoop: " + exception.getMessage());
        }
        return arrs;
    }

    public static int[] sortWithWhileLoop(int[] arrs) {
        System.out.println("Start sortWithWhileLoop with arrs: " + Arrays.toString(arrs));
        try {
            for (int i = 1; i < arrs.length; i++) {
                int j = i;
                int a = arrs[i];
                while ((j > 0) && (arrs[j - 1] > a)) {
                    arrs[j] = arrs[j - 1];
                    j--;
                }
                arrs[j] = a;
            }
        } catch (Exception exception) {
            System.out.println("Has an error when sortWithWhileLoop: " + exception.getMessage());
        }
        return arrs;
    }

    public static int[] sortWithSingleLoop(int[] arrs) {
        System.out.println("Start sortWithSingleLoop with arrs: " + Arrays.toString(arrs));
        try {
            int length = arrs.length;
            for (int j = 0; j < length - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                    j = -1;
                }
            }
        } catch (Exception exception) {
            System.out.println("Has an error when sortWithSingleLoop: " + exception.getMessage());
        }
        return arrs;
    }
}
