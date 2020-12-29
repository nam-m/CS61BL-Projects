import java.lang.reflect.Array;

public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    // Pointer to array
    private T ptr;
    private T[] arr;

    public ArrayDeque() {
        // Create a generic type object array and cast it as type T
        arr = (T[]) new Object [0];
        ptr = arr[0];
    }

    public ArrayDeque(int size) {
        arr = (T[]) new Object[size];
        ptr = arr[0];
    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public void printDeque() {
        for (T item : arr) {
            System.out.print(item + " ");
        }
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        if (size <= 0)
            return null;
        return arr[index];
    }
}
