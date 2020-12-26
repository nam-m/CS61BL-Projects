public class LinkedListDeque<T> implements Deque<T>{
    private static class LinkedListNode<T> {
        public T item;
        public LinkedListNode next;

        //Constructor
        public LinkedListNode(T item, LinkedListNode next) {
            this.item = item;
            this.next = next;
        }

    }
    private LinkedListNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new LinkedListNode(null, null);

    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public boolean isEmpty() {
        if (size() == 0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {

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
        return null;
    }
}
