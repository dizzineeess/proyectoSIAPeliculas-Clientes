import vista.consola.MenuConsola;
import servicio.SistemaVideoClub;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import vista.ventana.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        SistemaVideoClub sistema = new SistemaVideoClub();

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

                        JFrame marco = new JFrame("Sistema Video Club");
                        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        VentanaPrincipal panelMenu = new VentanaPrincipal(sistema);

                        marco.add(panelMenu);

                        marco.pack();
                        marco.setLocationRelativeTo(null); 
                        marco.setVisible(true); 
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