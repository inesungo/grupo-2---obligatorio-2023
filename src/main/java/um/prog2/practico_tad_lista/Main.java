package um.prog2.practico_tad_lista;

import um.prog2.tad.exceptions.EmptyQueueException;
import um.prog2.tad.listagenericos.ListaGenerics;
import um.prog2.tad.queue.Queue;
import um.prog2.tad.queue.QueueEnlazadaPunterdos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main
{
    public static void main(String[] args)
    {
        Persona p1 = new Persona("Darlene","Alderson", 'F', getNewDate("05/11/1990"), 12345678);
        Persona p2 = new Persona("Elliot","Bastard", 'M', getNewDate("17/09/1986"), 87654321);
        Persona p3 = new Persona("Angela","Celine", 'F', getNewDate("27/02/1988"), 23456789);
        Persona p4 = new Persona("Tyrell","Dimitri", 'M', getNewDate("11/07/1982"), 34567890);

        //////// PRUEBA LISTA GENERICS /////////

        /*

        /////// AGREGAR ////////
        ListaGenerics<Persona> listaPersonas = new ListaEnlazadaGenerics<>();
        listaPersonas.agregar(p1);
        listaPersonas.agregar(p2);
        listaPersonas.agregar(p3);
        listaPersonas.agregar(p4);

        System.out.println(listaPersonas.elemento(0));
        System.out.println(listaPersonas.elemento(1));
        System.out.println(listaPersonas.elemento(2));
        System.out.println(listaPersonas.elemento(3));

        System.out.println("         ");

        /////// AGREGAR AL FINAL ////////
        ListaGenerics<Persona> listaPersonas2 = new ListaEnlazadaGenerics<>();
        listaPersonas2.agregarAlFinal(p1);
        System.out.println(listaPersonas2.elemento(0));
        listaPersonas2.agregarAlFinal(p2);
        System.out.println(listaPersonas2.elemento(1));
        listaPersonas2.agregarAlFinal(p3);
        System.out.println(listaPersonas2.elemento(2));
        listaPersonas2.agregarAlFinal(p4);
        System.out.println(listaPersonas2.elemento(3));

        System.out.println("     ");

        /////// AGREGAR GENERICO ////////
        ListaGenerics<Persona> listaPersonas3 = new ListaEnlazadaGenerics<>();
        listaPersonas3.agregar(p1);
        listaPersonas3.agregar(p2);
        listaPersonas3.agregar(p3);

        System.out.println(listaPersonas3.elemento(0));
        System.out.println(listaPersonas3.elemento(1));
        System.out.println(listaPersonas3.elemento(2));

        System.out.println("");
        System.out.println("Y ahora agregando a Wellick en la posicion 2");
        System.out.println("");

        try {
            listaPersonas3.agregar(p4, 2);   //Wellick
        } catch (IllegalIndexException e) {
            throw new RuntimeException(e);
        }

        System.out.println(listaPersonas3.elemento(0));
        System.out.println(listaPersonas3.elemento(1));
        System.out.println(listaPersonas3.elemento(2));
        System.out.println(listaPersonas3.elemento(3));

        System.out.println("         ");



        /////// QUITAR ////////
        ListaGenerics<Persona> listaPersonas4 = new ListaEnlazadaGenerics<>();
        listaPersonas4.agregar(p1);
        listaPersonas4.agregar(p2);
        listaPersonas4.agregar(p3);
        listaPersonas4.agregar(p4);

        System.out.println(listaPersonas4.elemento(0));
        System.out.println(listaPersonas4.elemento(1));
        System.out.println(listaPersonas4.elemento(2));
        System.out.println(listaPersonas4.elemento(3));

        System.out.println("");
        System.out.println("Elimino");
        System.out.println("");

        System.out.println(listaPersonas4.quitar(0));



        /////// ELEMENTO ////////
        ListaGenerics<Persona> listaPersonas5 = new ListaEnlazadaGenerics<>();
        listaPersonas5.agregar(p1);
        listaPersonas5.agregar(p2);
        listaPersonas5.agregar(p3);
        listaPersonas5.agregar(p4);

        System.out.println(listaPersonas5.elemento(0));
        System.out.println(listaPersonas5.elemento(1));
        System.out.println(listaPersonas5.elemento(2));
        System.out.println(listaPersonas5.elemento(3));


        System.out.println("         ");

        listaPersonas5.vaciar();

        listaPersonas5.imprimirDatos();






        /////////// STACK //////////


        Pila<Persona> pila1 = new PilaEnlazada<>();
        Pila<Persona> pila2 = new PilaArrays<>();

        pila1.push(p1);
        pila2.push(p1);
        pila2.push(p2);

        System.out.println(pila1.top());
        System.out.println(pila2.top());


        boolean pruebaLlaves = new  AnalizadorLlaves().controlCorchetes("}{{}}");
        System.out.println(pruebaLlaves);



        try {
            int resultado = new Calculadora().evaluarPosfija("44+1-");
            System.out.println(resultado);


        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }

*/


        //////// PRUEBA QUEUE ////////////

        Queue<Persona> queue1 = new QueueEnlazadaPunterdos<>();
        queue1.enqueue(p1);
        queue1.enqueue(p2);
        queue1.enqueue(p3);
        queue1.enqueue(p3);

        try {
            System.out.println(queue1.dequeue());
            System.out.println(queue1.dequeue());
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);
        }











































































    }

    public static void generarYAgregarPersonas(ListaGenerics unaLista)
    {
        Persona p1 = new Persona("Darlene","Alderson", 'F', getNewDate("05/11/1990"), 12345678);
        unaLista.agregar(p1);
        p1 = new Persona("Elliot","Alderson", 'M', getNewDate("17/09/1986"), 87654321);
        unaLista.agregar(p1);
        p1 = new Persona("Angela","Moss", 'F', getNewDate("27/02/1988"), 23456789);
        unaLista.agregar(p1);
        p1 = new Persona("Tyrell","Wellick", 'M', getNewDate("11/07/1982"), 34567890);
        unaLista.agregar(p1);
    }

    public static Date getNewDate(String sDate)
    {
        try
        {
            Date date = (new SimpleDateFormat("dd/MM/yyyy")).parse(sDate);
            return date;
        }
        catch (ParseException ex)
        {
            return null;
        }
    }
}
