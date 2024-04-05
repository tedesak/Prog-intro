import java.util.Scanner;

public class HW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        for (int index = 0; index != height; index++) {
            System.out.println((index - 25000) * 710);
        }
        scanner.close();
    }
}