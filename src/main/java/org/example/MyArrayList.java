package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Простой класс, реализующий динамический массив.
 * @param <E> тип элементов в этом массиве
 */
public class MyArrayList<E> {
    private Object[] elements; // Хранит элементы массива
    private int size; // Текущий размер массива (количество элементов)
    private static final int INITIAL_CAPACITY = 10; // Начальная емкость массива

    /**
     * Конструктор по умолчанию, создающий массив с начальной емкостью.
     */
    public MyArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Добавляет элемент в конец массива.
     * @param element элемент, который нужно добавить
     */
    public void add(E element) {
        ensureCapacity();
        elements[size++] = element; // Добавление элемента и увеличение размера
    }

    /**
     * Добавляет элемент по указанному индексу.
     * @param index   индекс, по которому нужно добавить элемент
     * @param element элемент, который нужно добавить
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index); // Сдвиг элементов
        elements[index] = element; // Добавление нового элемента
        size++;
    }

    /**
     * Получает элемент по указанному индексу.
     * @param index индекс элемента
     * @return элемент по указанному индексу
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return (E) elements[index]; // Возврат элемента
    }

    /**
     * Удаляет элемент по указанному индексу.
     * @param index индекс элемента для удаления
     * @return удаленный элемент
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        E removedElement = (E) elements[index];
        int numMoved = size - index - 1; // Количество элементов, которое нужно сдвинуть
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved); // Сдвиг элементов
        }
        elements[--size] = null; // Убираем ссылку на удаленный элемент
        return removedElement;
    }

    /**
     * Очищает коллекцию, удаляя все элементы.
     */
    public void clear() {
        Arrays.fill(elements, 0, size, null); // Очищаем массив
        size = 0; // Устанавливаем размер в 0
    }

    /**
     * Сортирует элементы в массиве с использованием алгоритма Quicksort.
     * @param comparator компаратор для определения порядка сортировки
     */
    public void sort(Comparator<? super E> comparator) {
        quicksort(0, size - 1, comparator);
    }

    /**
     * Реализация алгоритма Quicksort.
     * @param low        начальный индекс
     * @param high       конечный индекс
     * @param comparator компаратор для определения порядка сортировки
     */
    private void quicksort(int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quicksort(low, pivotIndex - 1, comparator);
            quicksort(pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Разделяет массив на части для алгоритма Quicksort.
     * @param low        начальный индекс
     * @param high       конечный индекс
     * @param comparator компаратор для сравнения
     * @return индекс опорного элемента
     */
    private int partition(int low, int high, Comparator<? super E> comparator) {
        E pivot = get(high); // Опорный элемент
        int i = (low - 1); // Индекс меньшего элемента
        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j); // Обмен
            }
        }
        swap(i + 1, high);
        return i + 1; // Возврат индекса опорного элемента
    }

    /**
     * Меняет местами два элемента в массиве.
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     */
    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    /**
     * Увеличивает объем массива, если это необходимо.
     */
    private void ensureCapacity() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2); // Увеличиваем размер массива
        }
    }

    /**
     * Возвращает текущий размер массива.
     * @return текущий размер
     */
    public int size() {
        return size;
    }
}
