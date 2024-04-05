import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class HW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberTest = scanner.nextInt();
        for ( ; numberTest != 0; numberTest--) {
            int numberDays, numTripl = 0;
            numberDays = scanner.nextInt();
            Map<Integer, Integer> numberKEl = new HashMap<>();
            int[] mas = new int[numberDays];
            for (int index = 0; index != numberDays; index++) {
                mas[index] = scanner.nextInt();
            }
            for (int jIndex = numberDays - 1; jIndex != -1; jIndex--) {
                for (int iIndex = 0; iIndex != jIndex; iIndex++) {
                    if (numberKEl.containsKey(2 * mas[jIndex] - mas[iIndex])) {
                        numTripl += numberKEl.get(2 * mas[jIndex] - mas[iIndex]);
                    }
                }
                numberKEl.put(mas[jIndex], numberKEl.containsKey(mas[jIndex]) ? numberKEl.get(mas[jIndex]) + 1 : 1);
            }
            System.out.println(numTripl);
        }
        scanner.close();
    }
}