package um.prog2.tad.exceptions;

public class EmptyHeadException extends Exception{

    public EmptyHeadException(){
        super("Error: Stack vacio");
    }
}
