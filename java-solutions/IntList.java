public class IntList {
    private int[] mas;
    private int masSize;
    private int lastEl;
    IntList() {
        mas = new int[2];
        masSize = 2;
        lastEl = -1;
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

    int getEl(int ind) {
        return mas[ind];
    }

    boolean setEl(int ind, int x) {
        if (ind <= lastEl) {
            mas[ind] = x;
        }
        return ind <= lastEl;
    }

    boolean setLastEl(int x) {
        if (lastEl >= 0) {
            mas[lastEl] = x;
        }
        return lastEl >= 0;
    }
    
    boolean inc(int ind) {
        if (ind <= lastEl) {
            mas[ind] += 1;
        }
        return ind <= lastEl;
    }
}