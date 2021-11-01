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

        IndexDesiredElement index = new IndexDesiredElement(array,n);

        printIndexDesiredElement(array, n, index);
    }

    private static int readNumber(int number) {
        Scanner scanner = new Scanner(System.in);
        if (number == 0) {
            System.out.print("Введите количество элементов массива: ");
        } else {
            System.out.print("Введите номер n-ого чётного элемента массива: ");
        }
        return scanner.nextInt();
    }

    private static void checkNumberPositive(int number) {
        if (number <= 0) {
            System.out.print("Данные введены неверно (число должно быть больше 0)");
            System.exit(1);
        }
    }

    private static void readArrayElements(int[] array) {
        System.out.println("Введите элементы массива: ");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Введите %s-й элемент массива: ", i + 1);
            array[i] = scanner.nextInt();
        }
    }

    private static void printIndexDesiredElement(int[] array, int n, IndexDesiredElement index) {
        if (index.findIndexDesiredElement(array, n)!= -1) {
            System.out.printf("Минимальный элемент - элемент с индексом %s, расположенный между последним \n",
                    index.findIndexDesiredElement(array, n));
            System.out.printf("максимальным элементом массива и %s-ым четным элементом и равен %s", n,
                    array[index.findIndexDesiredElement(array, n)]);
        } else {
            System.out.print("Минимальный элемент, расположенный между последним максимальным элементом массива и \n");
            System.out.printf("%s-ым четным элементом, найти нельзя.", n);
        }
    }
}
