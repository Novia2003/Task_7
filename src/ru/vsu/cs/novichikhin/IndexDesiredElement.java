package ru.vsu.cs.novichikhin;

public class IndexDesiredElement {
    public int[]  array;
    public int n;

    public IndexDesiredElement (int[] array, int n) {
        this.array = array;
        this.n = n;
    }

    public int findIndexDesiredElement(int[] array, int n) {
        int indexMaximumElement = findIndexArrayMaximumElement(array);
        int indexN = findIndexN(array, n);
        if (indexN != -1) {
            if (Math.abs(indexN - indexMaximumElement) > 1) {
                return findIndexMinimum(indexN, indexMaximumElement, array);
            } else {
                if (Math.abs(indexN - indexMaximumElement) == 1) {
                    System.out.print("Последний максимальный элемент массива и ");
                    System.out.printf("%s-й чётный элемент массива расположены рядом.\n", n);
                } else {
                    System.out.print("Последний максимальный элемент амассива и ");
                    System.out.printf("%s-й чётный элемент массива совпадают.\n", n);
                }
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
            System.out.printf("Не существует %s-ого чётного элемента массива.\n", n);
            return -1;
        } else {
            while (n > index) {
                if (array[a] % 2 == 0) {
                    index++;
                }
                a++;
            }
        }
        return index;
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
