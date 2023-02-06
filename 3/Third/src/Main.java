import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * адан целочисленный список ArrayList.
 * Найти минимальное, максимальное и среднее из этого списка.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> initList = new Random().ints(0, 100).
                limit(10).boxed().collect(Collectors.toList());
        System.out.println("Initial List:");
        System.out.println(initList);

        int maxVal = Collections.max(initList);
        int minVal = Collections.min(initList);

        // Срднее арифметическое:
        double size = initList.size();
        double aveVar = initList.stream().mapToInt(Integer::intValue).sum()/size;

        System.out.printf("Max: %d, Min: %d, Average: %s",maxVal, minVal, aveVar);
    }
}