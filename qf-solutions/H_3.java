import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class HW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberTrans, numQuer, sumA = 0, lastIndex, maxEl = 0;
        numberTrans = scanner.nextInt();
        Map<Integer, Integer> safeRes = new HashMap<>();
        int[] mas = new int[numberTrans];
        for (int index = 0; index != numberTrans; index++) {
            mas[index] = scanner.nextInt();
            sumA += mas[index];
            if (maxEl < mas[index]) {
                maxEl = mas[index];
            }
        }
        int[] numTrans = new int[sumA];
        lastIndex = 0;
        for (int index1 = 0; index1 != numberTrans; index1++) {
            for (int index2 = 0; index2 != mas[index1]; index2++) {
                numTrans[lastIndex] = index1;
                lastIndex++;
            }
            if (index1 != 0) {
                mas[index1] += mas[index1 - 1];
            }
        }
        numQuer = scanner.nextInt();
        for (int index = 0; index != numQuer; index++) {
            int splitNum, numberActualTrans = -1, numberGroup = 0, firstIndexNextQuery = 0;
            splitNum = scanner.nextInt();
            if(safeRes.containsKey(splitNum)) {
                if(safeRes.get(splitNum) == -1) {
                    System.out.println("Impossible");
                }
                else {
                    System.out.println(safeRes.get(splitNum));
                }
                continue;
            }
            if (splitNum < maxEl) {
                safeRes.put(splitNum,-1);

                System.out.println("Impossible");
                continue;
            }
            while (true) {
                numberGroup++;
                firstIndexNextQuery += splitNum;
                if (firstIndexNextQuery >= sumA) {
                    System.out.println(numberGroup);
                    break;
                }
                firstIndexNextQuery = mas[numTrans[firstIndexNextQuery] - 1];
                numberActualTrans = numTrans[firstIndexNextQuery] - 1;
            }
            safeRes.put(splitNum, numberGroup);
        }
        scanner.close();
    }
}