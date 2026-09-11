package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import modelo.Cliente;
import modelo.Encargado;
import modelo.Pelicula;
import servicio.SistemaVideoClub;

public class PersistenciaCSV {

    private static final Path CARPETA_DATOS = Paths.get("data");
    private static final Path ARCHIVO_CLIENTES = CARPETA_DATOS.resolve("clientes.csv");
    private static final Path ARCHIVO_PELICULAS = CARPETA_DATOS.resolve("peliculas.csv");
    private static final Path ARCHIVO_EMPLEADOS = CARPETA_DATOS.resolve("empleados.csv");
    private static final Path ARCHIVO_PRESTAMOS = CARPETA_DATOS.resolve("prestamos.csv");

    public static void cargar(SistemaVideoClub sistema) {
        cargarPeliculas(sistema);
        cargarClientes(sistema);
        cargarEmpleados(sistema);
        cargarPrestamos(sistema);
    }

    public static void guardar(SistemaVideoClub sistema) {
        try {
            if (!Files.exists(CARPETA_DATOS)) {
                Files.createDirectories(CARPETA_DATOS);
            }
            guardarPeliculas(sistema.listarPeliculas());
            guardarClientes(sistema.listarClientes());
            guardarEmpleados(sistema.listarEmpleados());
            guardarPrestamos(sistema.listarClientes());
        } catch (IOException e) {
            System.err.println("No se pudieron guardar los datos CSV: " + e.getMessage());
        }
    }

    private static void cargarClientes(SistemaVideoClub sistema) {
        if (!Files.exists(ARCHIVO_CLIENTES)) {
            return;
        }
        try (BufferedReader lector = Files.newBufferedReader(ARCHIVO_CLIENTES, StandardCharsets.UTF_8)) {
            String linea = lector.readLine();
            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                List<String> campos = parsearLinea(linea);
                if (campos.size() < 8) {
                    continue;
                }
                try {
                    String nombre = campos.get(0);
                    String rut = campos.get(1);
                    int edad = Integer.parseInt(campos.get(2).trim());
                    Cliente cliente = new Cliente(nombre, rut, edad);
                    cliente.setCantPedidos(Integer.parseInt(campos.get(3).trim()));
                    cliente.setCantAtrasos(Integer.parseInt(campos.get(4).trim()));
                    cliente.setMultaAcumulada(Double.parseDouble(campos.get(5).trim()));
                    cliente.setMaximoPeliculas(Integer.parseInt(campos.get(6).trim()));
                    cliente.actualizarAptitud();
                    sistema.incorporarCliente(cliente);
                } catch (RuntimeException e) {
                    System.err.println("Fila de cliente omitida: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudieron leer los clientes: " + e.getMessage());
        }
    }

    private static void cargarPeliculas(SistemaVideoClub sistema) {
        if (!Files.exists(ARCHIVO_PELICULAS)) {
            return;
        }
        try (BufferedReader lector = Files.newBufferedReader(ARCHIVO_PELICULAS, StandardCharsets.UTF_8)) {
            String linea = lector.readLine();
            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                List<String> campos = parsearLinea(linea);
                if (campos.size() < 9) {
                    continue;
                }
                try {
                    int id = Integer.parseInt(campos.get(0).trim());
                    String titulo = campos.get(1);
                    String autor = campos.get(2);
                    String genero = campos.get(3);
                    int anio = Integer.parseInt(campos.get(4).trim());
                    int copias = Integer.parseInt(campos.get(5).trim());
                    boolean mayor18 = Boolean.parseBoolean(campos.get(6).trim());
                    Pelicula pelicula = new Pelicula(titulo, autor, genero, anio, id, copias, mayor18);
                    pelicula.setCantPrestamos(Integer.parseInt(campos.get(7).trim()));
                    pelicula.setPlazoEntrega(Integer.parseInt(campos.get(8).trim()));
                    sistema.incorporarPelicula(pelicula);
                } catch (RuntimeException e) {
                    System.err.println("Fila de pelicula omitida: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudieron leer las peliculas: " + e.getMessage());
        }
    }

    private static void cargarEmpleados(SistemaVideoClub sistema) {
        if (!Files.exists(ARCHIVO_EMPLEADOS)) {
            return;
        }
        try (BufferedReader lector = Files.newBufferedReader(ARCHIVO_EMPLEADOS, StandardCharsets.UTF_8)) {
            String linea = lector.readLine();
            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                List<String> campos = parsearLinea(linea);
                if (campos.size() < 5) {
                    continue;
                }
                try {
                    String nombre = campos.get(0);
                    String rut = campos.get(1);
                    String idEmpleado = campos.get(2);
                    double sueldo = Double.parseDouble(campos.get(3).trim());
                    String turno = campos.get(4);
                    Encargado empleado = new Encargado(nombre, rut, sueldo, idEmpleado, turno);
                    sistema.incorporarEmpleado(empleado);
                } catch (RuntimeException e) {
                    System.err.println("Fila de empleado omitida: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudieron leer los empleados: " + e.getMessage());
        }
    }

    private static void cargarPrestamos(SistemaVideoClub sistema) {
        if (!Files.exists(ARCHIVO_PRESTAMOS)) {
            return;
        }
        try (BufferedReader lector = Files.newBufferedReader(ARCHIVO_PRESTAMOS, StandardCharsets.UTF_8)) {
            String linea = lector.readLine();
            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                List<String> campos = parsearLinea(linea);
                if (campos.size() < 2) {
                    continue;
                }
                try {
                    String rut = campos.get(0);
                    int idPelicula = Integer.parseInt(campos.get(1).trim());
                    sistema.incorporarPrestamo(rut, idPelicula);
                } catch (RuntimeException e) {
                    System.err.println("Fila de prestamo omitida: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudieron leer los prestamos: " + e.getMessage());
        }
    }

    private static void guardarClientes(Collection<Cliente> clientes) throws IOException {
        try (BufferedWriter escritor = Files.newBufferedWriter(ARCHIVO_CLIENTES, StandardCharsets.UTF_8)) {
            escritor.write("nombre,rut,edad,cantPedidos,cantAtrasos,multaAcumulada,maximoPeliculas,aptoPrestamos");
            escritor.newLine();
            for (Cliente cliente : clientes) {
                escritor.write(escapar(cliente.getNombre()));
                escritor.write(",");
                escritor.write(escapar(cliente.getRut()));
                escritor.write(",");
                escritor.write(Integer.toString(cliente.getEdad()));
                escritor.write(",");
                escritor.write(Integer.toString(cliente.getCantPedidos()));
                escritor.write(",");
                escritor.write(Integer.toString(cliente.getCantAtrasos()));
                escritor.write(",");
                escritor.write(Double.toString(cliente.getMultaAcumulada()));
                escritor.write(",");
                escritor.write(Integer.toString(cliente.getMaximoPeliculas()));
                escritor.write(",");
                escritor.write(Boolean.toString(cliente.isAptoPrestamos()));
                escritor.newLine();
            }
        }
    }

    private static void guardarPeliculas(List<Pelicula> peliculas) throws IOException {
        try (BufferedWriter escritor = Files.newBufferedWriter(ARCHIVO_PELICULAS, StandardCharsets.UTF_8)) {
            escritor.write("idPelicula,titulo,autor,genero,estrenoYear,copiasDisponibles,mayor18,cantPrestamos,plazoEntrega");
            escritor.newLine();
            for (Pelicula pelicula : peliculas) {
                escritor.write(Integer.toString(pelicula.getIdPelicula()));
                escritor.write(",");
                escritor.write(escapar(pelicula.getTitulo()));
                escritor.write(",");
                escritor.write(escapar(pelicula.getAutor()));
                escritor.write(",");
                escritor.write(escapar(pelicula.getGenero()));
                escritor.write(",");
                escritor.write(Integer.toString(pelicula.getEstrenoYear()));
                escritor.write(",");
                escritor.write(Integer.toString(pelicula.getCopiasDisponibles()));
                escritor.write(",");
                escritor.write(Boolean.toString(pelicula.isMayor18()));
                escritor.write(",");
                escritor.write(Integer.toString(pelicula.getCantPrestamos()));
                escritor.write(",");
                escritor.write(Integer.toString(pelicula.getPlazoEntrega()));
                escritor.newLine();
            }
        }
    }

    private static void guardarEmpleados(Collection<Encargado> empleados) throws IOException {
        try (BufferedWriter escritor = Files.newBufferedWriter(ARCHIVO_EMPLEADOS, StandardCharsets.UTF_8)) {
            escritor.write("nombre,rut,idEmpleado,sueldoBase,turno");
            escritor.newLine();
            for (Encargado empleado : empleados) {
                escritor.write(escapar(empleado.getNombre()));
                escritor.write(",");
                escritor.write(escapar(empleado.getRut()));
                escritor.write(",");
                escritor.write(escapar(empleado.getIdEmpleado()));
                escritor.write(",");
                escritor.write(Double.toString(empleado.getSueldoBase()));
                escritor.write(",");
                escritor.write(escapar(empleado.getTurno()));
                escritor.newLine();
            }
        }
    }

    private static void guardarPrestamos(Collection<Cliente> clientes) throws IOException {
        try (BufferedWriter escritor = Files.newBufferedWriter(ARCHIVO_PRESTAMOS, StandardCharsets.UTF_8)) {
            escritor.write("rut,idPelicula");
            escritor.newLine();
            for (Cliente cliente : clientes) {
                for (Pelicula pelicula : cliente.getPeliculasEnPosesion()) {
                    escritor.write(escapar(cliente.getRut()));
                    escritor.write(",");
                    escritor.write(Integer.toString(pelicula.getIdPelicula()));
                    escritor.newLine();
                }
            }
        }
    }

    static List<String> parsearLinea(String linea) {
        List<String> campos = new ArrayList<String>();
        StringBuilder actual = new StringBuilder();
        boolean entreComillas = false;

        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (entreComillas) {
                if (c == '"') {
                    if (i + 1 < linea.length() && linea.charAt(i + 1) == '"') {
                        actual.append('"');
                        i++;
                    } else {
                        entreComillas = false;
                    }
                } else {
                    actual.append(c);
                }
            } else if (c == '"') {
                entreComillas = true;
            } else if (c == ',') {
                campos.add(actual.toString());
                actual.setLength(0);
            } else {
                actual.append(c);
            }
        }
        campos.add(actual.toString());
        return campos;
    }

    static String escapar(String valor) {
        if (valor == null) {
            return "";
        }
        boolean necesitaComillas = valor.indexOf(',') >= 0
                || valor.indexOf('"') >= 0
                || valor.indexOf('\n') >= 0
                || valor.indexOf('\r') >= 0;
        if (necesitaComillas) {
            return "\"" + valor.replace("\"", "\"\"") + "\"";
        }
        return valor;
    }
}
