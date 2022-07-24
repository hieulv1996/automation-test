package weekTwo;

public class Exercise4 {
    public static void main(String[] args) {
        int x = 2;
        int count = 0;
        while (x != 129) {
            x = x * 2;
            count++;
            x = x - 1;
            count++;
        }
        System.out.println(count);
    }
}
