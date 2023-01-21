/**
 * Напишите метод, который находит самую длинную строку общего префикса среди массива строк.
 * Если общего префикса нет, вернуть пустую строку "".
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // Проверяем ввод на целое положительное число
    public static boolean numChecker(String number) {
        try {
            if (Integer.parseInt(number) >= 0) return true;
            else {
                System.out.print("Not a positive number!\nTry again: ");
                return false;
            }
        } catch (Exception e) {
            System.out.print("Not an integer number!\nTry again: ");
            return false;
        }
    }

    // Вытаскиваем из ввода длину массива
    public static int arrLength() {
        Scanner scan = new Scanner(System.in);
        String strLength = scan.nextLine();
        if (numChecker(strLength)) {
            return Integer.parseInt(strLength);
        }
        return arrLength();
    }

    // Заполняем массив строк с консоли
    public static String[] arrCreator() {
        System.out.print("Input an array length: ");
        int arrLength = arrLength();
        String[] strArr = new String[arrLength];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < arrLength; i++) {
            System.out.printf("Element %d of an array: ", i + 1);
            strArr[i] = scan.nextLine();
        }
        return strArr;
    }

    // Ищем общую подстроку во всех элементах массива
//    public static String desiredPrefix(String[] strArr) {
//        String prefix = strArr[0].substring(0, strArr[0].length());
//        for (int j = 0; j < strArr[0].length(); j++) {
//            for (int i = 1; i < strArr.length; i++) {
//                if (!strArr[i].contains(prefix)) {
//                    prefix = strArr[0].substring(0, strArr[0].length() - j);
//                    break;
//                }
//            }
//        }
//        if (prefix.length() > 0) {
//            return prefix;
//        }
//        return "";
//    }

    // Выше находится метод, который просто находит входимость подстроки в строки-элементы массива
    // Тут же метод, который смотрит именно на префикс, т.е.
    // на то, находится ли префикс в начале всех строк-элементов массива
    // Они в принципе довольно похожи :)
    public static String desiredPrefix(String[] strArr) {
        String prefix = strArr[0];
        int index = -1;
        for (int j = 0; j < strArr[0].length(); j++) {
            for (int i = 1; i < strArr.length; i++) {
                index = strArr[i].indexOf(prefix);
                if (index > 0 || index == -1) {
                    prefix = strArr[0].substring(0, strArr[0].length() - j);
                    break;
                }
            }
        }
        if (index != -1) {
            return prefix;
        }
        return "";
    }

    public static void main(String[] args) {
        String[] strArr = arrCreator();
        System.out.println(desiredPrefix(strArr));
    }
}