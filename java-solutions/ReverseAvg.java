import java.util.Scanner;
import java.util.ArrayList;

public class ReverseAvg {
    public static void main(String[] args) {
        int maxStr = 0;
        Scanner sc = new Scanner(System.in);
        ArrayList <int []> mat = new ArrayList<>();
        while (sc.hasNextLine()){
            Scanner str = new Scanner(sc.nextLine());
            int [] mas = new int [1];
            while (str.hasNextInt()){
                mas[0]++;
                if(mas[0] == mas.length){
                    int [] masNew = new int [mas[0] * 2];
                    for (int i = 0; i != mas[0]; i++){
                        masNew[i] = mas[i];
                    }
                    mas = masNew;
                }
                mas[mas[0]] = str.nextInt();
            }
            if(mas[0] > maxStr){
                maxStr = mas[0];
            }
            mat.add(mas);
        }
        long [] sumStr = new long [mat.size()];
        long [] sumKol = new long [maxStr], kKol = new long [maxStr];
        for (int i = 0; i != mat.size(); i++){
            for (int j = 0; j != mat.get(i)[0]; j++){
                sumStr[i] += mat.get(i)[j + 1];
                sumKol[j] += mat.get(i)[j + 1];
                kKol[j]++;
            }
        }
        for (int i = 0; i != mat.size(); i++){
            for (int j = 0; j != mat.get(i)[0]; j++){
                System.out.print((sumStr[i] + sumKol[j] - mat.get(i)[j + 1]) / (kKol[j] + mat.get(i)[0] - 1));
                System.out.print(" ");
            }
            System.out.println();
        }
        sc.close();
    }
}