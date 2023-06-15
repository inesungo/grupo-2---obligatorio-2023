package um.prog2.tad.lista;

import org.junit.jupiter.api.Test;
import um.prog2.tad.exceptions.EmptyStackException;
import um.prog2.tad.stack.LinkedStack;

import static org.junit.jupiter.api.Assertions.*;



class LinkedStackTest {

    @Test
    void push() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(5);
        stack.push(10);
        stack.push(2);

        assertEquals(2, stack.top());
    }

    @Test
    void pop() throws EmptyStackException {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(5);
        stack.push(10);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(10, stack.pop());
        assertEquals(5, stack.pop());

        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void top() throws EmptyStackException {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(5);
        stack.push(10);
        stack.push(2);

        assertEquals(2, stack.top());

        stack.pop();
        assertEquals(10, stack.top());

        stack.pop();
        assertEquals(5, stack.top());

        stack.pop();
        assertThrows(EmptyStackException.class, stack::top);
    }

    @Test
    void isEmpty() throws EmptyStackException {
        LinkedStack<Integer> stack = new LinkedStack<>();
        assertTrue(stack.isEmpty());

        stack.push(5);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void clear() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(5);
        stack.push(10);
        stack.push(2);

        assertFalse(stack.isEmpty());

        stack.clear();
        assertTrue(stack.isEmpty());
    }
}
