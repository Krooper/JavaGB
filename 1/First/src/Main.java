/**
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n),
 * n! (произведение чисел от 1 до n)
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.print("Input a positive INT number: ");
        Scanner scan1 = new Scanner(System.in);
        int n = scan1.nextInt(); // Считаем, что пользователь не ошибётся

        int tN = (n*(n+1))/2;
        int fact = 1;

        for (int i = 1; i <= n; i++){
            fact = fact * i;
        }

        System.out.printf("Numero triangular of %d: %d\n", n, tN);
        System.out.printf("%d! = %d\n",n , fact);
    }
}