public class Sensor {
    private String id;
    private double ultimaLecturaC;
    private double umbralAlto;
    private double umbralBajo;
    private boolean activo;

    public Sensor() {
        this("", 0.0, 100.0, 0.0, true);
    }

    public Sensor(String id, double ultimaLecturaC, double umbralAlto, double umbralBajo, boolean activo) {
        this.id = id;
        if (umbralBajo < umbralAlto) {
            this.umbralAlto = umbralAlto;
            this.umbralBajo = umbralBajo;
        } else {
            this.umbralAlto = umbralBajo + 1;
            this.umbralBajo = umbralBajo;
        }
        this.ultimaLecturaC = ultimaLecturaC;
        this.activo = activo;
    }

    public void actualizarLectura(double lectura) {
        if (activo) this.ultimaLecturaC = lectura;
    }

    public boolean enAlarma() {
        return ultimaLecturaC < umbralBajo || ultimaLecturaC > umbralAlto;
    }

    public void activar() { activo = true; }
    public void desactivar() { activo = false; }

    @Override
    public String toString() {
        return id + " | " + ultimaLecturaC + "°C | Alarma: " + enAlarma();
    }
}
