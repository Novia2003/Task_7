package ru.vsu.cs.novichikhin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int quantityArrayElements = readNumber(0);
        checkNumberPositive(quantityArrayElements);

        int[] array = new int[quantityArrayElements];

        readArrayElements(array);

        int n = readNumber(1);
        checkNumberPositive(n);

        int indexDesiredElement = findIndexDesiredElement(array, n);

        printIndexDesiredElement(indexDesiredElement, array, n);
    }

    static int readNumber(int number) {
        Scanner scanner = new Scanner(System.in);
        if (number == 0) {
            System.out.print("Введите количество элементов массива: ");
        }
        System.out.print("Введите номер n-ого чётного элемента массива: ");
        return scanner.nextInt();
    }

    static void checkNumberPositive(int number) {
        if (number <= 0) {
            System.out.print("Данные введены неверно (число должно быть больше 0)");
            System.exit(1);
        }
    }

    static void readArrayElements(int[] array) {
        System.out.println("Введите элементы массива: ");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
    }

    static int findIndexDesiredElement(int[] array, int n) {
        int indexMaximumElement = findIndexArrayMaximumElement(array);
        int indexN = findIndexN(array, n);
        if (indexN != -1 && Math.abs(indexN - indexMaximumElement) > 1) {
            return findIndexMinimum(indexN, indexMaximumElement, array);
        }
        return -1;
    }

    static int findIndexArrayMaximumElement(int[] array) {
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

    static int findIndexN(int[] array, int n) {
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
        return index;
    }

    static int findIndexMinimum(int n, int maximum, int[] array) {
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

    static void printIndexDesiredElement(int index, int[] array, int n) {
        if (index != -1) {
            System.out.printf("Минимальный элемент - элемент с индексом %s, расположенный между последним " +
                    "максимальным элементом массива и %s-ым четным элементом и равен %s", index, n, array[index]);
        } else {
            System.out.printf("Минимальный элемент, расположенный между последним максимальным элементом массива и " +
                    "%s-ым четным элементом, найти нельзя", n);
        }
    }
}