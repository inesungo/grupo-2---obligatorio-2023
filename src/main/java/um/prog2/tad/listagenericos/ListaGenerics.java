package um.prog2.tad.listagenericos;

import um.prog2.tad.exceptions.IllegalIndexException;

public interface ListaGenerics<T>
{
    /*
    * Retorna verdadero si la lista no contiene elementos.
    * */
    public boolean esVacia();

    /*
    * Agreaga al principio de la lista. (Agrega en la cabeza o primero)
    * */
    public void agregar(T obj);

    /*
    * Agrega al final de la lista. (Agrega en la cola o último)
    * */
    public void agregarAlFinal(T obj);

    /*
    * Agrega en la posición indicada por el parámetro "index".
    * Se lanza excepción si el índice es negativo o mayór a la última posición donde se puede agregar en la lista.
    * */
    public void agregar(T obj, int index) throws IllegalIndexException;

    /*
    * Devuelve el largo de la lista. Si está vacía se devuelve 0
    * */
    public int largo();

    /*
    * Elimina un elemento de la lista en la posición "index" y devuelve el dato que se elimina.
    * Si la posición index no corresponde a una posición válida de la lista, se devuelve null
    * */
    public T quitar(int index);

    /*
     * Devuelve el dato de la lista en la posición "index".
     * Si la posición index no corresponde a una posición válida de la lista, se devuelve null
     * */
    public T elemento(int index);

    /*
    * La lista se queda sin elementos. La cabeza apunta a null y el largo es 0
    * */
    public void vaciar();

    /*
     * Emite por patnalla un toString de cada uno de los datos almacenados en los nodos con el siguiente formato:
     * <#indice>: <to string del objeto>
     * */
    public void imprimirDatos();
}
