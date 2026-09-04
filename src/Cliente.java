import java.util.*;

public class Cliente extends Persona
{
    private int cantPedidos;
    private int cantAtrasos;
    private int edad;
    private double multaAcumulada;
    private ArrayList<Pelicula> peliculasEnPosesion;
    private int maximoPeliculas; // por defecto 3
    private boolean aptoPrestamos;


    //constructores

    public Cliente()
    {
        super();
        cantPedidos = 0;
        cantAtrasos = 0;
        edad = 0;
        multaAcumulada = 0;
        peliculasEnPosesion = new ArrayList<>();
        maximoPeliculas = 3;
        aptoPrestamos = true;
    }

    public Cliente(String nombre, String rut, int edad)
    {
        super(nombre, rut);
        this.edad = edad;
        cantPedidos = 0;
        cantAtrasos = 0;
        multaAcumulada = 0;
        peliculasEnPosesion = new ArrayList<>();
        maximoPeliculas = 3;
        aptoPrestamos = true;
    }


    //metodos

    public boolean pedirPelicula(Pelicula pelicula)
    {
        if(aptoPrestamos && peliculasEnPosesion.size() < maximoPeliculas){
            if(pelicula.prestar()){
                peliculasEnPosesion.add(pelicula);
                return true;
            }
        }
        return false;
    }


    public boolean clienteDevolver(Pelicula pelicula)
    {
        if (peliculasEnPosesion.remove(pelicula))
        {
            pelicula.devolver();
            return true;
        }
        return false;
    }

    public double clientePagar(double montoPagar) //retorna el vuelto a darle al cliente
    {
        if(multaAcumulada == 0){
            return montoPagar;
        }else if(montoPagar >= multaAcumulada)
        {
            double vuelto = montoPagar - multaAcumulada;
            multaAcumulada = 0;
            return vuelto;
        }else
        {
            multaAcumulada -= montoPagar;
            return 0.0;
        }
    }


    @Override //buena practica para sobreescribir cualquier metodo
    public String identificarse()
    {
        String texto =  "";
        
        texto += "\nRol: Cliente";
        texto +=  "\nNombre: "+getNombre();
        texto +=  "\nEdad: "+getEdad();
        texto +=  "\nRut: "+getRut();
        texto +=  "\nCantidad de peliculas en posesion: "+peliculasEnPosesion.size();
        if(aptoPrestamos){
            texto +=  "\nEl cliente puede pedir peliculas";
        }else{
            texto +=  "\nEl cliente NO puede pedir peliculas";
        }
        texto +=  "\nMulta actual: $"+multaAcumulada;
        
        return texto;
        
    }



    //getter y setters

    public int getCantPedidos(){
        return cantPedidos;
    }

    public void setCantPedidos(int cantPedidos){
        this.cantPedidos = cantPedidos;
    }

    public int getCantAtrasos(){
        return cantAtrasos;
    }

    public void setCantAtrasos(int cantAtrasos){
        this.cantAtrasos = cantAtrasos;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public int getMaximoPeliculas(){
        return maximoPeliculas;
    }

    public void setMaximoPeliculas(int maximoPeliculas){
        this.maximoPeliculas = maximoPeliculas;
    }

    public double getMultaAcumulada(){
        return multaAcumulada;
    }

    public void setMultaAcumulada(double multaAcumulada){
        this.multaAcumulada = multaAcumulada;
    }

    public boolean isAptoPrestamos()
    {
        return aptoPrestamos;
    }

}