import java.util.Random;
import java.util.Scanner;

public class JavaTask3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ввод размерности матрицы
        System.out.print("Введите размерность матрицы n: ");
        int n = sc.nextInt();

        // Вызов step1 для создания матрицы
        int[][] matrix = step1(n);

        // Вызов step2 для вычисления суммы между первыми двумя положительными элементами
        int sum = step2(matrix);
        System.out.println("Сумма элементов между первыми двумя положительными элементами каждой строки: " + sum);

        // Вызов step3 для удаления строк и столбцов с максимальным элементом
        matrix = step3(matrix);

        // Вывод окончательной матрицы
        System.out.println("Окончательная матрица:");
        printMatrix(matrix);
    }

    // Метод для создания и возврата матрицы
    static int[][] step1(int n) {
        Random rand = new Random();
        int[][] matrix;
        boolean containsN = false;
        boolean containsNegN = false;

        do {
            matrix = new int[n][n];
            containsN = false;
            containsNegN = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = rand.nextInt(2 * n + 1) - n;
                    if (matrix[i][j] == n) {
                        containsN = true;
                    }
                    if (matrix[i][j] == -n) {
                        containsNegN = true;
                    }
                }
            }
        } while (!containsN || !containsNegN);

        // Вывод матрицы на консоль
        System.out.println("Сгенерированная матрица:");
        printMatrix(matrix);

        return matrix;
    }

    // Метод для вычисления суммы элементов между первыми двумя положительными элементами
    static int step2(int[][] arr) {
        int totalSum = 0;

        for (int[] row : arr) {
            int firstPositiveIndex = -1;
            int secondPositiveIndex = -1;

            // Найти первые два положительных элемента в строке
            for (int j = 0; j < row.length; j++) {
                if (row[j] > 0) {
                    if (firstPositiveIndex == -1) {
                        firstPositiveIndex = j;
                    } else if (secondPositiveIndex == -1) {
                        secondPositiveIndex = j;
                        break;
                    }
                }
            }

            // Если оба положительных элемента найдены, вычислить сумму между ними
            if (firstPositiveIndex != -1 && secondPositiveIndex != -1 && secondPositiveIndex > firstPositiveIndex) {
                int sum = 0;
                for (int k = firstPositiveIndex + 1; k < secondPositiveIndex; k++) {
                    sum += row[k];
                }
                totalSum += sum;
            }
        }

        return totalSum;
    }

    // Метод для удаления строк и столбцов, содержащих максимальный элемент
    static int[][] step3(int[][] arr) {
        int max = Integer.MIN_VALUE;

        // Найти максимальный элемент
        for (int[] row : arr) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }

        // Найти строки и столбцы, содержащие максимальный элемент
        boolean[] rowsToDelete = new boolean[arr.length];
        boolean[] colsToDelete = new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    rowsToDelete[i] = true;
                    colsToDelete[j] = true;
                }
            }
        }

        // Создать новую матрицу без строк и столбцов с максимальным элементом
        int newRowCount = 0;
        for (boolean delete : rowsToDelete) {
            if (!delete) newRowCount++;
        }
        int newColCount = 0;
        for (boolean delete : colsToDelete) {
            if (!delete) newColCount++;
        }

        int[][] newMatrix = new int[newRowCount][newColCount];
        int newRow = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!rowsToDelete[i]) {
                int newCol = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    if (!colsToDelete[j]) {
                        newMatrix[newRow][newCol] = arr[i][j];
                        newCol++;
                    }
                }
                newRow++;
            }
        }

        // Вывод измененной матрицы на консоль
        System.out.println("Матрица после удаления строк и столбцов с максимальным элементом:");
        printMatrix(newMatrix);

        return newMatrix;
    }

    // Метод для вывода матрицы на консоль
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
