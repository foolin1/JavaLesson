import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class JavaTask1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество элементов массива: ");
        int n = sc.nextInt();

        int[] array = new int[n];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        step1(array);
        step2(array);
        step3(array);
    }

    static void step1(int[] array) {
        if (array.length == 0) {
            System.out.println("Массив пуст.");
            return;
        }

        int min = array[0];
        int max = array[0];

        for (int value : array) {
            if (value < min) min = value;
            if (value > max) max = value;
        }

        System.out.println(min + " " + max);
    }

    static void step2(int[] array) {
        if (array.length == 0) {
            System.out.println("Массив пуст.");
            return;
        }

        double sum = 0;
        for (int value : array) {
            sum += value;
        }

        double average = sum / array.length;

        System.out.println("Числа меньше среднего арифметического:");
        for (int value : array) {
            if (value < average) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }

    static void step3(int[] array) {
        if (array.length == 0) {
            System.out.println("Массив пуст.");
            return;
        }

        int min = array[0];
        List<Integer> minIndices = new ArrayList<>();

        // Найти минимальное значение и все его индексы
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndices.clear();
                minIndices.add(i);
            } else if (array[i] == min) {
                minIndices.add(i);
            }
        }

        // Вывести индексы в порядке убывания
        System.out.println("Индексы самого маленького числа в порядке убывания:");
        for (int i = minIndices.size() - 1; i >= 0; i--) {
            System.out.print(minIndices.get(i) + " ");
        }
        System.out.println();
    }
}
