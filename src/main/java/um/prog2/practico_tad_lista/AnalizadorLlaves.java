package um.prog2.practico_tad_lista;

import um.prog2.tad.exceptions.EmptyStackException;
import um.prog2.tad.stack.Pila;
import um.prog2.tad.stack.PilaEnlazada;

public class AnalizadorLlaves {

    public boolean controlCorchetes (String expresion) {

        Pila<String> pila = new PilaEnlazada<>(); //En el PilaEnlazada<> no le pongo el tipo porque ya sabe que es del tipo String
        for (int i=0; i<expresion.length(); i++){

            char c = expresion.charAt(i);
            if (c=='{'){                            //Comillas simples es para el char, las dobles para el char mismo.

                pila.push("{");
            }
            else if (c=='}'){
                if (pila.isEmpty()){
                    return false;
                }
                try {
                    pila.pop();
                } catch (EmptyStackException ter) {
                    throw new RuntimeException(ter);  //ter es el nomnbre de la exeption
                }
            }
        }
        return pila.isEmpty();
    }

}
