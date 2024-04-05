import java.util.Scanner;

public class HW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenShort, lenLong, lenAll;
        lenShort = scanner.nextInt();
        lenLong = scanner.nextInt();
        lenAll = scanner.nextInt();
        System.out.print(2 * ((lenAll - lenShort - 1) / (lenLong - lenShort)) + 1);
        scanner.close();
    }
}