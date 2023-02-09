import java.sql.Array;
import java.util.*;

/**
 * Пусть дан список сотрудников:
 * Иван Иванов
 * Светлана Петрова
 * Кристина Белова
 * Анна Мусина
 * Анна Крутова
 * Иван Юрин
 * Петр Лыков
 * Павел Чернов
 * Петр Чернышов
 * Мария Федорова
 * Марина Светлова
 * Мария Савина
 * Мария Рыкова
 * Марина Лугова
 * Анна Владимирова
 * Иван Мечников
 * Петр Петин
 * Иван Ежов
 * <p>
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности.
 */

public class Main {
    //Получаем только имена из списка Имен и Фамилий
    public static List<String> nameGetter(List<String> employees) {
        List<String> names = new ArrayList<String>();
        for (String employeeF : employees) {
            names.add(employeeF.split(" ")[0]);
        }
        return names;
    }

    // Считаем повторения, возвращаем Map: ключи - имена, значения - число повторений
    public static Map<String, Integer> repeatCounter(List<String> employees) {
        Map<String, Integer> repeatedSurnames = new HashMap<>();
        for (String employeeF : employees) {
            int counter = 0;
            for (String employeeS : employees) {
                if (Objects.equals(employeeF, employeeS)) {
                    counter++;
                }
            }
            if (counter > 1) {
                repeatedSurnames.put(employeeF, counter);
            }
        }
        return repeatedSurnames;
    }

    // Метод сортировки по убыванию
    public static String[] repeatSorter(Map<String, Integer> map) {
        // Переводим ключи и значения в строку, делаем массив такой строк
        String[] sortedArray = new String[map.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sortedArray[i] = entry.getKey() +
                    ": " + entry.getValue();
            i++;
        }

        // Сортировка пузырьком
        boolean isSorted = false;
        String temp;
        while (!isSorted) {
            isSorted = true;

            for (int j = 0; j < sortedArray.length - 1; j++) {

                // Для сравнения повторений, выделяем число (оно стоит последним в строке, т.е. [1] эл-ом)
                int numberF = Integer.parseInt(sortedArray[j].split(": ")[1]);
                int numberS = Integer.parseInt(sortedArray[j + 1].split(": ")[1]);

                // Сравниваем эти числа и сортируем по убыванию изначальный массив.
                if (numberF < numberS) {
                    isSorted = false;
                    temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        return sortedArray;
    }

    // Метод для красивого вывода Map
    public static StringBuilder mapPrinter(Map<String, Integer> map) {
        StringBuilder outStr = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            outStr.append(entry.getKey());
            outStr.append(": ");
            outStr.append(entry.getValue());
            outStr.append("\n");
        }
        return outStr;
    }

    // Метод для красивого вывода Массива
    public static StringBuilder arrayPrinter(String[] array) {
        StringBuilder outStr = new StringBuilder();
        for (String employee : array) {
            outStr.append(employee).append("\n");
        }
        return outStr;
    }

    public static void main(String[] args) {
        List<String> initList = new ArrayList<String>();
        initList.add("Ivan Иванов");
        initList.add("Svetlana Петрова");
        initList.add("Kristina Белова");
        initList.add("Anna Мусина");
        initList.add("Anna Крутова");
        initList.add("Ivan Юрин");
        initList.add("Petr Лыков");
        initList.add("Pavel Чернов");
        initList.add("Petr Чернышов");
        initList.add("Maria Федорова");
        initList.add("Marina Светлова");
        initList.add("Maria Савина");
        initList.add("Maria Рыкова");
        initList.add("Marina Лугова");
        initList.add("Anna Владимирова");
        initList.add("Ivan Мечников");
        initList.add("Petr Петин");
        initList.add("Ivan Ежов");

        System.out.println("Not sorted Map with repeated names:");
        System.out.println(mapPrinter(repeatCounter(nameGetter(initList))));
        System.out.println();
        System.out.println("Sorted List with repeated names:");
        System.out.println(arrayPrinter(repeatSorter(repeatCounter(nameGetter(initList)))));
    }
}
