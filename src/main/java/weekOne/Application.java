package weekOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Input string: ");
        Scanner scanner = new Scanner(System.in);
        String aString = scanner.nextLine();
        aString = aString.toLowerCase(Locale.ROOT);
        String[] stringSplit = aString.split(" ");
        Arrays.sort(stringSplit);
        int count=0;
        ArrayList<String> duplicateText = new ArrayList<>();

        for (int i = 0; i < stringSplit.length; i++){
            if(i< stringSplit.length - 1 && stringSplit[i].equals(stringSplit[i+1]) && !duplicateText.contains(stringSplit[i])){
                System.out.println(stringSplit[i]);
                duplicateText.add(stringSplit[i]);
                count++;
            }
        }
        System.out.println("The number of duplicate text is "+count);

    }

}
