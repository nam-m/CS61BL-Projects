import java.lang.reflect.Array;

public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] arr;
    // Number of items with values in array
    private int numOfItems = 0;
    // Pointer to array
    private T ptr;


    public ArrayDeque() {
        // Create a generic type object array and cast it as type T
        arr = (T[]) new Object [0];
        ptr = arr[0];
        nextFirst = 0;
        nextLast = 0;
    }

    public ArrayDeque(int size) {
        arr = (T[]) new Object[size];
        ptr = arr[0];
        nextFirst = 0;
        nextLast = size() - 1;
    }

    @Override
    public void addFirst(T item) {
        arr[nextFirst] = item;
        numOfItems++;
        nextFirst = (nextFirst - 1) % size();
    }

    @Override
    public void addLast(T item) {
        arr[nextLast] = item;
        numOfItems++;
        nextLast = (nextLast + 1) % size();
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
