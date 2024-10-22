import org.example.MyArrayList;
import org.example.QuickSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyArrayListTest {

    private MyArrayList<String> list;

    @BeforeEach
    public void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    public void testAdd() {
        list.add("Hello");
        list.add("World");
        assertEquals(2, list.size());
    }

    @Test
    public void testGet() {
        list.add("Hello");
        list.add("World");
        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
    }

    @Test
    public void testAddAtIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(3);
        list.add(1, 2); 
        assertEquals(2, list.get(1));
    }

    @Test
    public void testRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(2, list.remove(1));
        assertEquals(1, list.size());
    }

    @Test
    public void testClear() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Test");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);
        QuickSort.sort(list, Comparator.naturalOrder());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
    }
}
