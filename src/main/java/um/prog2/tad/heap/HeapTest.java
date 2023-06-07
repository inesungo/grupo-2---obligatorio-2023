package um.prog2.tad.heap;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class HeapTest {
    @Test
    public void testAgregar() {
        try {
            Heap<Integer> heap = new Heap<>(5, true);
            heap.agregar(5);
            heap.agregar(10);
            heap.agregar(2);
            assertEquals(3, heap.obtenerTamanio());
        }catch(Exception ex){

        }
    }

    @Test
    public void testObtenerYEliminar() {
        Heap<Integer> heap = new Heap<>(5, true);
        try {
            heap.agregar(5);
            heap.agregar(10);
            heap.agregar(2);
            assertEquals(10, heap.obtenerYEliminar().intValue());
            assertEquals(2, heap.obtenerTamanio());
        }catch(Exception ex){

        }
    }

    @Test
    public void testObtenerTamanio() {
        try {
            Heap<Integer> heap = new Heap<>(5, true);
            assertEquals(0, heap.obtenerTamanio());

            heap.agregar(5);
            assertEquals(1, heap.obtenerTamanio());

            heap.agregar(10);
            heap.agregar(2);
            assertEquals(3, heap.obtenerTamanio());

            heap.obtenerYEliminar();
            assertEquals(2, heap.obtenerTamanio());
        }catch(Exception ex)
        {

        }
    }

    @Test
    public void testMostrarArbol() {
        try {
            Heap<Integer> heap = new Heap<>(5, true);
            heap.agregar(5);
            heap.agregar(10);
            heap.agregar(2);

            // Redirigir la salida estándar para capturarla en una variable
            ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
            PrintStream salidaOriginal = System.out;
            System.setOut(new PrintStream(salidaCapturada));

            heap.mostrarArbol();
            assertEquals("10 5 2", salidaCapturada.toString().trim());

            // Restaurar la salida estándar original
            System.setOut(salidaOriginal);
        }catch(Exception ex){

        }
    }
}
