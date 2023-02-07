import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */

public class Main {
    public static List<Integer> listGenerator() {
        return new Random().ints(0, 100).
                limit(10).boxed().collect(Collectors.toList());
    }

    public static void heapify(List<Integer> lst, int length, int i) {
        boolean flag = true;
        while (flag) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < length && lst.get(largest) < lst.get(left)){
                largest = left;
            }
            if (right < length && lst.get(largest) < lst.get(right)){
                largest = right;
            }
            if (largest != i){
                int temp = lst.get(i);
                lst.set(i, lst.get(largest));
                lst.set(largest, temp);
                i = largest;
            }
            else flag = false;
        }
    }

    public static List<Integer> heapSorter(List<Integer> lst){
        int length = lst.size();
        for (int i = length / 2 -1; i > -1; i--){
            heapify(lst, length, i);
        }
        for (int i = length - 1; i > 0; i--){
            int temp = lst.get(i);
            lst.set(i, lst.get(0));
            lst.set(0, temp);
            heapify(lst, i, 0);
        }
        return lst;
    }
    public static void main(String[] args) {
        System.out.println("Initial List:");
        List<Integer> lst = listGenerator();
        System.out.println(lst);

        System.out.println();

        System.out.println("Sorted List:");
        System.out.println((heapSorter(lst)));
    }
}