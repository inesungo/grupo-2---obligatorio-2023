package um.prog2.tad.exceptions;

public class EmptyStackException extends Exception
{
    public EmptyStackException(){
        super("Error: Stack vacio");
    }
}
