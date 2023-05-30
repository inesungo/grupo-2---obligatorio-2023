package um.prog2.tad.lista;

public class Nodo
{
    private Nodo siguiente;
    private Object dato;

    public Nodo()
    {

    }

    public Nodo(Object dato)
    {
        this.dato = dato;
    }

    public Nodo getSiguiente()
    {
        return this.siguiente;
    }

    public void setSiguiente(Nodo nodo)
    {
        this.siguiente = nodo;
    }

    public Object getDato()
    {
        return this.dato;
    }

    public void setDato(Object dato)
    {
        this.dato = dato;
    }
}
