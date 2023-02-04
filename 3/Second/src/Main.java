import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Пусть дан произвольный список целых чисел, удалить из него четные числа
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> initList = new Random().ints(0, 10).
                limit(10).boxed().collect(Collectors.toList());
        System.out.println("Initial List:");
        System.out.println(initList);

        initList.removeIf(num -> num % 2 == 0);

        System.out.println("List with odd nums only:");
        System.out.println(initList);
    }
}