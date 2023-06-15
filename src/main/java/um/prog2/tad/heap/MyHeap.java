package um.prog2.tad.heap;

public interface MyHeap<T extends Comparable<T>>{

    void agregar(T object) throws Exception;

    T obtenerYEliminar() throws Exception;

    int obtenerTamanio();

    void mostrarArbol();
}
