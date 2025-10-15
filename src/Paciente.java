public class Paciente {
    private String documento;
    private String nombre;
    private int edad;
    private char nivelTriage;
    private boolean atendido;

    public Paciente() {
        this("", "", 0, 'E', false);
    }

    public Paciente(String documento, String nombre, int edad, char nivelTriage, boolean atendido) {
        this.documento = documento;
        this.nombre = nombre;
        this.edad = Math.max(0, edad);
        setNivelTriage(nivelTriage);
        this.atendido = atendido;
    }

    public int prioridad() {
        switch (nivelTriage) {
            case 'A': return 1;
            case 'B': return 2;
            case 'C': return 3;
            case 'D': return 4;
            default: return 5;
        }
    }

    public void marcarAtendido() { atendido = true; }

    public char getNivelTriage() { return nivelTriage; }
    public void setNivelTriage(char nivelTriage) {
        if ("ABCDE".indexOf(nivelTriage) != -1) this.nivelTriage = nivelTriage;
    }

    @Override
    public String toString() {
        return "Triage " + nivelTriage + " | Prioridad " + prioridad() + " | Atendido: " + atendido;
    }
}
