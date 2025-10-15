import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReservaHotel {
    private String huesped;
    private LocalDate ingreso;
    private LocalDate salida;
    private double tarifaNoche;
    private boolean confirmada;

    public ReservaHotel() {
        this("", LocalDate.now(), LocalDate.now().plusDays(1), 0.0, false);
    }

    public ReservaHotel(String huesped, LocalDate ingreso, LocalDate salida, double tarifaNoche, boolean confirmada) {
        this.huesped = huesped;
        setFechas(ingreso, salida);
        this.tarifaNoche = Math.max(0, tarifaNoche);
        this.confirmada = confirmada;
    }

    private void setFechas(LocalDate in, LocalDate out) {
        if (out.isAfter(in)) {
            this.ingreso = in;
            this.salida = out;
        } else {
            this.ingreso = in;
            this.salida = in.plusDays(1);
        }
    }

    public long noches() {
        return ChronoUnit.DAYS.between(ingreso, salida);
    }

    public double total() {
        return Math.round(noches() * tarifaNoche * 100.0) / 100.0;
    }

    public void confirmar() { confirmada = true; }

    public boolean cancelar() {
        if (!confirmada || ChronoUnit.HOURS.between(LocalDate.now().atStartOfDay(), ingreso.atStartOfDay()) >= 48) {
            confirmada = false;
            return true;
        }
        return false;
    }

    public String getHuesped() { return huesped; }
    public LocalDate getIngreso() { return ingreso; }
    public LocalDate getSalida() { return salida; }
    public double getTarifaNoche() { return tarifaNoche; }
    public boolean isConfirmada() { return confirmada; }

    @Override
    public String toString() {
        return noches() + " noches | $" + total();
    }
}
