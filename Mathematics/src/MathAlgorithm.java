public class MathAlgorithm {
    public static void main(String[] args) {
        int a = (int) (Math.random() * 10000);
        int b = (int) (Math.random() * 10000);
        System.out.println("Алгоритм Евклида находения НОД через остаток от деления.");
        System.out.println("НОД(" + a + "," + b + ") = " + nodEvklidDivision(a, b));

        a = (int) (Math.random() * 10000);
        b = (int) (Math.random() * 10000);
        System.out.println("Алгоритм Евклида находения НОД через вычитание.");
        System.out.println("НОД(" + a + "," + b + ") = " + nodEvklidSubtraction(a, b));

        a = (int) (Math.random() * 10000);
        b = (int) (Math.random() * 10000);
        System.out.println("Бинарный алгоритм нахождения НОД.");
        System.out.println("НОД(" + a + "," + b + ") = " + nodBinary(a, b));


    }

//  Алгоритм Евклида находения НОД через остаток от деления.
//  Для избежания ошибок берем аргументы по модулю.
//  После чего проверяем различные типовые случаи.
//  Затем рекурентно запускаем алгоритм для меньшего элемента и остатка от деления меньшего на больший.
    private static int nodEvklidDivision(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == b) return a;

        if (a == 0) return b;

        if (b == 0) return a;

        if ((a == 1) || (b == 1)) return 1;

        if (a > b)
            return nodEvklidDivision(b, a % b);
        else
            return nodEvklidDivision(a, b % a);
    }

//  Алгоритм Евклида находения НОД через вычитание.
//  Для избежания ошибок берем аргументы по модулю.
//  После чего проверяем различные типовые случаи.
//  Затем рекурентно запускаем алгоритм для меньшего элемента и разницы между большим и меньшим аргументом.
    private static int nodEvklidSubtraction(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == b) return a;

        if (a == 0) return b;

        if (b == 0) return a;

        if ((a == 1) || (b == 1)) return 1;

        if (a > b)
            return nodEvklidSubtraction(b, a - b);
        else
            return nodEvklidSubtraction(a, b - a);
    }

//  Бинарный алгоритм нахождения НОД.
//  Для избежания ошибок берем аргументы по модулю.
//  После чего проверяем различные типовые случаи.
//  Затем рекурентно запускаем алгоритм следующим образом:
//  Если m, n чётные, то НОД(m, n) = 2*НОД(m/2, n/2);
//  Если m чётное, n нечётное, то НОД(m, n) = НОД(m/2, n);
//  Если n чётное, m нечётное, то НОД(m, n) = НОД(m, n/2);
//  Если m, n нечётные и n > m, то НОД(m, n) = НОД((n-m)/2, m);
//  Если m, n нечётные и n < m, то НОД(m, n) = НОД((m-n)/2, n);
    private static int nodBinary(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == b) return a;

        if (a == 0) return b;

        if (b == 0) return a;

        if ((a == 1) || (b == 1)) return 1;

        if ((a % 2 == 0) && (b % 2 == 0)) {
            return 2 * nodBinary(a / 2, b / 2);

        } else if (a % 2 == 0) {
            return nodBinary(a / 2, b);

        } else if (b % 2 == 0) {
            return nodBinary(a, b / 2);

        } else if (a > b) {
            return nodBinary((a - b) / 2, b);

        } else {
            return nodBinary(a, (b - a) / 2);

        }
    }

}
