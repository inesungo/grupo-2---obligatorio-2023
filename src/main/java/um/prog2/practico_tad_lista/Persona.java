package um.prog2.practico_tad_lista;

import java.util.Date;

public class Persona
{
    private String nombre;
    private String apellido;
    private char genero;
    private Date fechaNacimiento;
    private int cedula;

    public Persona()
    {

    }

    public Persona(String nombre, String apellido, char genero, Date fechaNacimiento, int cedula)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public char getGenero()
    {
        return genero;
    }

    public void setGenero(char genero)
    {
        this.genero = genero;
    }

    public Date getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCedula()
    {
        return cedula;
    }

    public void setCedula(int cedula)
    {
        this.cedula = cedula;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        return sb.append("{CI:")
                .append(this.cedula)
                .append(",NOMBRE:")
                .append(this.nombre)
                .append(",APELLIDO:")
                .append(this.apellido)
                .toString();
    }
}
