package um.prog2.tad.lista;

import um.prog2.tad.exceptions.IllegalIndexException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedMyListTest {

    MyLinkedListImpl listaPrueba = new MyLinkedListImpl();

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(listaPrueba.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void add() {
        listaPrueba.add("5");
        listaPrueba.add("2");
        listaPrueba.add("88");
        listaPrueba.add("12");

        assertEquals("5", listaPrueba.elemento(0));
        assertEquals("2", listaPrueba.elemento(1));
        assertEquals("88", listaPrueba.elemento(2));
        assertEquals("12", listaPrueba.elemento(3));
    }

    @org.junit.jupiter.api.Test
    void addlast() {
        listaPrueba.addlast("99");
        assertEquals("99", listaPrueba.elemento(listaPrueba.large() - 1));
    }

    @org.junit.jupiter.api.Test
    void testAdd() throws IllegalIndexException {
        listaPrueba.add("100", 0);
        assertEquals("100", listaPrueba.elemento(0));
    }

    @org.junit.jupiter.api.Test
    void large() {
        assertEquals(4, listaPrueba.large());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        String removedElement = (String) listaPrueba.remove(0);
        assertEquals("5", removedElement);
        assertEquals("2", listaPrueba.elemento(0));
    }

    @org.junit.jupiter.api.Test
    void elemento() {
        assertEquals("88", listaPrueba.elemento(2));
    }

    @org.junit.jupiter.api.Test
    void clear() {
        listaPrueba.clear();
        assertTrue(listaPrueba.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void printData() {

    }

    @org.junit.jupiter.api.Test
    void getFirst() {
        assertNull(listaPrueba.getFirst());
    }
}
