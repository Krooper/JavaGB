// Вывести все простые числа от 1 до 1000
public class Main {
    public static boolean checkSimplicity(int number) {
        if (number <= 3) return true;
        else if (number % 2 == 0 || number % 3 == 0) return false;
        for (int j = 4; j < number; j++) {
            if (number % j == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Prime numbers:");
        for (int i = 2; i <= 1000; i++) {
            if (checkSimplicity(i)) {
                System.out.println(i);
            }
        }
    }
}