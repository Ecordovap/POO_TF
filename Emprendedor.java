package ProyectoGrupal;

public class Emprendedor extends Empleado{
    private String escala;
    private boolean referido;

    public Emprendedor(int DNI, String nombres, String apellidos, String direccion,
                       String tipo, int DNILider, String clase, String escala, boolean referido) {
        super(DNI, nombres, apellidos, direccion, tipo, DNILider, clase);
        this.escala = escala;
        this.referido = referido;
    }
}
