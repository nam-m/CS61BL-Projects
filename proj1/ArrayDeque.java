import java.lang.reflect.Array;

public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    // Number of items with values in array
    private int numOfItems;

    // Create an empty array with specific size
    public ArrayDeque(int size) {
        items = (T[]) new Object[size];
        this.size = size;
        numOfItems = 0;
        nextFirst = 0;
        nextLast = size - 1;
    }

    @Override
    public void addFirst(T item) {
        if (numOfItems >= size) {
            T[] newItems = (T[]) new Object[size + 1];
            System.arraycopy(items, 0, newItems, 1, size);
            newItems[0] = item;
            items = newItems;
            // Increase array size by 1
            size++;
            nextFirst = 0;
        }
        else {
            items[nextFirst] = item;
            nextFirst = (nextFirst - 1) % size;
            if (nextFirst < 0)
                nextFirst += size;
        }
        // Increase number of filled items by 1
        numOfItems++;
    }

    @Override
    public void addLast(T item) {
        if (numOfItems >= size) {
            T[] newItems = (T[]) new Object[size + 1];
            System.arraycopy(items, 0, newItems, 0, size);
            newItems[size] = item;
            items = newItems;
            // Increase array size by 1
            size++;
            nextLast = items.length-1;
        }
        else {
            items[nextLast] = item;
            nextLast = (nextLast + 1) % size;
        }
        // Increase number of filled items by 1
        numOfItems++;
    }

    @Override
    // Return number of filled items in the array
    public int size() {
        return numOfItems;
    }

    @Override
    public void printDeque() {
        String printedArray = "";
        if (size == 0)
            return;
        for (int i=0; i < size; i++)
            printedArray += items[i] + " ";
        System.out.println(printedArray.trim());
    }

    @Override
    public T removeFirst() {
        T removedItem = null;
        if (size() == 0)
            return removedItem;
        // Remove first item in array when array is full;
        // otherwise, remove previous item to the last addFirst()
        while (items[nextFirst] == null)
            nextFirst++;
        removedItem = items[nextFirst];
        items[nextFirst] = null;
        nextFirst = (nextFirst + 1) % size;
        numOfItems--;
        return removedItem;
    }

    @Override
    public T removeLast() {
        T removedItem = null;
        if (size() == 0)
            return removedItem;
        // Remove last item in array when array is full;
        // otherwise, remove previous item to the last addLast()
        while (items[nextLast] == null) {
            nextLast--;
            if (nextLast < 0)
                nextLast += size;
        }
        removedItem = items[nextLast];
        items[nextLast] = null;
        nextLast = (nextLast - 1) % size;
        if (nextLast < 0)
            nextLast += size;
        numOfItems--;
        return removedItem;
    }

    @Override
    public T get(int index) {
        if (size() <= 0)
            return null;
        return items[index];
    }
}
