package ProyectoGrupal;

public abstract class Empleado {
    private int dni;
    private String nombreCompleto;
    private String departamento;
    private int dniLider;
    private boolean esLider;
    private int volumenPP;
    private int volumenSS;
    private int ur;

    public Empleado(int dni, String nombreCompleto, String departamento, int dniLider, boolean esLider, int volumenPP, int volumenSS, int ur) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.departamento = departamento;
        this.dniLider = dniLider;
        this.esLider = esLider;
        this.volumenPP = volumenPP;
        this.volumenSS = volumenSS;
        this.ur = ur;
    }

    public int getDni() {
        return dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getDniLider() {
        return dniLider;
    }

    public boolean isEsLider() {
        return esLider;
    }

    public int getVolumenPP() {
        return volumenPP;
    }

    public int getVolumenSS() {
        return volumenSS;
    }

    public int getUr() {
        return ur;
    }

    public abstract double calcularPlanilla();
    public abstract void imprimirEmpleado();
}
