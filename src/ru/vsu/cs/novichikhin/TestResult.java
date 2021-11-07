package ru.vsu.cs.novichikhin;

public class TestResult {
    boolean isProgramCorrect;
    int[] array;
    int n;

    public TestResult(boolean isProgramCorrect, int[] array, int n) {
        this.isProgramCorrect = isProgramCorrect;
        this.array = array;
        this.n = n;
    }

    public boolean getIsProgramCorrect() {
        return isProgramCorrect;
    }

    public int[] getArray() {
        return array;
    }

    public int getN() {
        return n;
    }
}

