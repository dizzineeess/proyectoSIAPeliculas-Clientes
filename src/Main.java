import java.io.*;
import java.util.*;
import javax.swing.SwingUtilities;

public class Main
{
    public static void main (String arr[]){
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Pelicula> arrayListCatalogo = new ArrayList<>();
        HashMap<String,Cliente> mapaClientes = new HashMap<>();
        HashMap<String,Encargado> mapaEmpleados = new HashMap<>();
        
        try{
            
            int opcion; 
            System.out.println("1- Menu Consola\n2- Menu Ventana");
            System.out.printf("Ingrese la opcion a elegir: ");
            opcion = Integer.parseInt(lector.readLine());
            
            
            switch(opcion){
                case 1:
                    MenuConsola consola = new MenuConsola(arrayListCatalogo, mapaClientes, mapaEmpleados);
                    consola.arrancar();
                    break;
                
                case 2:
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new MenuVentana().setVisible(true);
                        }
                    });
                    break;

                default:
                    System.out.println("fin");
                    break;
            }
            
        } catch (IOException e) {
            System.out.println("Ocurrió un problema al leer el teclado: " + e.getMessage());
            System.out.println("Por favor, intente abrir el menú nuevamente.");
        }

    }
}