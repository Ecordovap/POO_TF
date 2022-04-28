package ProyectoGrupal;

public class Entel extends  Empleado implements Sueldo{
    private String cargo;
    private String jefe;
    private int antiguedad;

    public Entel(int DNI, String nombres, String apellidos, String direccion, String tipo,
                 int DNILider, String clase, String cargo, String jefe, int antiguedad) {
        super(DNI, nombres, apellidos, direccion, tipo, DNILider, clase);
        this.cargo = cargo;
        this.jefe = jefe;
        this.antiguedad = antiguedad;
    }

    @Override
    public void calcularSueldo() {


    }
}
