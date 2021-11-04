package ru.vsu.cs.novichikhin;

import java.util.Arrays;

public class MainTest {
    public TestResult getTestes() {
        System.out.println("Проведём тестерование работы программы:");
        TestCase[] test = getCases();
        for (int i = 0; i < test.length; i++) {
            IndexDesiredElement index = new IndexDesiredElement(test[i].array, test[i].n);
            printTest(test, i, index);
            if (index.findIndexDesiredElement(test[i].array, test[i].n) != test[i].result) {
                return new TestResult(false);
            }
        }
        return new TestResult(true);
    }

    private TestCase[] getCases() {
        TestCase case1 = new TestCase(new int[]{2, 25, 12, 135, 9}, 1, 2);
        TestCase case2 = new TestCase(new int[]{96, 3, 45, 65, 2, 89}, 1, -1);
        TestCase case3 = new TestCase(new int[]{6, 78, 200, 14, 36, 18, 26}, 6, 3);
        TestCase case4 = new TestCase(new int[]{1, 55, 9, 37, 89, 43}, 3, -1);
        TestCase case5 = new TestCase(new int[]{2, 5, 93, 57, 39, 601}, 1, 1);
        TestCase case6 = new TestCase(new int[]{4, 52, 1, 95, 8, 46, 60, 23}, 12, -1);
        TestCase case7 = new TestCase(new int[]{8, 15, 19, 84, 92, 56, 79, 43, 11, 54, 908, 295}, 3, 8);
        TestCase case8 = new TestCase(new int[]{408, 55, 81, 9, 12, 409}, 2, -1);
        TestCase case9 = new TestCase(new int[]{609, 596, 609, 34, 89}, 2, -1);
        TestCase case10 = new TestCase(new int[]{9, 550, 56, 98, 37, 89, 36, 550}, 3, 6);
        return new TestCase[]{case1, case2, case3, case4, case5, case6, case7, case8, case9, case10};
    }

    private void printTest(TestCase[] test, int i, IndexDesiredElement index) {
        System.out.printf("Для массива: %s, с номером n-ого члена: %s\n", Arrays.toString(test[i].array), test[i].n);
        System.out.printf("Программа выведет: %s. ", index.findIndexDesiredElement(test[i].array, test[i].n));
        System.out.printf("Правильный ответ: %s\n", test[i].result);
        System.out.println();
        System.out.println("*****************************************************************************************");
        System.out.println();
    }
}