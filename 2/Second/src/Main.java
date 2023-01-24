import java.util.Objects;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static String actSelector(){
        System.out.println("Input an action (+, -, /, *): ");
        Scanner scan = new Scanner(System.in);
        String act = scan.nextLine();
        if (Objects.equals(act, "q") || Objects.equals(act, "Q")) {
            System.exit(0);
        }
        if ((Objects.equals(act, "+")) || (Objects.equals(act, "-"))
                || (Objects.equals(act, "*")) || (Objects.equals(act, "/"))) {
            return act;
        } else return actSelector();
    }
    public static void main(String[] args) {
        try (FileWriter ignored = new FileWriter("CalculatorLog.txt")) {
            FileHandler fh = new FileHandler("CalculatorLog.txt");
            Logger logger = Logger.getLogger(Main.class.getName());
            logger.addHandler(fh);
            while (true) {
                System.out.println("Welcome to calculator! Input 'q' for exit.");
                System.out.print("Input first number: ");
                double num1 = numReader();
                System.out.print("Input second number: ");
                double num2 = numReader();
                String act = actSelector();
                StringBuilder result = new StringBuilder();

                switch (act) {
                    case "+" -> {
                        result.setLength(0);
                        result.append(num1).append(" + ").append(num2).append(" = ").append(adder(num1, num2));
                        System.out.println(result);
                    }
                    case "-" -> {
                        result.setLength(0);
                        result.append(num1).append(" - ").append(num2).append(" = ").append(substracter(num1, num2));
                        System.out.println(result);
                    }
                    case "/" -> {
                        result.setLength(0);
                        result.append(num1).append(" / ").append(num2).append(" = ").append(divider(num1, num2));
                        System.out.println(result);
                    }
                    case "*" -> {
                        result.setLength(0);
                        result.append(num1).append(" / ").append(num2).append(" = ").append(multiplier(num1, num2));
                        System.out.println(result);
                    }
                }
                logger.info(result.toString());
                logger.log(Level.INFO,"Calculated!");
            }
        } catch (Exception exception) {
            System.out.println("Some error");
        }
    }
}