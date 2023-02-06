/**
 * В калькулятор добавьте возможность отменить последнюю операцию.
 */

import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static double adder(double fNumber, double sNumber) {
        return fNumber + sNumber;
    }
    public static double substracter(double fNumber, double sNumber) {
        return fNumber - sNumber;
    }
    public static double multiplier(double fNumber, double sNumber) {
        return fNumber * sNumber;
    }
    public static double divider(double fNumber, double sNumber) {
        try{
            return fNumber / sNumber;
        } catch(Exception e) {
            if (fNumber >= 0) return Double.POSITIVE_INFINITY;
            else return Double.NEGATIVE_INFINITY;
        }
    }
    public static boolean numChecker(String number){
        try{
            Double.parseDouble(number);
            return true;
        } catch(Exception e) {
            System.out.println("Not a number!");
            return false;
        }
    }
    public static double numReader(){
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        if (Objects.equals(n, "q") || Objects.equals(n, "Q")) {
            System.exit(0);
        }
        if (numChecker(n)) return Double.parseDouble(n);
        else return numReader();
    }

    public static String inputReader(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void actSelector(double num1, double num2, String act){
        switch (act) {
            case ("q"), ("Q") -> System.exit(0);
            case ("+"), ("/"), ("-"), ("*")-> resultPrinter(num1, num2, act);
            default -> actSelector(num1, num2, inputReader());
        }
    }
    public static void resultPrinter(double num1, double num2, String act){
        switch (act) {
            case "+" -> System.out.printf("%s + %s = %s\n", num1, num2, adder(num1, num2));
            case "-" -> System.out.printf("%s - %s = %s\n", num1, num2, substracter(num1, num2));
            case "/" -> System.out.printf("%s / %s = %s\n", num1, num2, divider(num1, num2));
            case "*" -> System.out.printf("%s * %s = %s\n", num1, num2, multiplier(num1, num2));
        }
    }
    public static void discard(double num1, double num2) {
        String confirm = inputReader();
        switch (confirm) {
            case "c" -> calculator();
            case ("q"), ("Q") -> System.exit(0);
            case "d" -> {
                System.out.println("Input an action (+, -, /, *): ");
                actSelector(num1, num2, inputReader());
            }
            default -> {
                System.out.print("Wrong action! Try again:\n");
                discard(num1, num2);
            }
        }
    }


    public static void calculator() {
        while (true) {
            System.out.println("Welcome to calculator! Input 'q' for exit.");

            System.out.print("Input first number: ");
            double num1 = numReader();

            System.out.print("Input second number: ");
            double num2 = numReader();

            System.out.println("Input an action (+, -, /, *): ");
            actSelector(num1, num2, inputReader());

            System.out.print("Was the action right?\nPress 'd' to discard, 'c' to continue, 'q' to exit.\n");
            discard(num1, num2);
        }
    }


    public static void main(String[] args) {
        calculator();
    }
}
