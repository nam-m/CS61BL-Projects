import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addFirstRemoveFirstTest() {
        System.out.println("Running addFirst & removeFirst test.");
        ArrayDeque<String> arr1 = new ArrayDeque<>(1);
        ArrayDeque<String> arr2 = new ArrayDeque<>(8);

        System.out.println("Printing out empty array deque 1: ");
        arr1.printDeque();
        System.out.println("Printing out empty array deque 2: ");
        arr2.printDeque();

        // Java will try to run the below code.
        // If there is a failure, it will jump to the finally block before erroring.
        // If all is successful, the finally block will also run afterwards.
        try {
            /**
             * Case 1: Test with minimum array size
             * New array will be created each time a new item is added
            */
            System.out.println("Running addFirst & removeFirst test on array 1.");
            assertTrue(arr1.isEmpty());
            arr1.addFirst("d");
            assertEquals("d", arr1.get(0));
            arr1.addFirst("c");
            assertEquals("c", arr1.get(0));
            arr1.addFirst("b");
            assertEquals("b", arr1.get(0));
            arr1.addFirst("a");
            assertEquals("a", arr1.get(0));
            System.out.println("Printing out array deque 1: ");
            arr1.printDeque();
            System.out.println();

            System.out.println("Remove first item in array deque 1");
            assertEquals("a", arr1.removeFirst());

            System.out.println("Remove first item in array deque 1");
            assertEquals("b", arr1.removeFirst());

            System.out.println("Remove first item in array deque 1");
            assertEquals("c", arr1.removeFirst());

            System.out.println("Remove first item in array deque 1");
            assertEquals("d", arr1.removeFirst());
            System.out.println("Printing out array deque 1: ");
            arr1.printDeque();
            assertTrue(arr1.isEmpty());

            for (int i=0; i < 10000; i++)
                arr1.addFirst("random");
            for (int i=0; i < 10000; i++)
                arr1.removeFirst();

            System.out.println("Printing out array deque 1: ");
            arr1.printDeque();
//            assertTrue(arr1.isEmpty());

            /**
             * Case 2: Test with array size larger than number of items
             * There will be empty items inside array
             */
            System.out.println("Running addFirst & removeFirst test on array 2.");
            assertTrue(arr2.isEmpty());
            arr2.addFirst("d");
            assertEquals("d", arr2.get(0));
            arr2.addFirst("c");
            assertEquals("c", arr2.get(7));
            arr2.addFirst("b");
            assertEquals("b", arr2.get(6));
            arr2.addFirst("a");
            assertEquals("a", arr2.get(5));
            System.out.println("Printing out array deque 2: ");
            arr2.printDeque();
            System.out.println();

            System.out.println("Remove first item in array deque 2");
            assertEquals("a", arr2.removeFirst());

            System.out.println("Remove first item in array deque 2");
            assertEquals("b", arr2.removeFirst());

            System.out.println("Remove first item in array deque 2");
            assertEquals("c", arr2.removeFirst());

            System.out.println("Remove first item in array deque 2");
            assertEquals("d", arr2.removeFirst());
            System.out.println("Printing out array deque 2: ");
            arr2.printDeque();
            assertTrue(arr2.isEmpty());
        }
        finally {
            // The deque will be printed at the end of this test
            // or after the first point of failure.
//            System.out.println("Printing out array deque: ");
//            arr1.printDeque();
//            System.out.println("Printing out array deque: ");
//            arr2.printDeque();
//            int index = 3;
//            System.out.printf("Print item at index %d: ", index);
//            System.out.println(arr1.get(index));
        }
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addLastRemoveLastTest() {
        System.out.println("Running addLast & removeLast test.");
        ArrayDeque<Integer> arr1 = new ArrayDeque<>(1);
        ArrayDeque<Integer> arr2 = new ArrayDeque<>(8);

        System.out.println("Printing out empty array deque 1: ");
        arr1.printDeque();
        System.out.println("Printing out empty array deque 2: ");
        arr2.printDeque();

        // Java will try to run the below code.
        // If there is a failure, it will jump to the finally block before erroring.
        // If all is successful, the finally block will also run afterwards.
        try {
            /**
             * Case 1: Test with minimum array size
             * New array will be created each time a new item is added
             */
            System.out.println("Running addLast & removeLast test on array 1.");
            assertTrue(arr1.isEmpty());
            arr1.addLast(1);
            arr1.addLast(2);
            arr1.addLast(3);
            arr1.addLast(4);
            System.out.println("Printing out array deque 1: ");
            arr1.printDeque();
            System.out.println();

            System.out.println("Remove last item in array deque 1");
            arr1.removeLast();

            System.out.println("Remove last item in array deque 1");
            arr1.removeLast();

            System.out.println("Remove last item in array deque 1");
            arr1.removeLast();

            System.out.println("Remove first item in array deque 1");
            arr1.removeLast();
            System.out.println("Printing out array deque 1: ");
            arr1.printDeque();
            assertTrue(arr1.isEmpty());

            System.out.println("Printing out array deque 1: ");
            arr1.printDeque();
//            assertTrue(arr1.isEmpty());

            /**
             * Case 2: Test with array size larger than number of items
             * There will be empty items inside array
             */
            System.out.println("Running addLast & removeLast test on array 2.");
            assertTrue(arr2.isEmpty());
            arr2.addLast(1);
            arr2.addLast(2);
            arr2.addLast(3);
            arr2.addLast(4);
            System.out.println("Printing out array deque 2: ");
            arr2.printDeque();
            System.out.println();

            System.out.println("Remove last item in array deque 2");
            arr2.removeLast();
            System.out.println("Printing out array deque 2: ");
            arr2.printDeque();

            System.out.println("Remove last item in array deque 2");
            arr2.removeLast();
            System.out.println("Printing out array deque 2: ");
            arr2.printDeque();

            System.out.println("Remove last item in array deque 2");
            arr2.removeLast();
            System.out.println("Printing out array deque 2: ");
            arr2.printDeque();

            System.out.println("Remove last item in array deque 2");
            arr2.removeLast();
            System.out.println("Printing out array deque 2: ");
            arr2.printDeque();
            assertTrue(arr2.isEmpty());
        }
        finally {

        }
    }
}
