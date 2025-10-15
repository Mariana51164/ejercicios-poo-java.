import java.util.HashMap;
import java.util.Map;

public class Pelicula {
    private String titulo;
    private int anio;
    private String clasificacion;
    private int copias;
    private int alquiladas;

    private static final Map<String, Integer> minEdad = new HashMap<>();
    static {
        minEdad.put("G", 0);
        minEdad.put("PG13", 13);
        minEdad.put("R", 17);
    }

    public Pelicula() {
        this("", 1900, "G", 0, 0);
    }

    public Pelicula(String titulo, int anio, String clasificacion, int copias, int alquiladas) {
        this.titulo = titulo;
        this.anio = Math.max(anio, 1900);
        this.clasificacion = clasificacion;
        this.copias = Math.max(0, copias);
        this.alquiladas = Math.max(0, alquiladas);
        if (this.alquiladas > this.copias) this.alquiladas = this.copias;
    }

    public boolean alquilar(int edadCliente) {
        int edadMin = minEdad.getOrDefault(clasificacion, 0);
        if (edadCliente >= edadMin && copias - alquiladas > 0) {
            alquiladas++;
            return true;
        }
        return false;
    }

    public boolean devolver() {
        if (alquiladas > 0) {
            alquiladas--;
            return true;
        }
        return false;
    }

    public int disponibles() { return copias - alquiladas; }

    @Override
    public String toString() {
        return titulo + " (" + clasificacion + ") | disp: " + disponibles() + "/" + copias;
    }
}
