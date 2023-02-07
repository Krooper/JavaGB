import javax.print.attribute.IntegerSyntax;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Взять набор строк, например, "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись."
 * Написать метод, который отсортирует эти строки по длине с помощью TreeMap.
 * Строки с одинаковой длиной не должны “потеряться”.
 */
public class Main {
    // Метод для красивой печати
    public static StringBuilder mapPrinter(TreeMap<String, Integer> map) {
        StringBuilder outStr = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            outStr.append(entry.getKey());
            outStr.append(": ");
            outStr.append(entry.getValue());
            outStr.append("\n");
        }
        return outStr;
    }

    // Метод по созданию TreeMap: ключи - строкиБ значения - длина строки. Так одинаковые значения длины не потеряются
    public static TreeMap<String, Integer> mapGenerator(String[] strings) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String str : strings) {
            map.put(str, str.length());
        }
        return map;
    }

    public static void main(String[] args) {
        // Сделал массив строк с одинаковыми длинами (отличаются только знаки в конце) для наглядности
        String[] strings = new String[]{"Moroz i solnce den chudesny!", "Moroz i solnce den chudesny.", "Moroz i solnce den chudesny,",
                "Eshe ty dremlesh drug prelestnyi!", "Eshe ty dremlesh drug prelestnyi.", "Eshe ty dremlesh drug prelestnyi,",
                "Pora krasavitsa prosnis!", "Pora krasavitsa prosnis.", "Pora krasavitsa prosnis,"};

        System.out.println(mapPrinter(mapGenerator(strings)));
    }
}
