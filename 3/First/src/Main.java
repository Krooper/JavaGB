import java.util.Arrays;

/**
 * Реализовать алгоритм сортировки слиянием
 */

public class Main {

    // Метод слияния: разбиваем исходный массив на массивы и сливаем их, постепенно увеличивая их размер.
    public static int[] merger(int[] arr) {
        int[] tempArr;
        int[] sortingArr = new int[arr.length];

        int size = 1;
        while (size < arr.length) {
            for (int i = 0; i < arr.length; i += 2 * size) {
                sorter(arr, i, arr, i + size, sortingArr, i, size);
            }

            tempArr = arr;
            arr = sortingArr;
            sortingArr = tempArr;
            size *= 2;
        }
        return arr;
    }

    /**
     * Метод слияния.
     * С учетом постепенного увеличения размера сливаемых массивов, проводим сортировку внутри этих массивов,
     * учитывая их границы внутри исходного массива на текущий момент
     * (в зависимости от текущего их размера в методе merger)
     */

    private static void sorter(int[] arr1, int arr1Start, int[] arr2, int arr2Start, int[] sortedArr,
                               int sortedArrStart, int sortedArrSize) {
        int index1 = arr1Start;
        int index2 = arr2Start;

        int arr1End = Math.min(arr1Start + sortedArrSize, arr1.length);
        int arr2End = Math.min(arr2Start + sortedArrSize, arr2.length);

        int iterationCount = arr1End - arr1Start + arr2End - arr2Start;

        for (int i = sortedArrStart; i < sortedArrStart + iterationCount; i++) {
            if (index1 < arr1End && (index2 >= arr2End || arr1[index1] < arr2[index2])) {
                sortedArr[i] = arr1[index1];
                index1++;
            } else {
                sortedArr[i] = arr2[index2];
                index2++;
            }
        }
    }

    public static void main(String[] params) {
        int[] array = new int[] {3, 89, 34, 18, 135, 95, 5, 367, 25, 69, 146};
        System.out.printf("Unsorted Array: %s\n", Arrays.toString(array));
        array = merger(array);
        System.out.printf("Sorted Array: %s", Arrays.toString(array));
    }
}