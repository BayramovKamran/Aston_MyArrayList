package org.example;

import java.util.Comparator;

/**
 * Класс QuickSort для сортировки ArrayList любого типа.
 */
public class QuickSort {

    /**
     * Метод для сортировки списка с использованием QuickSort.
     * @param list       список, который нужно отсортировать
     * @param comparator компаратор для определения порядка сортировки
     * @param <T>        тип элементов в списке
     */
    public static <T> void sort(MyArrayList<T> list, Comparator<? super T> comparator) {
        if (list == null || list.size() <= 1) {
            return; // Если список пуст или содержит один элемент, не требуется сортировка.
        }
        quickSort(list, 0, list.size() - 1, comparator);
    }

    /**
     * Рекурсивный метод для выполнения QuickSort.
     * @param list       список, который нужно отсортировать
     * @param low        граница начала подмассива
     * @param high       граница конца подмассива
     * @param comparator компаратор для определения порядка сортировки
     * @param <T>        тип элементов в списке
     */
    private static <T> void quickSort(MyArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            // Находим индекс разделителя
            int pivotIndex = partition(list, low, high, comparator);
            // Рекурсивно сортируем подмассивы
            quickSort(list, low, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Метод для разбиения массива и нахождения индекса разделителя.
     * @param list       список, который нужно разбить
     * @param low        граница начала подмассива
     * @param high       граница конца подмассива
     * @param comparator компаратор для определения порядка сортировки
     * @param <T>        тип элементов в списке
     * @return индекс разделителя
     */
    private static <T> int partition(MyArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
        T pivot = list.get(high); // Берем последний элемент как опорный
        int i = (low - 1); // Индекс меньшего элемента

        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                // Обмен элементов
                swap(list, i, j);
            }
        }
        
        // Обмен элемента с индексом i с опорным
        swap(list, i + 1, high);
        return i + 1; // Возвращаем индекс разделителя
    }

    /**
     * Метод для обмена элементов в списке.
     * @param list список, в котором нужно обменять элементы
     * @param i    индекс первого элемента
     * @param j    индекс второго элемента
     * @param <T>  тип элементов в списке
     */
    private static <T> void swap(MyArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}






