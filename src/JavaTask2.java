import java.util.Scanner;

public class JavaTask2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Вызов step1
        step1();

        // Ввод и вызов step2
        System.out.print("Введите номер месяца (1-12): ");
        int month = sc.nextInt();
        step2(month);

        // Ввод и вызов step3
        System.out.print("Введите коэффициенты квадратного уравнения (a b c): ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);
    }

    static void step1() {
        int N = 5;
        int number = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }

    static void step2(int month) {
        String monthName;

        switch (month) {
            case 1:  monthName = "январь"; break;
            case 2:  monthName = "февраль"; break;
            case 3:  monthName = "март"; break;
            case 4:  monthName = "апрель"; break;
            case 5:  monthName = "май"; break;
            case 6:  monthName = "июнь"; break;
            case 7:  monthName = "июль"; break;
            case 8:  monthName = "август"; break;
            case 9:  monthName = "сентябрь"; break;
            case 10: monthName = "октябрь"; break;
            case 11: monthName = "ноябрь"; break;
            case 12: monthName = "декабрь"; break;
            default:
                System.out.println("Нет такого месяца");
                return;
        }

        System.out.println(monthName);
    }

    static void step3(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double sqrtD = Math.sqrt(discriminant);
            double x1 = (-b + sqrtD) / (2 * a);
            double x2 = (-b - sqrtD) / (2 * a);
            System.out.println("Корни уравнения: " + x1 + " и " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Единственный корень уравнения: " + x);
        } else {
            System.out.println("Корней нет");
        }
    }
}

