public class LinkedListDeque<T> implements Deque<T>{
    /*
     * LinkedListNode is a nested class that represents a single node in the
     * LinkedListDeque, storing an item and references to the next and previous LinkedListNode
     */
    private static class LinkedListNode<T> {
        public T item;
        public LinkedListNode next;
        public LinkedListNode prev;

        //Constructor
        public LinkedListNode(T item, LinkedListNode next, LinkedListNode prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

    }
    private LinkedListNode sentinel;
    private int size;

    // Empty linked list deque
    public LinkedListDeque() {
        sentinel = new LinkedListNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    // Linked list deque with 1 item
    public LinkedListDeque(T item) {
        sentinel = new LinkedListNode(null, null, null);
        sentinel.next = new LinkedListNode(item, null, null);
        sentinel.prev = sentinel.next;
        sentinel.next.next = sentinel;
        sentinel.next.prev = sentinel;
        size = 1;
    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

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
