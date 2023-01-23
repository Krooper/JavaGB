/**
 * Дан массив nums = [3,2,2,3] и число val = 3.
 * Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
 * Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
 */
import java.util.Arrays;
public class Main {
    public static boolean numInArrChecker (int[] nums, int val){
        for (int num : nums) {
            if (num == val) {
                return true;
            }
        }
        return false;
    }
    public static int[] arrReorderer(int[] nums, int val){
        int k = 0;
        for (int i: nums) {
            if (i != val) {
                nums[k++] = i;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = val;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 4;

        if (numInArrChecker(nums, val)) {
            System.out.println(Arrays.toString(arrReorderer(nums, val)));
        } else {
            System.out.printf("There is no number %d in the array!", val);
        }
    }
}