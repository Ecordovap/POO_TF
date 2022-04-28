package ProyectoGrupal;

public class PDV extends Empleado{
    private boolean equipo;
    private String clasificacion;

    public PDV(int DNI, String nombres, String apellidos, String direccion, String tipo,
               int DNILider, String clase, boolean equipo, String clasificacion) {
        super(DNI, nombres, apellidos, direccion, tipo, DNILider, clase);
        this.equipo = equipo;
        this.clasificacion = clasificacion;
    }
}
