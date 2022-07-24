package weekOne;

import java.util.Scanner;

public class avgGrade {
    public static void main(String[] args) {
        System.out.println("Input the number student in class: ");
        Scanner scanner = new Scanner(System.in);
        int numStudent = scanner.nextInt();
        int total = 0;
        for (int i=0; i< numStudent; i++){
            System.out.println("Input grade of student "+(i+1));
            while (true) {
                int grade = scanner.nextInt();
                if (grade < 0 || grade > 100) {
                    System.out.println("Invalid grade, try again...");
                    continue;
                }
                total += grade;
                break;
            }
        }
        System.out.println("AVG Grade is: " + total/numStudent);

    }
}
