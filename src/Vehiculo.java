public class Vehiculo {
    private String placa;
    private String marca;
    private double capacidadTanqueLitros;
    private double combustibleActual;
    private double kmPorLitro;

    public Vehiculo() {
        this("", "", 1.0, 0.0, 1.0);
    }

    public Vehiculo(String placa, String marca, double capacidadTanqueLitros, double combustibleActual, double kmPorLitro) {
        this.placa = placa;
        this.marca = marca;
        this.capacidadTanqueLitros = Math.max(0.01, capacidadTanqueLitros);
        this.combustibleActual = Math.max(0.0, Math.min(combustibleActual, capacidadTanqueLitros));
        this.kmPorLitro = Math.max(0.01, kmPorLitro);
    }

    public boolean recargar(double litros) {
        if (litros > 0 && combustibleActual + litros <= capacidadTanqueLitros) {
            combustibleActual += litros;
            return true;
        }
        return false;
    }

    public boolean conducir(double km) {
        double necesario = km / kmPorLitro;
        if (km > 0 && combustibleActual >= necesario) {
            combustibleActual -= necesario;
            return true;
        }
        return false;
    }

    public double autonomia() { return Math.round(combustibleActual * kmPorLitro * 10.0) / 10.0; }

    @Override
    public String toString() {
        return placa + " | Autonomía: " + autonomia() + " km";
    }
}
