package modelo;

import excepciones.RutInvalidoException;

public abstract class Persona
/* 
abstract porque en nuestro sistema "no existen" personas sin un rol (son cliente o encargado) 
entonces, se restringe la creacion de personas con un new Persona (eso queda en manos de las sub clases)
*/
{
    private String nombre;
    private String rut;

// constructores

    public Persona()
    {
        nombre = "";
        rut = "";
    }

    public Persona(String nombre, String rut) 
    {
        this.nombre = nombre;
        setRut(rut);
    }

//metodos

    public static void validarRut(String rut) {
        if (rut == null || !rut.matches("\\d{7,8}-[\\dkK]")) {
            throw new RutInvalidoException("El RUT ingresado no tiene un formato válido (ej: 12345678-K).");
        }
    }
    public abstract String identificarse(); //cada sub clase debe implementar (o no, dependiendo si se convierte en una super) "su propio" identificarse

//getter y setters

    public String getNombre()
    {
        return nombre;
    } 

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getRut()
    {
        return rut;
    }

    public void setRut(String rut) {
        validarRut(rut);
        this.rut = rut;
    }    


}