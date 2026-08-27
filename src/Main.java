import java.io.*;
import java.util.*;

public class Main
{
    public static void main (String arr[]) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Pelicula> arrayListCatalogo = new ArrayList<>();
        HashMap<String,Cliente> mapaClientes = new HashMap<>();
        HashMap<String,Encargado> mapaEmpleados = new HashMap<>();
        int opcion;

        do
        {

            System.out.println("0 - Salir");
            System.out.println("1 - Menu peliculas");
            System.out.println("2 - Menu clientes");
            System.out.println("3 - Menu empleados");
            System.out.printf("Ingrese la opcion a elegir: ");

            opcion = getInt(lector);

            switch(opcion){
                case 1:
                    menuPelicula(lector, arrayListCatalogo);
                    break;
                case 2:
                    menuCliente(lector, mapaClientes);
                    break;
                case 3:
                    menuEmpleado(lector, mapaEmpleados);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while(opcion != 0);

    }

    public static void menuCliente (BufferedReader lector, HashMap<String,Cliente> mapaClientes) throws IOException {
        /* 
        AGREGAR
        QUITAR
        MOSTRAR
         */

        int opcion;

        do
        {

            System.out.println("0 - Salir");
            System.out.println("1 - Agregar cliente");
            System.out.println("2 - Quitar cliente");
            System.out.println("3 - Mostrar cliente");
            System.out.println("4 - Acciones cliente");
            System.out.printf("Ingrese la opcion a elegir: ");

            opcion = getInt(lector);


            switch(opcion){

                case 1:
                    String nombre, rut;
                    int edad;

                    System.out.printf("Ingrese nombre: ");
                    nombre = lector.readLine();

                    System.out.printf("Ingrese rut: ");
                    rut = lector.readLine();

                    System.out.printf("Ingrese edad: ");
                    edad = getInt(lector);

                    Cliente nuevoCliente = new Cliente(nombre, rut, edad);
                    mapaClientes.put(rut, nuevoCliente);

                    break;

                case 2:

                    System.out.printf("Ingrese rut: ");
                    rut = lector.readLine();

                    if(mapaClientes.containsKey(rut))
                    {
                        mapaClientes.remove(rut);
                        System.out.println("Cliente eliminado");
                        
                    }else System.out.println("Cliente no existe");
                    break;

                case 3:

                    System.out.printf("Ingrese rut: ");
                    rut = lector.readLine();

                    if(mapaClientes.containsKey(rut))
                    {
                        Cliente mostrar = mapaClientes.get(rut);

                        mostrar.identificarse();

                        
                    }else System.out.println("Cliente no existe");
                    break;
                
                case 4:

                    accionesCliente(lector, mapaClientes);
                    
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        }while(opcion != 0);
        
    }

    public static void accionesCliente(BufferedReader lector, HashMap<String,Cliente> mapaClientes) throws IOException
    {
        int opcion;

        do
        {
            System.out.println("0 - Salir");
            System.out.println("1 - Prestar pelicula");
            System.out.println("2 - Recibir pelicula");
            System.out.println("3 - ");
            System.out.printf("Ingrese la opcion a elegir: ");

            opcion = getInt(lector);

            switch(opcion){
                case 1:

                    System.out.println("Aun no implementado");

                    // pedirPelicula();
                    break;
                case 2:
                    System.out.println("Aun no implementado");
                    break;
                case 3:
                    System.out.println("Aun no implementado");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while(opcion != 0);

    }

    public static void menuEmpleado(BufferedReader lector, HashMap<String,Encargado> mapaEmpleados) throws IOException {
        int opcion;

        do
        {
            System.out.println("0 - Salir");
            System.out.println("1 - Agregar empleado");
            System.out.println("2 - Quitar empleado");
            System.out.println("3 - Mostrar empleado");
            System.out.println("4 - Acciones empleado");
            System.out.printf("Ingrese la opcion a elegir: ");

            opcion = getInt(lector);

            switch(opcion){
                case 1:
                    String nombre, rut, idEmpleado, turno;
                    double sueldoBase;

                    System.out.printf("Ingrese nombre: ");
                    nombre = lector.readLine();

                    System.out.printf("Ingrese rut: ");
                    rut = lector.readLine();

                    if(mapaEmpleados.containsKey(rut))
                    {
                        System.out.println("Ya existe un empleado con ese rut");
                        break;
                    }

                    System.out.printf("Ingrese id de empleado: ");
                    idEmpleado = lector.readLine();

                    if(buscarEmpleadoPorId(mapaEmpleados, idEmpleado) != null)
                    {
                        System.out.println("Ya existe un empleado con ese id");
                        break;
                    }

                    System.out.printf("Ingrese turno: ");
                    turno = lector.readLine();

                    System.out.printf("Ingrese sueldo base: ");
                    sueldoBase = getDouble(lector);

                    Encargado nuevoEmpleado = new Encargado(nombre, rut, sueldoBase, idEmpleado, turno);
                    mapaEmpleados.put(rut, nuevoEmpleado);
                    System.out.println("Empleado agregado");
                    break;

                case 2:
                    System.out.printf("Ingrese rut: ");
                    rut = lector.readLine();

                    if(mapaEmpleados.containsKey(rut))
                    {
                        mapaEmpleados.remove(rut);
                        System.out.println("Empleado eliminado");
                    }else System.out.println("Empleado no existe");
                    break;

                case 3:
                    System.out.printf("Ingrese rut: ");
                    rut = lector.readLine();

                    if(mapaEmpleados.containsKey(rut))
                    {
                        Encargado mostrar = mapaEmpleados.get(rut);
                        mostrar.identificarse();
                    }else System.out.println("Empleado no existe");
                    break;

                case 4:
                    accionesEmpleado(lector, mapaEmpleados);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        }while(opcion != 0);
    }

    public static void accionesEmpleado(BufferedReader lector, HashMap<String,Encargado> mapaEmpleados) throws IOException
    {
        int opcion;

        do
        {
            System.out.println("0 - Salir");
            System.out.println("1 - Cambiar turno");
            System.out.println("2 - Cambiar sueldo");
            System.out.println("3 - Mostrar todos los empleados");
            System.out.printf("Ingrese la opcion a elegir: ");

            opcion = getInt(lector);

            switch(opcion){
                case 1:
                    System.out.printf("Ingrese rut: ");
                    String rut = lector.readLine();

                    if(mapaEmpleados.containsKey(rut))
                    {
                        Encargado encargado = mapaEmpleados.get(rut);
                        System.out.printf("Ingrese nuevo turno: ");
                        String turno = lector.readLine();
                        encargado.setTurno(turno);
                        System.out.println("Turno actualizado");
                    }else System.out.println("Empleado no existe");
                    break;

                case 2:
                    System.out.printf("Ingrese rut: ");
                    rut = lector.readLine();

                    if(mapaEmpleados.containsKey(rut))
                    {
                        Encargado encargado = mapaEmpleados.get(rut);
                        System.out.printf("Ingrese nuevo sueldo: ");
                        double sueldo = getDouble(lector);
                        encargado.setSueldoBase(sueldo);
                        System.out.println("Sueldo actualizado");
                    }else System.out.println("Empleado no existe");
                    break;

                case 3:
                    if(mapaEmpleados.isEmpty())
                    {
                        System.out.println("No hay empleados registrados");
                    }
                    else
                    {
                        System.out.println("\n_________________________\n");
                        for(Encargado encargado : mapaEmpleados.values())
                        {
                            encargado.identificarse();
                            System.out.println("_________________________\n");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }while(opcion != 0);
    }

    public static Encargado buscarEmpleadoPorId(HashMap<String,Encargado> mapaEmpleados, String idEmpleado) {
        for(Encargado encargado : mapaEmpleados.values())
        {
            if(encargado.getIdEmpleado().equals(idEmpleado))
                return encargado;
        }
        return null;
    }

    public static void menuPelicula (BufferedReader lector, ArrayList<Pelicula> catalogo) throws IOException {

        int opcion;

        do
        {
            System.out.println("0 - Salir");
            System.out.println("1 - Agregar pelicula");
            System.out.println("2 - Quitar pelicula");
            System.out.println("3 - Mostrar catalogo");
            System.out.printf("Ingrese la opcion a elegir: ");

            opcion = getInt(lector);

            if(opcion == 1)
            {
                String titulo, autor, genero;
                int estrenoYear, idPelicula, copiasDisponibles;

                System.out.printf("Ingrese titulo: ");
                titulo = lector.readLine();

                System.out.printf("Ingrese autor: ");
                autor = lector.readLine();

                System.out.printf("Ingrese genero: ");
                genero = lector.readLine();

                System.out.printf("Ingrese año de publicacion: ");
                estrenoYear = getInt(lector);

                System.out.printf("Ingrese id: ");
                idPelicula = getInt(lector);
                
                System.out.printf("Ingrese cantidad de copias en stock: ");
                copiasDisponibles = getInt(lector);

                Pelicula nuevaPelicula = new Pelicula(titulo, autor, genero, estrenoYear, idPelicula, copiasDisponibles);
                agregarOrdenado(catalogo, nuevaPelicula);

            }
            else if(opcion == 2)
            {
                int idPelicula, confirmacion;

                System.out.printf("Ingrese id de la pelicula a eliminar: ");
                idPelicula = getInt(lector);

                Pelicula eliminar = busquedaBinariaPeliculas(catalogo,idPelicula);


                if(eliminar != null)
                {
                    System.out.println("Titulo de la pelicula: "+eliminar.getTitulo());
                    System.out.println("Desea continuar?");
                    System.out.println("1 - Si\n2 - No");
                    System.out.printf("Elija: ");
                    confirmacion = getInt(lector);

                    if(confirmacion == 1)
                    {
                        if (catalogo.remove(eliminar))
                            System.out.println("Pelicula eliminada exitosamente");
                    }else{
                        System.out.println("Saliendo...");
                    }
                }
            }
            else if(opcion == 3)
            {

                System.out.println("\n_________________________\n");

                for(int i = 0 ; i < catalogo.size() ; i++)
                {
                    Pelicula act = catalogo.get(i);
                    
                    System.out.println("ID: "+act.getIdPelicula());
                    System.out.println("Titulo: "+act.getTitulo());
                    System.out.println("Año: "+act.getEstrenoYear());
                    System.out.println("Genero: "+act.getGenero());
                    System.out.println("Copias disponibles: "+act.getCopiasDisponibles());

                    System.out.println("\n_________________________\n");

                }
            }
            
            else if(opcion != 0)
                System.out.println("Opcion invalida");
        

        }while(opcion != 0);
        
    }


    public static double getDouble(BufferedReader lector) throws IOException {
        while (true) {
            String entrada = lector.readLine();
            if (entrada == null) {
                return 0;
            }
            try {
                return Double.parseDouble(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.printf("Debe ingresar un numero. Intente de nuevo: ");
            }
        }
    }


    public static int getInt(BufferedReader lector) throws IOException {
        while (true) {
            String entrada = lector.readLine();
            if (entrada == null) {
                return 0;
            }
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.printf("Debe ingresar un numero entero. Intente de nuevo: ");
            }
        }
    }


    public static void agregarOrdenado(ArrayList<Pelicula> catalogo, Pelicula nueva) {
        int i = 0;
        while (i < catalogo.size() && catalogo.get(i).getIdPelicula() < nueva.getIdPelicula()) {
            i++;
        }
        catalogo.add(i, nueva);
    }

    public static Pelicula busquedaBinariaPeliculas(ArrayList<Pelicula> catalogo, int idBuscada) {
        int p = 0, u = catalogo.size()-1, i;
        Pelicula enc = null;
        
        while ((p<=u)&&(enc == null)) {
            i=(p+u)/2;
            int idActual = catalogo.get(i).getIdPelicula();
            if (idActual == idBuscada) enc = catalogo.get(i);
            else {
                if (idActual > idBuscada) u = i-1;
                else p = i+1;
            }
        }
        return enc;
    }

        

}
