package um.prog2.practico_tad_lista;

import um.prog2.tad.exceptions.EmptyStackException;
import um.prog2.tad.stack.Pila;
import um.prog2.tad.stack.PilaEnlazada;

public class Calculadora {

    public static int evaluarPosfija(String expresion) throws EmptyStackException {

        Pila<Integer> pila = new PilaEnlazada<>();
        int resultado = 0;

        for (int i = 0; i < expresion.length(); i++) {

            char c = expresion.charAt(i);
            if (Character.isDigit(c)) {                            //Comillas simples es para el char, las dobles para el char mismo.

                pila.push(Character.getNumericValue(c));
            } else {
                int numero2 = pila.pop();
                int numero1 = pila.pop();

                if (c == '+') {
                    resultado = numero1 + numero2;
                    pila.push(resultado);
                };
                if (c == '-') {
                    resultado = numero1 - numero2;
                    pila.push(resultado);
                };
                if (c == '*') {
                    resultado = numero1 * numero2;
                    pila.push(resultado);
                };
                if (c == '/') {
                    resultado = numero1 / numero2;
                    pila.push(resultado);
                };
            }

        }

        return resultado;
    }
}