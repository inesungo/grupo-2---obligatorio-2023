package um.prog2.util;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * NO LICENCE
 * Author: Ing. Nicolás Navarro Gutérrez
 */
public final class KeyReader
{
    private static final String INPUT_ERROR = "El dato ingresado no es correcto. Vuelva a intentarlo.\n";
    private String proptLabel;

    public KeyReader()
    {
        this.proptLabel = "Input: ";
    }

    public KeyReader(String proptLabel)
    {
        this.proptLabel = proptLabel;
    }

    public int getInteger(String promptLabel)
    {
        Scanner sc = new Scanner(System.in);
        boolean hayErrores = true;
        int valor = 0;
        do
        {
            System.out.println(promptLabel);
            try
            {
                valor = sc.nextInt();
                hayErrores = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println(INPUT_ERROR);
                hayErrores = true;
            }
        } while (hayErrores);
        return valor;
    }

    public int getInteger()
    {
        return getInteger(this.proptLabel);
    }

    public double getDouble(String promptLabel)
    {
        Scanner sc = new Scanner(System.in);
        boolean hayErrores = true;
        double valor = 0;
        do
        {
            System.out.println(promptLabel);
            try
            {
                valor = sc.nextDouble();
                hayErrores = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println(INPUT_ERROR);
                hayErrores = true;
            }
        } while (hayErrores);
        return valor;
    }

    public double getDouble()
    {
        return getDouble(this.proptLabel);
    }

    public String getString(String promptLabel)
    {
        System.out.println(promptLabel);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String getString()
    {
        return getString(this.proptLabel);
    }
}
