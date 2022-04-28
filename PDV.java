package ProyectoGrupal;

public class Pdv extends Empleado{
    private String clasificacion;
    private boolean tieneEquipo;

    public Pdv(int dni, String nombreCompleto, String departamento, int dniLider, boolean esLider, int volumenPP, int volumenSS, int ur, String clasificacion, boolean tieneEquipo) {
        super(dni, nombreCompleto, departamento, dniLider, esLider, volumenPP, volumenSS, ur);
        this.clasificacion = clasificacion;
        this.tieneEquipo = tieneEquipo;
    }
    public String calcularClasificacion(){
        if (getVolumenPP() >= 7 && getVolumenSS() >= 20)
            return "Oro";
        else if (getVolumenPP() >= 5 && getVolumenSS() >= 15)
            return "Plata";
        else return "Bonce";
    }

    @Override
    public double calcularPlanilla() {
        double auxPagoPlanilla = 0;
        switch (clasificacion){
            case "Oro": auxPagoPlanilla = 1200;
            case "Plata": auxPagoPlanilla = 1000;
            case "Bronce": auxPagoPlanilla = 800;
        }
        if (tieneEquipo) auxPagoPlanilla = auxPagoPlanilla + 50;
        if (getUr()/getVolumenPP() >= 0.55) auxPagoPlanilla = auxPagoPlanilla + 100;
        return auxPagoPlanilla;
    }

    @Override
    public void imprimirEmpleado() {
        System.out.println("Tipo Pdv - DNI: "+getDni()+ " , Nombre: "+getNombreCompleto()+ " , Clasificacion: "+calcularClasificacion()+
                " , Pago planilla: "+calcularPlanilla());
    }
}
