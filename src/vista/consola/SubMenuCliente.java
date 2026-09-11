package vista.consola;

import java.io.BufferedReader;
import java.io.IOException;
import modelo.Cliente;
import servicio.SistemaVideoClub;
import util.LecturaDatos;

public class SubMenuCliente {

    public static void menuCliente (SistemaVideoClub sistema, BufferedReader lector) throws IOException {
        
            int opcion;
            

            do
            {

                System.out.println("0 - Salir");
                System.out.println("1 - Agregar cliente");
                System.out.println("2 - Quitar cliente");
                System.out.println("3 - Mostrar cliente");
                System.out.println("4 - Acciones cliente");
                System.out.printf("Ingrese la opcion a elegir: ");

                opcion = LecturaDatos.getInt(lector);


                switch(opcion){

                    case 1:
                        String nombre, rut;
                        int edad;

                        System.out.printf("Ingrese nombre: ");
                        nombre = lector.readLine();

                        System.out.printf("Ingrese rut: ");
                        rut = LecturaDatos.leerRut(lector);

                        System.out.printf("Ingrese edad: ");
                        edad = LecturaDatos.getInt(lector);

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
                        rut = LecturaDatos.leerRut(lector);

                        if(sistema.quitarCliente(rut))
                        {
                            System.out.println("Cliente quitado con exito");
                        }else System.out.println("Cliente no existe");
                        break;

                    case 3:

                        System.out.printf("Ingrese rut: ");
                        rut = LecturaDatos.leerRut(lector);

                        System.out.println(sistema.mostrarCliente(rut));
                        
                        break;

                    case 4:

                        accionesCliente(sistema, lector);

                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }

            }while(opcion != 0);
        
    }

    public static void accionesCliente(SistemaVideoClub sistema, BufferedReader lector) throws IOException
    {
        int opcion;
        String rut;
        
        do{
            System.out.printf("Ingrese RUT del cliente (o digite '0' para cancelar): ");
            rut = LecturaDatos.leerRut(lector);
    
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

            opcion = LecturaDatos.getInt(lector);

            switch(opcion){
                case 1:

                    System.out.printf("Ingrese id de la pelicula a pedir: ");
                    int id = LecturaDatos.getInt(lector);
                    
                    System.out.println(sistema.prestar(id, rut));
                    break;


                case 2:

                        System.out.printf ("Ingrese id de la pelicula a devolver: ");
                        id = LecturaDatos.getInt(lector);

                       System.out.println(sistema.recibirPeliculaPrestada(id,rut));
                        
                    break;


                case 3:

                    System.out.printf ("Ingrese monto pagado por el cliente: ");
                    double monto = LecturaDatos.getDouble(lector);
                    
                    System.out.println(sistema.recibirPago(monto, rut));
                    break;


                case 4:

                        System.out.println("Ingrese id de la pelicula a renovar: ");
                        id = LecturaDatos.getInt(lector);
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

}
