package um.prog2.tad.listagenericos;

public class NodoGeneric<T>
{
    private NodoGeneric<T> siguiente;
    private T dato;

    public NodoGeneric()
    {

    }

    public NodoGeneric(T dato)
    {
        this.dato =  dato;
    }

    public NodoGeneric<T> getSiguiente()
    {
        return this.siguiente;
    }

    public void setSiguiente(NodoGeneric<T> nodo)
    {
        this.siguiente = nodo;
    }

    public T getDato()
    {
        return this.dato;
    }

    public void setDato(T dato)
    {
        this.dato = dato;
    }
}
