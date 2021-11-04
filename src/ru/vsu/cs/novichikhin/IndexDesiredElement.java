package ru.vsu.cs.novichikhin;

public class IndexDesiredElement {
    public int[] array;
    public int n;

    public IndexDesiredElement(int[] array, int n) {
        this.array = array;
        this.n = n;
    }

    public int findIndexDesiredElement(int[] array, int n) {
        int indexMaximumElement = findIndexArrayMaximumElement(array);
        int indexN = findIndexN(array, n);
        if (indexN != -1) {
            if (Math.abs(indexN - indexMaximumElement) > 1) {
                return findIndexMinimum(indexN, indexMaximumElement, array);
            }
        }
        return -1;
    }

    private int findIndexArrayMaximumElement(int[] array) {
        int maximum = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (maximum <= array[i]) {
                maximum = array[i];
                index = i;
            }
        }
        return index;
    }

    private int findIndexN(int[] array, int n) {
        int quantityEvenElements = 0;
        int index = 0;
        int a = 0;
        for (int j : array) {
            if (j % 2 == 0) {
                quantityEvenElements += 1;
            }
        }
        if (quantityEvenElements < n) {
            return -1;
        } else {
            while (n > index) {
                if (array[a] % 2 == 0) {
                    index++;
                }
                a++;
            }
        }
        return a - 1;
    }

    private int findIndexMinimum(int n, int maximum, int[] array) {
        if (maximum < n) {
            int b = maximum;
            maximum = n;
            n = b;
        }
        int minimum = array[n + 1];
        int index = n + 1;
        if (maximum - n != 2) {
            for (int i = n + 1; i < maximum; i++) {
                if (minimum > array[i]) {
                    minimum = array[i];
                    index = i;
                }
            }
        }
        return index;
    }
}
