import java.io.*;

public class MenuConsola {
    SistemaVideoClub sistema;
    private BufferedReader lector;

    
    public MenuConsola(SistemaVideoClub sistema) {
        this.sistema = sistema;
        this.lector = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void arrancar () {
        try{
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
                        menuPelicula(sistema);
                        break;
                    case 2:
                        menuCliente(sistema);
                        break;
                    case 3:
                        menuEmpleado(sistema);
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            }while(opcion != 0);
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }

    }

    public void menuCliente (SistemaVideoClub sistema) throws IOException {
        
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
                        
                        if (sistema.agregarCliente(nuevoCliente))
                        {
                            System.out.println("Cliente agregado con exito");
                        }else  {
                            System.out.println("El cliente ya existe");
                        }

                        break;

                    case 2:

                        System.out.printf("Ingrese rut: ");
                        rut = lector.readLine();

                        if(sistema.quitarCliente(rut))
                        {
                            System.out.println("Cliente quitado con exito");
                        }else System.out.println("Cliente no existe");
                        break;

                    case 3:

                        System.out.printf("Ingrese rut: ");
                        rut = lector.readLine();

                        System.out.println(sistema.mostrarCliente(rut));
                        
                        break;

                    case 4:

                        accionesCliente(sistema);

                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }

            }while(opcion != 0);
        
    }

    public void accionesCliente(SistemaVideoClub sistema) throws IOException
    {
        int opcion;
        String rut;
        
        do{
            System.out.printf("Ingrese RUT del cliente (o digite '0' para cancelar): ");
            rut = lector.readLine();
    
            if (rut.equals("0")) {
                System.out.println("Operación cancelada por el usuario.");
                return; 
            }
        }while(sistema.obtenerCliente(rut) == null);
        
        
        do
        {
            System.out.println("Rut cliente actual: "+ rut + "\n");

            System.out.println("0 - Salir");
            System.out.println("1 - Pedir pelicula");
            System.out.println("2 - Devolver pelicula");
            System.out.println("3 - Pagar multa");
            System.out.println("4 - Renovar prestamo");
            System.out.printf("Ingrese la opcion a elegir: ");

            opcion = getInt(lector);

            switch(opcion){
                case 1:

                    System.out.printf("Ingrese id de la pelicula a pedir: ");
                    int id = getInt(lector);
                    
                    System.out.println(sistema.prestar(id, rut));
                    break;


                case 2:

                        System.out.printf ("Ingrese id de la pelicula a devolver: ");
                        id = getInt(lector);

                       System.out.println(sistema.recibirPeliculaPrestada(id,rut));
                        
                    break;


                case 3:

                    System.out.printf ("Ingrese monto pagado por el cliente: ");
                    double monto = getDouble(lector);
                    
                    System.out.println(sistema.recibirPago(monto, rut));
                    break;


                case 4:

                        System.out.println("Ingrese id de la pelicula a renovar: ");
                        id = getInt(lector);
                        System.out.println(sistema.renovar(id,rut));
                        
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while(opcion != 0);


        
    }

    public void menuEmpleado(SistemaVideoClub sistema) throws IOException {
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

                    System.out.printf("Ingrese id de empleado: ");
                    idEmpleado = lector.readLine();

                    System.out.printf("Ingrese turno: ");
                    turno = lector.readLine();

                    System.out.printf("Ingrese sueldo base: ");
                    sueldoBase = getDouble(lector);

                    Encargado nuevoEmpleado = new Encargado(nombre, rut, sueldoBase, idEmpleado, turno);
                    
                    System.out.println(sistema.agregarEmpleado(nuevoEmpleado));
                    break;

                case 2:
                    System.out.printf("Ingrese id de empleado: ");
                    idEmpleado = lector.readLine();

                    System.out.println(sistema.quitarEmpleado(idEmpleado));
                    break;

                case 3:
                    System.out.printf("Ingrese id de empleado: ");
                    idEmpleado = lector.readLine();

                    System.out.println(sistema.mostrarEmpleado(idEmpleado));
                    break;

                case 4:
                    accionesEmpleado(sistema);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        }while(opcion != 0);
    }

    public void accionesEmpleado(SistemaVideoClub sistema) throws IOException
    {
        int opcion;
        String idEmpleado;
        do{
            System.out.printf("Ingrese ID de empleado (o digite '0' para cancelar): ");
            idEmpleado = lector.readLine();
    
            if (idEmpleado.equals("0")) {
                System.out.println("Operación cancelada por el usuario.");
                return; 
            }
        }while(sistema.obtenerEmpleado(idEmpleado) == null);
        

        do
        {
            System.out.println("ID empleado actual: "+ idEmpleado + "\n");

            System.out.println("0 - Salir");
            System.out.println("1 - Cambiar turno");
            System.out.println("2 - Cambiar sueldo");
            System.out.printf("Ingrese la opcion a elegir: ");

            opcion = getInt(lector);

            switch(opcion){
                case 1:
                    
                    System.out.printf("Ingrese nuevo turno: ");
                    String turno = lector.readLine();
                    sistema.cambioDeTurno(idEmpleado, turno);
                    break;

                case 2:

                    System.out.printf("Ingrese nuevo sueldo: ");
                    double sueldo = getDouble(lector);
                    sistema.cambioDeSueldo(idEmpleado, sueldo);
                    break;
                    
                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }while(opcion != 0);
    }
    
    public void menuPelicula (SistemaVideoClub sistema) throws IOException {

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
                sistema.agregarOrdenado(nuevaPelicula);

            }
            else if(opcion == 2)
            {
                int idPelicula;

                System.out.printf("Ingrese id de la pelicula a eliminar: ");
                idPelicula = getInt(lector);
                
                System.out.println(sistema.eliminarPelicula(idPelicula));

            }
            else if(opcion == 3)
            {
                System.out.println(sistema.mostrarCatalogoPeliculas());
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



}
