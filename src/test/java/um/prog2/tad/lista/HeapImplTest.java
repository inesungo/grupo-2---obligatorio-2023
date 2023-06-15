package um.prog2.tad.lista;

import org.junit.jupiter.api.Test;
import um.prog2.tad.heap.HeapImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HeapImplTest {

    @Test
    void agregar() throws Exception {
        HeapImpl<Integer> maxHeap = new HeapImpl<>(5, true);
        maxHeap.agregar(5);
        maxHeap.agregar(10);
        maxHeap.agregar(2);

        assertEquals(10, maxHeap.obtenerYEliminar());
        assertEquals(5, maxHeap.obtenerYEliminar());
        assertEquals(2, maxHeap.obtenerYEliminar());
    }

    @Test
    void obtenerYEliminar() throws Exception {
        HeapImpl<Integer> maxHeap = new HeapImpl<>(5, true);
        maxHeap.agregar(5);
        maxHeap.agregar(10);
        maxHeap.agregar(2);

        assertEquals(10, maxHeap.obtenerYEliminar());
        assertEquals(5, maxHeap.obtenerYEliminar());
        assertEquals(2, maxHeap.obtenerYEliminar());
    }

    @Test
    void obtenerTamanio() throws Exception {
        HeapImpl<Integer> maxHeap = new HeapImpl<>(5, true);
        assertEquals(0, maxHeap.obtenerTamanio());

        maxHeap.agregar(5);
        assertEquals(1, maxHeap.obtenerTamanio());

        maxHeap.agregar(10);
        maxHeap.agregar(2);
        assertEquals(3, maxHeap.obtenerTamanio());

        maxHeap.obtenerYEliminar();
        assertEquals(2, maxHeap.obtenerTamanio());
    }

    @Test
    void mostrarArbol() throws Exception {
        HeapImpl<Integer> maxHeap = new HeapImpl<>(5, true);
        maxHeap.agregar(5);
        maxHeap.agregar(10);
        maxHeap.agregar(2);


        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;
        System.setOut(new PrintStream(salidaCapturada));

        maxHeap.mostrarArbol();
        assertEquals("10 5 2", salidaCapturada.toString().trim());


        System.setOut(salidaOriginal);
    }
}
