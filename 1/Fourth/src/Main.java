/**
 * *+Задано уравнение вида q + w = e, q, w, e >= 0.
 * Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
 * Требуется восстановить выражение до верного равенства.
 * Предложить хотя бы одно решение или сообщить, что его нет.
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    // Ввод числа с консоли
    public static String numInputter() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    // Перевод введенного числа в массив чаров
    public static char[] addendChecker() {
        return numInputter().toCharArray();
    }

    // Проверка на число
    public static boolean numChecker(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            System.out.println("Not a number!");
            return false;
        }
    }

    // Проверка на число суммы в уравнении
    public static int sumChecker() {
        Scanner scan = new Scanner(System.in);
        String sum = scan.nextLine();
        try {
            if (Integer.parseInt(sum) >= 0) return Integer.parseInt(sum);
            else return sumChecker();
        } catch (Exception e) {
            System.out.println("Not a positive integer number!");
            return sumChecker();
        }
    }

    // Проверка, есть ли знак вопроса
    public static boolean questionFinder(char[] num) {
        int question = -1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == '?') {
                question = i;
            }
        }
        return question != -1;
    }

    // Поиск положения знака вопроса
    public static int questionIndexFinder(char[] num) {
        int questionMark = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == '?') {
                questionMark = i;
            }
        }
        return questionMark;
    }

    // Возвращаем цифры до знака вопроса в виде строки
    public static String fStringMaker(char[] num, int questionMark) {
        char[] fSlice = Arrays.copyOfRange(num, 0, questionMark);
        StringBuilder fHalf = new StringBuilder();
        for (char c : fSlice) {
            fHalf.append(c);
        }
        return fHalf.toString();
    }

    // Возвращаем цифры после знака вопроса в виде строки
    public static String sStringMaker(char[] num, int questionMark) {
        char[] sSlice = Arrays.copyOfRange(num, questionMark + 1, num.length);
        StringBuilder sHalf = new StringBuilder();
        for (char c : sSlice) {
            sHalf.append(c);
        }
        return sHalf.toString();
    }

    // В зависимости от наличия занка вопроса возвращаем массив возможных вариантов слагаемых
    public static int[] addendVars(char[] num) {
        if (questionFinder(num)) {
            int questionMark = questionIndexFinder(num);
            String fHalf = fStringMaker(num, questionMark);
            String sHalf = sStringMaker(num, questionMark);
            boolean fCheck = false;
            boolean sCheck = false;
            if (fHalf.length() == 0 || sHalf.length() == 0) {
                if (fHalf.length() == 0) {
                    fCheck = true;
                    sCheck = numChecker(sHalf);
                }
                if (sHalf.length() == 0) {
                    sCheck = true;
                    fCheck = numChecker(fHalf);
                }
            } else {
                fCheck = numChecker(fHalf);
                sCheck = numChecker(sHalf);
            }
            if (fCheck && sCheck) {
                int[] posAddend = new int[10];
                for (int i = 0; i < 10; i++) {
                    String posAddendStr = fHalf + i + sHalf;
                    posAddend[i] = Integer.parseInt(posAddendStr);
                }
                return posAddend;
            } else {
                return addendVars(addendChecker());
            }

        } else {
            StringBuilder posAddendStr = new StringBuilder();
            for (char c : num) {
                posAddendStr.append(c);
            }
            if (numChecker(posAddendStr.toString())) {
                return new int[]{Integer.parseInt(posAddendStr.toString())};
            } else {
                return addendVars(addendChecker());
            }

        }
    }

    // Проверка уровнения на равенство
    public static boolean equationCheck(int[] firstAddends, int[] secondAddends, int sum) {
        for (int firstAddend : firstAddends) {
            for (int secondAddend : secondAddends) {
                if (firstAddend + secondAddend == sum) {
                    System.out.printf("%d + %d = %d\n", firstAddend, secondAddend, sum);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("We will check the equation: q + w = e, q, w, e >= 0.");
        System.out.print("Input q: ");
        int[] firstAddends = addendVars(addendChecker());
        System.out.print("Input w: ");
        int[] secondAddends = addendVars(addendChecker());
        System.out.print("Input e: ");
        int sum = sumChecker();

        if (!equationCheck(firstAddends, secondAddends, sum)) System.out.println("There is no solution!");
    }
}