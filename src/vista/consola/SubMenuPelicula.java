package vista.consola;

import java.io.BufferedReader;
import java.io.IOException;
import modelo.Pelicula;
import servicio.SistemaVideoClub;
import util.LecturaDatos;


public class SubMenuPelicula {
    
    public static void menuPelicula (SistemaVideoClub sistema, BufferedReader lector) throws IOException {

        int opcion;

        do
        {
            System.out.println("0 - Salir");
            System.out.println("1 - Agregar pelicula");
            System.out.println("2 - Quitar pelicula");
            System.out.println("3 - Mostrar catalogo");
            System.out.printf("Ingrese la opcion a elegir: ");

            opcion = LecturaDatos.getInt(lector);

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
                estrenoYear = LecturaDatos.getInt(lector);

                System.out.printf("Ingrese id: ");
                idPelicula = LecturaDatos.getInt(lector);
                
                System.out.printf("Ingrese cantidad de copias en stock: ");
                copiasDisponibles = LecturaDatos.getInt(lector);
                
                System.out.println("La pelicula tiene restriccion de edad?");
                System.out.println("1- Si\n2- No");
                System.out.printf("Ingrese respuesta: ");
                int respuesta = util.LecturaDatos.getInt(lector);
                
                Pelicula nuevaPelicula;
                if(respuesta == 1){
                    nuevaPelicula = new Pelicula(titulo, autor, genero, estrenoYear, idPelicula, copiasDisponibles, true);
                }else{
                    nuevaPelicula = new Pelicula(titulo, autor, genero, estrenoYear, idPelicula, copiasDisponibles, false);
                }
                sistema.agregarOrdenado(nuevaPelicula);

            }
            else if(opcion == 2)
            {
                int idPelicula;

                System.out.printf("Ingrese id de la pelicula a eliminar: ");
                idPelicula = LecturaDatos.getInt(lector);
                
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


}
