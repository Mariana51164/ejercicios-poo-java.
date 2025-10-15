public class Producto {
    private String codigo;
    private String nombre;
    private int stock;
    private double precioUnitario;
    private boolean activo;

    public Producto() {
        this("", "", 0, 0.0, true);
    }

    public Producto(String codigo, String nombre, int stock, double precioUnitario, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = Math.max(0, stock);
        this.precioUnitario = Math.max(0, precioUnitario);
        this.activo = activo;
    }

    public void ingresar(int cantidad) {
        if (cantidad > 0) stock += cantidad;
    }

    public boolean vender(int cantidad) {
        if (activo && cantidad > 0 && stock >= cantidad) {
            stock -= cantidad;
            return true;
        }
        return false;
    }

    public void descontinuar() { activo = false; }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
    public double getPrecioUnitario() { return Math.round(precioUnitario * 100.0) / 100.0; }
    public boolean isActivo() { return activo; }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario >= 0) this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " | stock: " + stock + " | $" + String.format("%.2f", precioUnitario);
    }
}
