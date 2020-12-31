import java.lang.reflect.Array;

public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    // Number of items with values in array
    private int numOfItems = 0;
    // Pointer to array
    private T ptr;

    public ArrayDeque(int size) {
        items = (T[]) new Object[size];
        ptr = items[0];
        nextFirst = 0;
        nextLast = items.length-1;
    }

    @Override
    public void addFirst(T item) {
        if (numOfItems >= size) {
            T[] newItems = (T[]) new Object[size + 1];
            System.arraycopy(items, 0, items, 1, size);
            items[0] = item;
        }
//        items[nextFirst] = item;
        numOfItems++;
        nextFirst = (nextFirst - 1) % size();
    }

    @Override
    public void addLast(T item) {
        items[nextLast] = item;
        numOfItems++;
        nextLast = (nextLast + 1) % size();
    }

    @Override
    // Return number of filled items in the array
    public int size() {
        return numOfItems;
    }

    @Override
    public void printDeque() {
        String printedArray = "";
        if (size() == 0)
            return;
        for (int i=0; i < size(); i++)
            printedArray += items[i] + " ";
        System.out.println(printedArray.trim());
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
        if (size() <= 0)
            return null;
        return items[index];
    }
}
