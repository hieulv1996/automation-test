package weekTwo;

import utils.DatetimeUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Applications {
    static SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {
        studentInformation();
    }

    static void studentInformation() {
        ArrayList<StudentInformation> studentInformations = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        StudentInformation studentInformation;

        for (int i = 1; i < 2; i++) {
            System.out.println("Input first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Input last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Input date of birth: ");
            String dob = scanner.nextLine();
            studentInformation = new StudentInformation(i, firstName, lastName, dob);
            studentInformations.add(studentInformation);
        }
        scanner = new Scanner(System.in);
        System.out.println("Input No.: ");
        int no = scanner.nextInt();

        for (int i = 1; i <= studentInformations.size(); i++) {
            if (studentInformations.get(i - 1).getNo() == no) {
                studentInformation = studentInformations.get(i - 1);
                try {
                    Date studentDob = mSimpleDateFormat.parse(studentInformation.getDob());
                    Long daysBetween = DatetimeUtils.getDateDuration(studentDob);
                    System.out.println(daysBetween);
                } catch (Exception e) {
                    System.out.println("Date of birth in invalid.");
                }
                System.out.println("Date of birth of " + studentInformations.get(i).getLastName() + " is " + studentInformations.get(i).getDob()
                        + " and ");
                break;
            }
            if (i == studentInformations.size()) {
                System.out.println("Can not found student with no " + no);
            }
        }
    }

    static void animal() {
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            Animal animal;
            System.out.println("Input name: ");
            String name = scanner.nextLine();
//            animal.setName(name);
            System.out.println("Input color: ");
            String color = scanner.nextLine();
//            animal.setColor(color);

            animal = new Animal(name, color);
            animals.add(animal);
        }
        animals.forEach(x -> System.out.println(x.getName() + " is " + x.getColor()));
//        for (int j = 0; j < animals.size(); j++){
//            System.out.println(animals.get(j).getName() + " is " + animals.get(j).getColor());
//        }
    }
}
