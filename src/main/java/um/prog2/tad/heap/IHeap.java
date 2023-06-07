package um.prog2.tad.heap;

public interface IHeap <T extends Comparable<T>>{
    void agregar(T object) throws Exception;
    T obtenerYEliminar()throws Exception;
    int obtenerTamanio();
    void mostrarArbol();
}
