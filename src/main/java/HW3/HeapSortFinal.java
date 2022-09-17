package HW3;
// Пирамидальная сортировка
import java.util.ArrayList;
import java.util.Arrays;

public class HeapSortFinal {
    public static void main(String[] args) {
        int[] ar = new int[]{4, 10, 3, 5, 84, 0, 34, 23, 56, 72}; // Задаем массив для сортировки
        ArrayList<Integer> arS = new ArrayList<>(); // Создаем динамический массив, в котором будем удалять больший элемент после каждого прохождения
        System.out.println(Arrays.toString(ar));
        for (int j : ar) {
            arS.add(j); // Заполняем динамический массив
        }
        int idx = 0;
        while (arS.size() > 0) { // Запускаем цмкл по сортировке массива, после каждого прохода по массиву, будет удаляться из массива наибольший элемент
            int n = arS.size();
            for (int i = (n - 1) / 2; i >= 0; i--) { // Запускаем цикл обработки массивва, разбивая на кучи
                heapTree(arS, n, i); // С помощью этого метода обрабатываем кучи
                System.out.println(arS);
            }

            ar[idx] = arS.get(0); // Записываем в исходный массив наибольший элемент, отсортированный в корень дерева
            // на место, соответствующее текущему индексу, в итоге получаем отсортированный массив
            idx++; // Увеличиваем индекс на еденицу
            System.out.println(Arrays.toString(ar));
            arS.remove(0); // Удаляем из динамического массива наибольший элемент
            System.out.println(arS);

            System.out.println(arS);
        }
        System.out.println(Arrays.toString(ar)); // Выводим отсортированный массив
    }

    static void heapTree(ArrayList<Integer> arr, int n, int i) { // Метод, сравнивает элементы в куче и поднимает на верх больший элемент
        int b;
        int c;
        int lagest;
        int a = arr.get(i);
        if (2 * i + 2 < n) {
            c = arr.get(2 * i + 2);
            b = arr.get(2 * i + 1);
            if (a > b && a > c) {
                lagest = a;
            } else if (a < b && b > c) {
                lagest = b;
                arr.set(2 * i + 1, a);
                arr.set(i, lagest);
            } else if (a < c && b < c) {
                lagest = c;
                arr.set(2 * i + 2, a);
                arr.set(i, lagest);

            }

        } else if (2 * i + 1 < n) {
            b = arr.get(2 * i + 1);
            if (a < b) {
                lagest = b;
                arr.set(2 * i + 1, a);
                arr.set(i, lagest);
            }
        }
    }
}
