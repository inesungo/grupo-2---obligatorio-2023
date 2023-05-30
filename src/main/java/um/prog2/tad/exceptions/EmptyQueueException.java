package um.prog2.tad.exceptions;

public class EmptyQueueException extends Exception{

    public EmptyQueueException(){
        super("Error: Stack vacio");
    }
}
