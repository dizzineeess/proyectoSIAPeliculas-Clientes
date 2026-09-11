package vista.consola;

import servicio.SistemaVideoClub;
import java.io.*;
import util.LecturaDatos;

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
                System.out.println("\n=================================");
                System.out.println("   SISTEMA VIDEO CLUB (CONSOLA)  ");
                System.out.println("=================================");
                System.out.println("0 - Salir");
                System.out.println("1 - Menu peliculas");
                System.out.println("2 - Menu clientes");
                System.out.println("3 - Menu empleados");
                System.out.printf("Ingrese la opcion a elegir: ");

                opcion = LecturaDatos.getInt(lector);

                switch(opcion){
                    case 1:
                        
                        SubMenuPelicula.menuPelicula(sistema, lector);
                        break;
                    case 2:
                        SubMenuCliente.menuCliente(sistema, lector);
                        break;
                    case 3:
                        SubMenuEmpleado.menuEmpleado(sistema, lector);
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
    
}
