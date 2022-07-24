package weekOne;

import org.apache.commons.lang3.StringUtils;
import utils.SortUtils;

import java.util.Arrays;
import java.util.Scanner;

public class WeeklyHomework {
    public static void main(String[] args) {
        int[] inputIntArray;
        do {
            System.out.println("Input array to sort: ");
            Scanner scanner = new Scanner(System.in);
            String inputData = scanner.nextLine();

            if (StringUtils.isEmpty(inputData)) {
                System.out.println("Input data is empty or null");
            }

            String[] inputDataArray = StringUtils.split(inputData, ",");
            try {
                inputIntArray = Arrays.stream(inputDataArray).mapToInt(Integer::parseInt).toArray();
                break;
            } catch (Exception exception) {
                System.out.println("Has String value in array input.");
            }
        } while (true);
        SortUtils.sortWithSingleLoop(inputIntArray);
        SortUtils.sortWithForLoop(inputIntArray);
        SortUtils.sortWithWhileLoop(inputIntArray);
        System.out.println("Array ordered: " + Arrays.toString(inputIntArray));
    }
}
