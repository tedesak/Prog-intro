import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;
class IntList {
    private int[] mas;
    private int masSize;
    private int lastEl;
    IntList() {
        mas = new int[2];
        masSize = 2;
        lastEl = -1;
    }

    IntList(int len, int num) {
        mas = new int[len];
        masSize = len;
        lastEl = len - 1;
        for (int index = 0; index != len; index++) {
            mas[index] = num;
        }
    }
    private void updateMas() {
        int[] newMas = new int[masSize * 2];
        for (int i = 0; i != masSize; ++i) {
            newMas[i] = mas[i];
        }
        mas = newMas;
        masSize *= 2;
    }

    void pushBack(int x) {
        lastEl++;
        if (lastEl == masSize) {
            this.updateMas();
        }
        mas[lastEl] = x;
    }

    int size() {
        return lastEl + 1;
    }

    int get(int ind) {
        return mas[ind];
    }

    boolean set(int ind, int x) {
        if (ind <= lastEl) {
            mas[ind] = x;
        }
        return ind <= lastEl;
    }
}

public class HW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCity, numTeam, maxDist = 0, numMaxDist = 0;
        numCity = scanner.nextInt();
        numTeam = scanner.nextInt();
        int[] team = new int[numTeam];
        IntList dist = new IntList(numCity + 1, -10), prev =  new IntList(numCity + 1, -10);
        Queue<Integer> queue = new ArrayDeque<Integer>();
        IntList[] road = new IntList [numCity + 1];
        for (int index = 0; index != numCity + 1; index++) {
            road[index] = new IntList();
        }
        for (int index = 0; index != numCity - 1; index++) {
            int firstCity, secondCity;
            firstCity = scanner.nextInt();
            secondCity= scanner.nextInt();
            road[firstCity].pushBack(secondCity);
            road[secondCity].pushBack(firstCity);
        }
        for (int index = 0; index != numTeam; index++) {
            team[index] = scanner.nextInt();
        }
        if (numTeam == 1) {
            System.out.println("YES");
            System.out.print(team[0]);
            System.exit(0);
        }
        queue.add(team[0]);
        dist.set(team[0], 0);
        while (!queue.isEmpty()) {
            int actualEl = queue.remove();
            for (int index = 0; index != road[actualEl].size(); index++) {
                if (dist.get(road[actualEl].get(index)) == -10) {
                    dist.set(road[actualEl].get(index), dist.get(actualEl) + 1);
                    prev.set(road[actualEl].get(index), actualEl);
                    queue.add(road[actualEl].get(index));
                }
            }
        }
        for (int index = 0; index != numTeam; index++) {
            if (dist.get(team[index]) > maxDist) {
                maxDist = dist.get(team[index]);
                numMaxDist = team[index];
            }
        }
        if (maxDist % 2 == 1) {
            System.out.print("NO");
            System.exit(0);
        }
        for (int index = 0; index * 2 != maxDist; index++) {
            numMaxDist = prev.get(numMaxDist);
        }
        queue.add(numMaxDist);
        for (int index = 1; index != numCity + 1; index++) {
            dist.set(index, -10);
        }
        dist.set(numMaxDist, 0);
        while (!queue.isEmpty()) {
            int actualEl = queue.remove();
            for (int index = 0; index != road[actualEl].size(); index++) {
                if (dist.get(road[actualEl].get(index)) == -10) {
                    dist.set(road[actualEl].get(index), dist.get(actualEl) + 1);
                    queue.add(road[actualEl].get(index));
                }
            }
        }
        for (int index = 0; index != numTeam; index++) {
            if (dist.get(team[index]) != maxDist / 2) {
                System.out.print("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
        System.out.print(numMaxDist);
        scanner.close();
    }
}