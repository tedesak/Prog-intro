import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class HW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberSpots;
        numberSpots = scanner.nextInt();
        int[][] mas = new int[numberSpots][numberSpots];
        for (int index1 = 0; index1 != numberSpots; index1++) {
            String line = scanner.next();
            for (int index2 = 0; index2 != numberSpots; index2++) {
                mas[index1][index2] = Character.getNumericValue(line.charAt(index2));
            }
        }
        for (int actualSpot = 0; actualSpot != numberSpots; actualSpot++) {
            for (int spot1 = actualSpot + 1; spot1 != numberSpots; spot1++) {
                if (mas[actualSpot][spot1] == 0) {
                    continue;
                }
                for (int spot2 = spot1 + 1; spot2 != numberSpots; spot2++) {
                    mas[actualSpot][spot2] = (mas[actualSpot][spot2] - mas[spot1][spot2] + 10) % 10;
                }
            }
        }
        for (int index1 = 0; index1 != numberSpots; index1++) {
            for (int index2 = 0; index2 != numberSpots; index2++) {
                System.out.print(mas[index1][index2]);
            }
            System.out.println();
        }
        scanner.close();
    }
}