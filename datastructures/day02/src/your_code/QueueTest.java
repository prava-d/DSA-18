import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;


public class QueueTest {

    private MyQueue queue;
    private MyPriorityQueue maxQueue;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        maxQueue = new MyPriorityQueue();
        maxQueue.enqueue(1);
        maxQueue.enqueue(2);
        maxQueue.enqueue(3);
    }

    /**
     * Tests functionality of a queue
     */
    public void testQueue(QueueADT<Integer> queue) {
        int e = queue.dequeue();
        assertEquals(e, 1);

        queue.enqueue(150);
        assertEquals(queue.isEmpty(), false);

        e = queue.dequeue();
        assertEquals(e, 2);
        assertEquals(queue.isEmpty(), false);

        e = queue.dequeue();
        assertEquals(e, 3);
        assertEquals(queue.isEmpty(), false);

        e = queue.dequeue();
        assertEquals(e, 150);
        assertEquals(queue.isEmpty(), true);
    }

    /**
     * Tests functionality of your_code.MyQueue
     */
    @Test
    public void testMyQueue() {
        testQueue(queue);
    }

    /**
     * Tests functionality of your_code.MyPriorityQueue
     */
    @Test
    public void testPriorityQueue() {
        maxQueue.enqueue(5);
        assertEquals(maxQueue.dequeueMax(), 5);
        maxQueue.enqueue(2);
        assertEquals(maxQueue.dequeueMax(), 3);
        assertEquals(maxQueue.dequeueMax(), 2);
        assertEquals(maxQueue.dequeueMax(), 2);
        assertEquals(maxQueue.dequeueMax(), 1);
    }

}