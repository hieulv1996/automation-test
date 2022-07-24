package weekOne;

import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        System.out.println("Input limit number: ");
        Scanner scanner = new Scanner(System.in);
        int limitNumber = scanner.nextInt();
        float i = 0;
        float total = 0;
        do{
            i = i+1;
            total =total + i;
            if(total > limitNumber){
                total = total - i;
                float avg = total/(i-1);
                System.out.println("Total: " + total + " AVG: " + avg);
                break;
            }
        }while (total <= limitNumber);
    }
}
