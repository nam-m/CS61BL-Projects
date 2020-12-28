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
        sentinel.next = new LinkedListNode(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new LinkedListNode(item, sentinel.next, sentinel);
        //Link prev in the second node to the first node
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev = new LinkedListNode(item, sentinel, sentinel.prev);
        //Link next in the second last node to the last node
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        LinkedListNode p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(String.valueOf(p.item) + " ");
            p = p.next;
        }
        System.out.print(String.valueOf(p.item) + "\n");
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
        if (size == 0 || index < 0 || index > size())
            return null;
        LinkedListNode p = sentinel.next;
        while (index-- > 0)
            p = p.next;
        return (T) p.item;
    }
}
