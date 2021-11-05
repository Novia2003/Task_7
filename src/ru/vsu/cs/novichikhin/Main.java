package ru.vsu.cs.novichikhin;

import java.util.Arrays;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MainTest test = new MainTest();

        TestResult result = test.getTestes();
        printResultTest(result.GetIsProgramCorrect(), result.getArray(), result.getN());

        if (result.GetIsProgramCorrect()) {

            int quantityArrayElements = readNumber(0);
            checkNumberPositive(quantityArrayElements);

            int[] array = new int[quantityArrayElements];

            readArrayElements(array);

            int n = readNumber(1);
            checkNumberPositive(n);

            IndexDesiredElement index = new IndexDesiredElement(array, n);

            printDesiredElement(array, n, index);
        }
    }

    private static void printResultTest(boolean result, int[] array, int n) {
        if (result) {
            System.out.println("Тестирование завершено. Программа работает исправно.");
        } else {
            System.out.printf("Обнаружена ошибка при выполнениии теста для массива: %s, и n: %s. ",
                    Arrays.toString(array), n);
            System.out.println("Программа работает неправильно");
        }
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

    private static void printDesiredElement(int[] array, int n, IndexDesiredElement index) {
        if (index.findIndexDesiredElement(array, n) != -1) {
            System.out.print("Минимальный элемент, расположенный между последним максимальным элементом массива и ");
            System.out.printf("%s-ым четным элементом - элемент с индексом %s равный %s\n", n,
                    index.findIndexDesiredElement(array, n), array[index.findIndexDesiredElement(array, n)]);
        } else {
            System.out.print("Минимальный элемент, расположенный между последним максимальным элементом массива и ");
            System.out.printf("%s-ым четным элементом, найти нельзя.\n", n);
        }
    }
}
