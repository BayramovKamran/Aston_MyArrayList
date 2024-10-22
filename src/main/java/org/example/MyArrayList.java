package org.example;

import java.util.Arrays;

/**
 * Простой класс, реализующий динамический массив (ArrayList).
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
    }

    /**
     * Добавляет элемент в конец массива.
     * @param element элемент, который нужно добавить
     */
    public void add(E element) {
        ensureCapacity(); // Увеличиваем емкость, если необходимо
        elements[size++] = element; // Добавление элемента и увеличение размера
    }

    /**
     * Добавляет элемент по указанному индексу.
     * @param index   индекс, по которому нужно добавить элемент
     * @param element элемент, который нужно добавить
     */
    public void add(int index, E element) {
        validateIndex(index); // Проверка индекса
        ensureCapacity(); // Увеличиваем емкость, если необходимо
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
        validateIndex(index); // Проверка индекса
        return (E) elements[index]; // Возврат элемента
    }

    /**
     * Удаляет элемент по указанному индексу.
     * @param index индекс элемента для удаления
     * @return удаленный элемент
     */
    public E remove(int index) {
        validateIndex(index); // Проверка индекса
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
     * Возвращает текущий размер массива.
     * @return текущий размер
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, является ли массив пустым.
     * @return true, если массив пустой, иначе false
     */
    public boolean isEmpty() {
        return size == 0;
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
     * Проверяет, валиден ли индекс для доступа к элементу.
     * @param index индекс для проверки
     */
    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
    }

    /**
     * Устанавливает новый элемент по указанному индексу, заменяя старый.
     * @param index   индекс элемента, который нужно изменить
     * @param element новый элемент, который нужно установить
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public void set(int index, E element) {
        validateIndex(index); // Проверка индекса
        elements[index] = element; // Установка нового значения по индексу
    }
}
