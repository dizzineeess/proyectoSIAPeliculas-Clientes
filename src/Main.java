import vista.consola.MenuConsola;
import servicio.SistemaVideoClub;
import java.io.*;
import javax.swing.SwingUtilities;
import vista.ventana.VentanaMenu;

public class Main {

    public static void main(String[] args) {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        SistemaVideoClub sistema = new SistemaVideoClub();
        System.out.println("Datos cargados desde la carpeta data/");

        try {
            int opcion;
            System.out.println("1- Menu Consola\n2- Menu Ventana");
            System.out.print("Ingrese la opcion a elegir: ");
            
            // Usamos Integer.parseInt con un trim() para evitar errores si ingresan espacios
            opcion = Integer.parseInt(lector.readLine().trim());

            switch (opcion) {
                case 1:
                    MenuConsola consola = new MenuConsola(sistema);
                    consola.arrancar();
                    break;

                case 2:
                    SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        VentanaMenu menu = new VentanaMenu(sistema);
                        menu.setLocationRelativeTo(null);
                        menu.setVisible(true);
                    }
                });
            break;
                default:
                    System.out.println("Opción no válida. Fin del programa.");
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un numero entero valido.");
        } catch (IOException e) {
            System.out.println("Ocurrio un problema al leer el teclado: " + e.getMessage());
        }
    }
}