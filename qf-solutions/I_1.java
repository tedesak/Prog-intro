import java.util.Scanner;

public class HW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number, xLeft, xRight, yLeft, yRight, thisX, thisY, thisHeight;
        number = scanner.nextInt();
        thisX = scanner.nextInt();
        thisY = scanner.nextInt();
        thisHeight = scanner.nextInt();
        xLeft = thisX - thisHeight;
        xRight = thisX + thisHeight;
        yLeft = thisY - thisHeight;
        yRight = thisY + thisHeight;
        for (int index = 1; index != number; index++) {
            thisX = scanner.nextInt();
            thisY = scanner.nextInt();
            thisHeight = scanner.nextInt();
            if (xLeft > thisX - thisHeight) {
                xLeft = thisX - thisHeight;
            }
            if (xRight < thisX + thisHeight) {
                xRight = thisX + thisHeight;
            }
            if (yLeft > thisY - thisHeight) {
                yLeft = thisY - thisHeight;
            }
            if (yRight < thisY + thisHeight) {
                yRight = thisY + thisHeight;
            }
        }
        System.out.print((xLeft + xRight) / 2 + " " + (yLeft + yRight) / 2 + " ");
        if (xRight - xLeft > yRight - yLeft) {
            System.out.print((xRight - xLeft + 1) / 2);
        }
        else {
            System.out.print((yRight - yLeft + 1) / 2);
        }
        scanner.close();
    }
}