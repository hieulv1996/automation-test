package weekThree;

import utils.DatetimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Applications {
    static SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {
        studentInformation();
    }

    static void studentInformation() {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Student student;

        for (int i = 1; i < 2; i++) {
            System.out.println("Input Borrow date: ");
            String borrowDate = scanner.nextLine();

            System.out.println("Input name: ");
            String name = scanner.nextLine();
            System.out.println("Input book title: ");
            String bookTitle = scanner.nextLine();
            student = new Student(i, borrowDate, name, bookTitle);
            students.add(student);
        }
        scanner = new Scanner(System.in);
        System.out.println("Input No.: ");
        int no = scanner.nextInt();

        for (int i = 1; i <= students.size(); i++) {
            if (students.get(i - 1).getNo() == no) {
                student = students.get(i - 1);
                try {
                    Date borrowDate = mSimpleDateFormat.parse(student.getBorrowDate());
                    int fee = getFee(borrowDate);
                    if (fee > 0) {
                        fee = fee * 100;
                        System.out.println("Hoc sinh " + students.get(i - 1).getName() +
                                " muon sach " + students.get(i - 1).getBookTitle() + ". Phi dong phat la " + fee + " nghin dong.");
                    } else {
                        System.out.println("Hoc sinh " + students.get(i - 1).getName() +
                                " muon sach " + students.get(i - 1).getBookTitle());
                    }

                } catch (Exception e) {
                    System.out.println("Invalid duration.");
                }
                break;
            }
            if (i == students.size()) {
                System.out.println("Can not found student with no " + no);
            }
        }
    }

    /**
     * <h2>Get fee when the book is borrow expiry date.</h2>
     * <p>1. Get months duration between borrow date and current date.</p>
     * <p>2. Calculator expiry fee when months duration more than 3 months, if it has expired over 1 day, months duration is plussed 1 month.</p>
     *<br/>
     * @param borrowDate
     * @return
     */
    public static int getFee(Date borrowDate) {
        // 1. Get months duration between borrow date and current date.
        LocalDate localDateBorrow = DatetimeUtils.convertToLocalDateViaInstant(borrowDate);
        int borrowDay = localDateBorrow.getDayOfMonth();

        LocalDate localCurrentDate = DatetimeUtils.convertToLocalDateViaInstant(new Date());
        int currentDay = localCurrentDate.getDayOfMonth();

        long monthsBetween = ChronoUnit.MONTHS.between(
                localDateBorrow.withDayOfMonth(1),
                localCurrentDate.withDayOfMonth(1));

        // 2. Calculator expiry fee when months duration more than 3 months,
        // if it has expired over 1 day, months duration is plussed 1 month.
        int fee = 0;
        if (monthsBetween == 3) {
            if (currentDay > borrowDay) {
                fee = 1;
            }
        } else if (monthsBetween > 3) {
            if (currentDay > borrowDay) {
                monthsBetween = monthsBetween + 1;
            }
            fee = (int) monthsBetween - 3;
        }
        return fee;
    }

}


