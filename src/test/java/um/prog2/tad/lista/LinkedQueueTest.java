package um.prog2.tad.lista;

import org.junit.jupiter.api.Test;
import um.prog2.tad.exceptions.EmptyQueueException;
import um.prog2.tad.queue.LinkedQueue;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    @Test
    void enqueue() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals("A", queue.element(0));
        assertEquals("B", queue.element(1));
        assertEquals("C", queue.element(2));
    }

    @Test
    void dequeue() throws EmptyQueueException {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void isEmpty() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue("A");
        assertFalse(queue.isEmpty());
    }

    @Test
    void size() throws EmptyQueueException {
        LinkedQueue<String> queue = new LinkedQueue<>();
        assertEquals(0, queue.size());

        queue.enqueue("A");
        assertEquals(1, queue.size());

        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals(3, queue.size());

        queue.dequeue();
        assertEquals(2, queue.size());
    }
}
