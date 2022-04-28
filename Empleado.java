package CalculadoraPlanilla;

public abstract class Empleado {
    private int DNI;
    private String nombreCompleto;
    private String departamento;
    private int DNILider;
    private boolean esLider;
    private int volumenPP;
    private int volumenSS;
    private int UR;

    public Empleado(int DNI, String nombreCompleto, String departamento, int DNILider, boolean esLider,
                    int volumenPP, int volumenSS, int UR) {
        this.DNI = DNI;
        this.nombreCompleto = nombreCompleto;
        this.departamento = departamento;
        this.DNILider = DNILider;
        this.esLider = esLider;
        this.volumenPP = volumenPP;
        this.volumenSS = volumenSS;
        this.UR = UR;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getDNILider() {
        return DNILider;
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

    public int getUR() {
        return UR;
    }

    public abstract double calcularPlanilla();
    public abstract void imprimirEmpleado();

}
