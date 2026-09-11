package servicio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import modelo.Cliente;
import modelo.Encargado;
import modelo.Pelicula;
import util.PersistenciaCSV;

/*
    Clase creada para salvaguardar la lógica de negocio fuera de cualquier menú (sea ventana o consola).
    Funciona como "base de datos" o inventario del negocio.
    Deberá llamarse cada vez que se quiera utilizar algo que el negocio provea.
 */
public class SistemaVideoClub {

    private ArrayList<Pelicula> arrayListCatalogo = new ArrayList<>();
    private HashMap<String, Cliente> mapaClientes = new HashMap<>();
    private HashMap<String, Encargado> mapaEmpleados = new HashMap<>();

    public SistemaVideoClub() {
        PersistenciaCSV.cargar(this);
    }

    public Collection<Cliente> listarClientes() {
        return Collections.unmodifiableCollection(mapaClientes.values());
    }

    public Collection<Encargado> listarEmpleados() {
        return Collections.unmodifiableCollection(mapaEmpleados.values());
    }

    public List<Pelicula> listarPeliculas() {
        return Collections.unmodifiableList(arrayListCatalogo);
    }

    public boolean incorporarCliente(Cliente agregar) {
        if (agregar == null || mapaClientes.containsKey(agregar.getRut())) {
            return false;
        }
        mapaClientes.put(agregar.getRut(), agregar);
        return true;
    }

    public boolean incorporarEmpleado(Encargado encargado) {
        if (encargado == null || mapaEmpleados.containsKey(encargado.getIdEmpleado())) {
            return false;
        }
        mapaEmpleados.put(encargado.getIdEmpleado(), encargado);
        return true;
    }

    public void incorporarPelicula(Pelicula nueva) {
        if (nueva == null || busquedaBinariaPeliculas(nueva.getIdPelicula()) != null) {
            return;
        }
        int i = 0;
        while (i < arrayListCatalogo.size() && arrayListCatalogo.get(i).getIdPelicula() < nueva.getIdPelicula()) {
            i++;
        }
        arrayListCatalogo.add(i, nueva);
    }

    public void incorporarPrestamo(String rut, int idPelicula) {
        Cliente cliente = mapaClientes.get(rut);
        Pelicula pelicula = busquedaBinariaPeliculas(idPelicula);
        if (cliente != null && pelicula != null) {
            cliente.cargarPeliculaEnPosesion(pelicula);
        }
    }

    private void guardarDatos() {
        PersistenciaCSV.guardar(this);
    }
   
    public boolean agregarCliente(Cliente agregar)
    {
        if (incorporarCliente(agregar)) {
            guardarDatos();
            return true;
        }
        return false;
    }
    
    public boolean quitarCliente(String key)
    {
        if(mapaClientes.containsKey(key))
        {
            mapaClientes.remove(key);
            guardarDatos();
            return true;
        }
        return false;

    }
    
    public String mostrarCliente(String key)
    {
        if(mapaClientes.containsKey(key))
        {
            Cliente mostrar = mapaClientes.get(key);
            return mostrar.identificarse();

        }
        return "Cliente no existe";
    }
    
    public Cliente obtenerCliente(String rut)
    {
        if(mapaClientes.containsKey(rut))
        {
            return mapaClientes.get(rut);
        }
        return null;
    }
    
    public Encargado obtenerEmpleado(String id)
    {
        if(mapaEmpleados.containsKey(id))
        {
            return mapaEmpleados.get(id);
        }
        return null;
    }
    
    public String prestar(int id, String rut)
    {
        Cliente cliente = mapaClientes.get(rut);
        Pelicula pelicula = busquedaBinariaPeliculas(id);
        if ( cliente.pedirPelicula(pelicula) ){
            guardarDatos();
            return "Pelicula prestada exitosamente.";
        } else {
            return "No se pudo prestar.";
        }
    }

    
    public void agregarOrdenado(Pelicula nueva) {
        incorporarPelicula(nueva);
        guardarDatos();
    }

    
    public Pelicula busquedaBinariaPeliculas(int idBuscada) {
        int p = 0, u = arrayListCatalogo.size()-1, i;
        Pelicula enc = null;
        
        while ((p<=u)&&(enc == null)) {
            i=(p+u)/2;
            int idActual = arrayListCatalogo.get(i).getIdPelicula();
            if (idActual == idBuscada) enc = arrayListCatalogo.get(i);
            else {
                if (idActual > idBuscada) u = i-1;
                else p = i+1;
            }
        }
        return enc;
    }
    
    public Pelicula obtenerPeliculaCliente(int id, String rut)
    {
        if(!mapaClientes.containsKey(rut))
        {
            return null;
        }
        else if(busquedaBinariaPeliculas(id) == null)
        {
            return null;
        }
        Cliente cliente = mapaClientes.get(rut);
        Pelicula pelicula = cliente.buscarPeliculaDelCliente(id);
        return pelicula;
        
    }
    
    public String recibirPago(double monto, String rut)
    {
        if(!mapaClientes.containsKey(rut))
        {
            return "Cliente no existe";
        }
        Cliente cliente = mapaClientes.get(rut);
        
        double vuelto = cliente.clientePagar(monto);
        guardarDatos();
        
        return "Pago exitoso." + 
                "\nEstado multa: " + cliente.getMultaAcumulada() + 
                "\nVuelto: " + vuelto;
    }
    
    public String recibirPeliculaPrestada(int id, String rut)
    {
        Pelicula p = busquedaBinariaPeliculas(id);
        if(!mapaClientes.containsKey(rut))
        {
            return "Cliente no existe";
        }else if(p == null)
        {
            return "Pelicula no esta en catalogo";
        }
        Cliente c = mapaClientes.get(rut);
        if( c.buscarPeliculaDelCliente(p) )
        {
            c.clienteDevolver(p);
            guardarDatos();
            return "Recepcion exitosa";
        }
        
        return "No se pudo llevar a cabo la recepcion";
    }
    
    public String renovar(int id, String rut)
    {
        if(!mapaClientes.containsKey(rut))
        {
            return "Cliente no existe.";
        }else if(busquedaBinariaPeliculas(id) == null)
        {
            return "No se encontro la pelicula.";
        }
        Cliente cliente = mapaClientes.get(rut);
        Pelicula p = cliente.buscarPeliculaDelCliente(id);
                if(cliente.renovarPrestamo(p))
        {
            guardarDatos();
            return "Renovacion exitosa." +
                    "\nDias restantes: " + p.getPlazoEntrega();
        }
        return "Renovacion fallida.";

    }

    public String renovar(int id, String rut, int dias) //sobrecarga en consola
    {
        if(!mapaClientes.containsKey(rut))
        {
            return "Cliente no existe.";
        }else if(busquedaBinariaPeliculas(id) == null)
        {
            return "No se encontro la pelicula.";
        }else if(dias > 7){
            return "No es posible renovar por mas de una semana a la vez.";
        }
        Cliente cliente = mapaClientes.get(rut);
        Pelicula p = cliente.buscarPeliculaDelCliente(id);
                if(cliente.renovarPrestamo(p,dias))
        {
            guardarDatos();
            return "Renovacion exitosa." +
                    "\nDias restantes: " + p.getPlazoEntrega();
        }
        return "Renovacion fallida.";

    }
    
    public String agregarEmpleado(Encargado e)
    {
        if (incorporarEmpleado(e)) {
            guardarDatos();
            return "Empleado ingresado con exito";
        }
        return "Ya existe un empleado con ese codigo";

    }
    
    public String quitarEmpleado(String id)
    {
        if(mapaEmpleados.containsKey(id))
        {
            mapaEmpleados.remove(id);
            guardarDatos();
            return ("Empleado eliminado");
        }else return ("Empleado no existe");
    }

    public String mostrarClientesAtrasados()
    {
        boolean hayAtrasados = false;
        
        for(Cliente cliente : mapaClientes.values()) {
            if(cliente.getCantAtrasos()> 0){
                cliente.identificarse();
                System.out.println("\n_________________________\n");
                hayAtrasados = true;
            }
        }

        if(hayAtrasados){
            return "a";
        }else{
            return "No existen clientes con atarasos.";
        }

    }
    
    public String mostrarEmpleado(String id)
    {
        if(mapaEmpleados.containsKey(id))
        {
            Encargado mostrar = mapaEmpleados.get(id);
            return mostrar.identificarse();
        }else return ("Empleado no existe");

    }
    
    public String cambioDeTurno(String id, String turno)
    {
        if(mapaEmpleados.containsKey(id))
        {
            Encargado encargado = mapaEmpleados.get(id);
            encargado.cambiarTurno(turno);
            guardarDatos();
            return ("Turno actualizado");
        }else return ("Empleado no existe");

    }
    
    public String cambioDeSueldo(String id, double sueldo)
    {
        if(mapaEmpleados.containsKey(id))
        {
            Encargado encargado = mapaEmpleados.get(id);

            encargado.setSueldoBase(sueldo);
            guardarDatos();
            return ("Sueldo actualizado");
        }else return ("Empleado no existe");
    }
    
    public static Encargado buscarEmpleadoPorId(HashMap<String,Encargado> mapaEmpleados, String idEmpleado) {
        for(Encargado encargado : mapaEmpleados.values())
        {
            if(encargado.getIdEmpleado().equals(idEmpleado))
                return encargado;
        }
        return null;
    }

    public String eliminarPelicula(int id)
    {
        Pelicula eliminar = busquedaBinariaPeliculas(id);
        if(eliminar != null)
        {
            if (arrayListCatalogo.remove(eliminar)) {
                guardarDatos();
                return ("Pelicula eliminada exitosamente");
            }
            }                
        return ("No se elimino la pelicula");
        

    }
    
    public String mostrarCatalogoPeliculas() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n_________________________\n");
        for (Pelicula act : arrayListCatalogo) {
            sb.append("ID: ").append(act.getIdPelicula())
              .append("\nTitulo: ").append(act.getTitulo())
              .append("\nAño: ").append(act.getEstrenoYear())
              .append("\nGenero: ").append(act.getGenero())
              .append("\nCopias disponibles: ").append(act.getCopiasDisponibles())
              .append("\n_________________________\n");
        }
        
        return sb.toString();    
    }
    
    public String mostrarTodosClientes()
    {
        if(mapaClientes.isEmpty())
        {
            return "\nNo hay clientes para mostrar\n";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n_________________________\n");
        for (Cliente act : mapaClientes.values()) {
            String mostrar = act.getRut();
            sb.append(mostrarCliente(mostrar))
            .append("\n_________________________\n");
        }
        
        return sb.toString();    
    }
    
}
