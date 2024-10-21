package org.example;

import java.util.Comparator;

/**
 * Основной класс для тестирования MyArrayList и QuickSort.
 */
public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);

        System.out.println("Исходный список: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // Сортировка с помощью QuickSort
        list.sort(Comparator.naturalOrder());

        System.out.println("\nОтсортированный список: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
