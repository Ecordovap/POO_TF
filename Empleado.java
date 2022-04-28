package ProyectoGrupal;

public class Empleado  extends  Persona{
    private String tipo;
    private int DNILider;
    private String clase;

    public Empleado(int DNI, String nombres, String apellidos, String direccion, String tipo, int DNILider, String clase) {
        super(DNI, nombres, apellidos, direccion);
        this.tipo = tipo;
        this.DNILider = DNILider;
        this.clase = clase;
    }
}
