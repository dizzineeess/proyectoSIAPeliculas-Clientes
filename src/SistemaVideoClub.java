import java.util.ArrayList;
import java.util.HashMap;

/*
    Clase creada para salvaguardar la lógica de negocio fuera de cualquier menú (sea ventana o consola).
    Funciona como "base de datos" o inventario del negocio.
    Deberá llamarse cada vez que se quiera utilizar algo que el negocio provea.
 */
public class SistemaVideoClub {

    private ArrayList<Pelicula> arrayListCatalogo = new ArrayList<>();
    private HashMap<String, Cliente> mapaClientes = new HashMap<>();
    private HashMap<String, Encargado> mapaEmpleados = new HashMap<>();
   
    public boolean agregarCliente(Cliente agregar)
    {
        if(!mapaClientes.containsKey(agregar.getRut()))
        {
            mapaClientes.put(agregar.getRut(), agregar);
            return true;
        }
        return false;
    }
    
    public boolean quitarCliente(String key)
    {
        if(mapaClientes.containsKey(key))
        {
            mapaClientes.remove(key);
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
            return "Pelicula prestada exitosamente.";
        } else {
            return "No se pudo prestar.";
        }
    }

    
    public void agregarOrdenado(Pelicula nueva) {
        int i = 0;
        while (i < arrayListCatalogo.size() && arrayListCatalogo.get(i).getIdPelicula() < nueva.getIdPelicula()) {
            i++;
        }
        arrayListCatalogo.add(i, nueva);
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
            return "Recepcion exitosa";
        }
        
        return "No se pudo llevar a cabo la recepcion";
    }
    
    public String renovar(int id, String rut)
    {
        if(!mapaClientes.containsKey(rut))
        {
            return "Cliente no existe";
        }else if(busquedaBinariaPeliculas(id) == null)
        {
            return "No se encontro la pelicula";
        }
        Cliente cliente = mapaClientes.get(rut);
        Pelicula p = cliente.buscarPeliculaDelCliente(id);
                if(cliente.renovarPrestamo(p))
        {
            return "Renovacion exitosa" +
                    "\nDias restantes: " + p.getPlazoEntrega();
        }
        return "Renovacion fallida";

    }
    
    public String agregarEmpleado(Encargado e)
    {
        if(!mapaEmpleados.containsKey(e.getIdEmpleado()))
        {
            mapaEmpleados.put(e.getIdEmpleado(), e);
            return "Empleado ingresado con exito";
        }
        return "Ya existe un empleado con ese codigo";

    }
    
    public String quitarEmpleado(String id)
    {
        if(mapaEmpleados.containsKey(id))
        {
            mapaEmpleados.remove(id);
            return ("Empleado eliminado");
        }else return ("Empleado no existe");
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
            encargado.setTurno(turno);
            return ("Turno actualizado");
        }else return ("Empleado no existe");

    }
    
    public String cambioDeSueldo(String id, double sueldo)
    {
        if(mapaEmpleados.containsKey(id))
        {
            Encargado encargado = mapaEmpleados.get(id);

            encargado.setSueldoBase(sueldo);
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
            if (arrayListCatalogo.remove(eliminar))
                return ("Pelicula eliminada exitosamente");
            }                
        return ("No se elimino la pelicula");
        

    }
    
    public String mostrarCatalogoPeliculas()
    {
        String texto = "";
        texto += ("\n_________________________\n");

        for(int i = 0 ; i < arrayListCatalogo.size() ; i++)
        {
            Pelicula act = arrayListCatalogo.get(i);

            texto += ("ID: "+act.getIdPelicula());
            texto += ("Titulo: "+act.getTitulo());
            texto += ("Año: "+act.getEstrenoYear());
            texto += ("Genero: "+act.getGenero());
            texto += ("Copias disponibles: "+act.getCopiasDisponibles());

            texto += ("\n_________________________\n");

        }
        
        return texto;
    }
    
}
