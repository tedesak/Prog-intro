import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class HW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberTrans, numQuer, sumA = 0, lastIndex;
        numberTrans = scanner.nextInt();
        int[] mas = new int[numberTrans];
        for (int index = 0; index != numberTrans; index++) {
            mas[index] = scanner.nextInt();
            sumA += mas[index];
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
            while (true) {
                numberGroup++;
                firstIndexNextQuery += splitNum;
                if (firstIndexNextQuery >= sumA) {
                    System.out.println(numberGroup);
                    break;
                }
                firstIndexNextQuery = numTrans[firstIndexNextQuery] > 0 ? mas[numTrans[firstIndexNextQuery] - 1] : 0;
                if (numberActualTrans >= numTrans[firstIndexNextQuery] - 1) {
                    System.out.println("Impossible");
                    break;
                }
                numberActualTrans = numTrans[firstIndexNextQuery] - 1;
            }
        }
        scanner.close();
    }
}