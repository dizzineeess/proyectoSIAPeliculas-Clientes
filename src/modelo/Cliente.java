package modelo;

import java.util.ArrayList;

public class Cliente extends Persona
{
    private int cantPedidos;
    private int cantAtrasos;
    private int edad;
    private double multaAcumulada;
    private ArrayList<Pelicula> peliculasEnPosesion = new ArrayList<>();
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
        maximoPeliculas = 3;
        aptoPrestamos = true;
    }
    
    public Cliente(String nombre, String rut)
    {
        super(nombre, rut);
        this.edad = -1;
        cantPedidos = 0;
        cantAtrasos = 0;
        multaAcumulada = 0;
        maximoPeliculas = 3;
        aptoPrestamos = true;
    }


    //metodos

    public boolean pedirPelicula(Pelicula pelicula)
    {
        if (pelicula == null) return false;

        if (!aptoPrestamos || peliculasEnPosesion.size() >= maximoPeliculas) {
            return false;
        }

        if (pelicula.isMayor18() && edad < 18) {
            return false; 
        }

        if (pelicula.prestar()) {
            peliculasEnPosesion.add(pelicula);
            cantPedidos++;
            return true;
        }

        return false;    
    }
    
        public boolean clienteDevolver(Pelicula pelicula)
    {
        if (!peliculasEnPosesion.isEmpty()){
            if (peliculasEnPosesion.remove(pelicula))
            {
                pelicula.devolver();
                actualizarAptitud();
                return true;
            }
        }
        
        return false;
    }

    public boolean actualizarAptitud(){
        if (multaAcumulada > 0 || cantAtrasos >= 3) {
            aptoPrestamos = false;
        } else {
            aptoPrestamos = true;
        }
        return aptoPrestamos;
    }

    public double clientePagar(double montoPagar) //retorna el vuelto a darle al cliente
    {
        if(multaAcumulada == 0){
            return montoPagar;
        }else if(montoPagar >= multaAcumulada)
        {
            double vuelto = montoPagar - multaAcumulada;
            multaAcumulada = 0;
            actualizarAptitud();
            return vuelto;
        }else
        {
            multaAcumulada -= montoPagar;
            actualizarAptitud();
            return 0.0;
        }
    }
    
    public boolean renovarPrestamo(Pelicula pelicula){
        if(peliculasEnPosesion.contains(pelicula) && aptoPrestamos){
            pelicula.extenderPlazo(7); //default
            return true;
        }
        return false;
    }
    
    public boolean renovarPrestamo(Pelicula pelicula, int dias){
        if(peliculasEnPosesion.contains(pelicula) && aptoPrestamos && dias <= 7){
            pelicula.extenderPlazo(dias); //dias especificos
            return true;
        }
        return false;
    }
    

    @Override //buena practica para sobreescribir cualquier metodo
    public String identificarse()
    {
        String texto =  "";
        
        texto += "\nRol: Cliente";
        texto +=  "\nNombre: "+getNombre();
        if(getEdad() == -1)
        {
            texto +=  "\nEdad: No especificada";
        }
        else
        {
            texto +=  "\nEdad: "+getEdad();
        }
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
    
    public Pelicula buscarPeliculaDelCliente(int idBuscada) {
        int p = 0, u = peliculasEnPosesion.size()-1, i;
        Pelicula enc = null;
        
        while ((p<=u)&&(enc == null)) {
            i=(p+u)/2;
            int idActual = peliculasEnPosesion.get(i).getIdPelicula();
            if (idActual == idBuscada) enc = peliculasEnPosesion.get(i);
            else {
                if (idActual > idBuscada) u = i-1;
                else p = i+1;
            }
        }
        return enc;
    }
    public boolean buscarPeliculaDelCliente(Pelicula buscada) {
    int p = 0;
    int u = peliculasEnPosesion.size() - 1;
    boolean enc = false;
    
    while ((p <= u) && (!enc)) {
        int i = (p + u) / 2;
        Pelicula actual = peliculasEnPosesion.get(i);
        
        if (actual.getIdPelicula() == buscada.getIdPelicula()) {
            enc = true; 
        } else if (actual.getIdPelicula() > buscada.getIdPelicula()) {
            u = i - 1; 
        } else {
            p = i + 1; 
        }
    }
    return enc;
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
        if(edad > 120 || edad < 0){
            throw new IllegalArgumentException("La edad debe estar entre 0 y 120 años.");
        }this.edad = edad;
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