import java.util.Arrays;

public class JavaTask4 {

    // Метод для сортировки одномерного массива (сортировка пузырьком)
    public static int[] step1(int[] array) {
        int[] sortedArray = array.clone();
        int n = sortedArray.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        return sortedArray;
    }

    // Метод для сортировки двумерного массива (сортировка строк)
    public static int[][] step2(int[][] array) {
        int[][] sortedArray = new int[array.length][];

        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i].clone();
            Arrays.sort(sortedArray[i]);
        }

        return sortedArray;
    }

    // Метод для умножения матрицы на вектор
    public static double[] mul(double[][] matrix, double[] vector) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (cols != vector.length) {
            throw new IllegalArgumentException("Matrix column count must match vector length.");
        }

        double[] result = new double[rows];

        for (int i = 0; i < rows; i++) {
            result[i] = 0;
            for (int j = 0; j < cols; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }

        return result;
    }

    // Метод для умножения двух матриц
    public static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        int rowsLeft = matrixLeft.length;
        int colsLeft = matrixLeft[0].length;
        int rowsRight = matrixRight.length;
        int colsRight = matrixRight[0].length;

        if (colsLeft != rowsRight) {
            throw new IllegalArgumentException("Number of columns in the left matrix must equal the number of rows in the right matrix.");
        }

        double[][] result = new double[rowsLeft][colsRight];

        for (int i = 0; i < rowsLeft; i++) {
            for (int j = 0; j < colsRight; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsLeft; k++) {
                    result[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }

        return result;
    }

    // Метод для замены 4-й и 7-й буквы на '#' в каждом слове текста
    public static String replace(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split("\\s+");

        for (String word : words) {
            if (word.length() >= 4) {
                StringBuilder wordBuilder = new StringBuilder(word);
                wordBuilder.setCharAt(3, '#');
                if (word.length() >= 7) {
                    wordBuilder.setCharAt(6, '#');
                }
                result.append(wordBuilder).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }

    // Метод для проверки, является ли слово палиндромом
    public static boolean isPalindrom(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        // Примеры использования методов

        // Пример сортировки одномерного массива
        int[] oneDimensionalArray = {64, 34, 25, 12, 22, 11, 90};
        int[] sortedOneDimensionalArray = step1(oneDimensionalArray);
        System.out.println("Sorted 1D array: " + Arrays.toString(sortedOneDimensionalArray));

        // Пример сортировки двумерного массива
        int[][] twoDimensionalArray = {
                {64, 34, 25},
                {12, 22, 11},
                {90, 70, 80}
        };
        int[][] sortedTwoDimensionalArray = step2(twoDimensionalArray);
        System.out.println("Sorted 2D array (by rows):");
        for (int[] row : sortedTwoDimensionalArray) {
            System.out.println(Arrays.toString(row));
        }

        // Пример умножения матрицы на вектор
        double[][] matrix = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0}
        };
        double[] vector = {1.0, 0.5, 2.0};
        double[] resultVector = mul(matrix, vector);
        System.out.println("Matrix-vector multiplication result: " + Arrays.toString(resultVector));

        // Пример умножения матриц
        double[][] matrixLeft = {
                {1.0, 2.0},
                {3.0, 4.0}
        };
        double[][] matrixRight = {
                {5.0, 6.0},
                {7.0, 8.0}
        };
        double[][] resultMatrix = mul(matrixLeft, matrixRight);
        System.out.println("Matrix-matrix multiplication result:");
        for (double[] row : resultMatrix) {
            System.out.println(Arrays.toString(row));
        }

        // Пример замены символов в тексте
        String text = "Hello world, this is a test message!";
        String replacedText = replace(text);
        System.out.println("Replaced text: " + replacedText);

        // Пример проверки палиндрома
        String palindrome = "racecar";
        String nonPalindrome = "hello";
        System.out.println("Is 'racecar' a palindrome? " + isPalindrom(palindrome));
        System.out.println("Is 'hello' a palindrome? " + isPalindrom(nonPalindrome));
    }
}
