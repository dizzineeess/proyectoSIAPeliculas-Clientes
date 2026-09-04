public class Pelicula {
    
    private String titulo;
    private String autor;
    private String genero;
    private int estrenoYear;
    private int idPelicula;
    private int cantPrestamos;
    private int copiasDisponibles; //funciona como validador de si se puede prestar la pelicula, no importa si la pelicula esta atrasada (en todo, eso importaria del cliente)

    public Pelicula() {
        titulo = "";
        autor = "";
        genero = "";
        estrenoYear = 0;
        idPelicula = 0;
        cantPrestamos = 0;
        copiasDisponibles = 0;
    }

    public Pelicula(String titulo, String autor, String genero, int estrenoYear, int idPelicula, int copiasDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.estrenoYear = estrenoYear;
        this.idPelicula = idPelicula;
        cantPrestamos = 0;
        this.copiasDisponibles = copiasDisponibles;
    }

    public boolean prestar() {
        if (copiasDisponibles > 0) {
            copiasDisponibles --;
            cantPrestamos++;
            return true;

        } else {
            return false;

        }
    }
    public void devolver() {
        copiasDisponibles ++;
    }


    
    
    //getter y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEstrenoYear() {
        return estrenoYear;
    }

    public void setEstrenoYear(int estrenoYear) {
        this.estrenoYear = estrenoYear;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getCantPrestamos() {
        return cantPrestamos;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

}