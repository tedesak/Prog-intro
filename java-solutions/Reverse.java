import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class Reverse {
    public static void main(String[] args) {
        try {
            MyScanner sc = new MyScanner(System.in);
            try {
                int maxStr = 0, a = 0;
                ArrayList <int []> mat = new ArrayList<>();
                while (sc.hasNext()) {
                    boolean newStr = false;
                    int [] mas = new int [1];
                    while (!newStr) {
                        a = sc.readWithoutChange();
                        if (a < 0) {
                            break;
                        }
                        while (Character.isWhitespace(a) && !newStr) {
                            sc.read();
                            int b = sc.readWithoutChange();
                            newStr = a == '\n' || a == '\r';
                            if (a == '\r' && b == '\n') {
                                newStr = true;
                                sc.read();
                            }
                            a = sc.readWithoutChange();
                        }
                        if (newStr) {
                            break;
                        }
                        mas[0]++;
                        if(mas[0] == mas.length){
                            int [] masNew = new int [mas[0] * 2];
                            for (int i = 0; i != mas[0]; i++){
                                masNew[i] = mas[i];
                            }
                            mas = masNew;
                        }
                        mas[mas[0]] = sc.nextInt();
                    }
                    mat.add(mas);
                    if(mas[0] > maxStr){
                        maxStr = mas[0];
                    }
                }
                for (int i = mat.size() - 1; i != -1; i--) {
                    for (int j = mat.get(i)[0]; j != 0; j--) {
                        System.out.print(mat.get(i)[j] + " ");
                    }
                    System.out.println();
                }
            } finally {
                sc.close();
            }
        } catch (IOException e) {
            System.out.println("I/O error" + e.getMessage());
        } 
    }
}