/**
 * Написать метод, который переведёт данное целое число в римский формат.
 */
public class Main {


    public static String romanizer(int number){
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romanNums = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

        StringBuilder romanNum = new StringBuilder();
        int i = nums.length - 1;
        while (number > 0) {
            while (nums[i] > number){
                i--;
            }
            romanNum.append(romanNums[i]);
            number -= nums[i];
        }
        return romanNum.toString();
    }

    public static void main(String[] args) {
        int randNumber = (int) (Math.random()*(2000+1));
        System.out.println("Initial number: ");
        System.out.println(randNumber);

        System.out.println();

        System.out.println("Roman number: ");
        System.out.println(romanizer(randNumber));
    }
}