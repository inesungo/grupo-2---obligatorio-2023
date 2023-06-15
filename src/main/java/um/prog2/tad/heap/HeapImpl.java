package um.prog2.tad.heap;



public class HeapImpl<T extends Comparable<T>> implements MyHeap<T> {
    private T[] vector;
    private int tope;
    private int maximo;
    public HeapImpl(int capacidad, boolean maximo)
    {
        vector=(T[])new Comparable[capacidad];
        tope=0;
        if(maximo)
            this.maximo=1;
        else
            this.maximo=-1;
    }
    @Override
    public void agregar(T object) throws Exception {
        if(vector.length==tope)
            throw new Exception("Esta lleno");
        vector[tope]=object;
        flotar(tope);
        tope++;
    }
    private void flotar(int indice)
    {

        int padre=(indice/2);
        if(indice>0 && vector[indice].compareTo(vector[padre])*maximo>0)
        {
            T swap=vector[indice];
            vector[indice]=vector[padre];
            vector[padre]=swap;
            flotar(padre);
        }
    }
    @Override
    public T obtenerYEliminar() throws Exception {
        Exception EmptyHeadException = null;
        if(tope==0)
            throw EmptyHeadException;
        T retorno=vector[1];
        vector[1]=vector[tope];
        vector[tope]=null;
        tope--;
        hundir(1);
        return retorno;
    }

    private void hundir(int  indice){
        int izq=2*indice;
        int der=2*indice+1;


        if(izq<vector.length)
        {
            T hijaMayor=vector[izq];
            int indiceMayor=izq;
            if(hijaMayor.compareTo(vector[der])*maximo>0) {
                hijaMayor = vector[der];
                indiceMayor=der;
            }

            if(hijaMayor.compareTo(vector[indice])*maximo>0)
            {
                T swap=vector[indice];
                vector[indice]=vector[indiceMayor];
                vector[indiceMayor]=swap;

            }


        }

    }
    @Override
    public int obtenerTamanio() {
        return tope;
    }

    @Override
    public void mostrarArbol() {
        for(int i=0;i<tope;i++)
        {
            System.out.print(vector[i]+"");
        }
        System.out.println("");
    }
}