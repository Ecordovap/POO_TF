package CalculadoraPlanilla;

public class PDV extends Empleado{
    private String clasificacion;
    private boolean tieneEquipo;

    public PDV(int DNI, String nombreCompleto, String departamento, int DNILider, boolean esLider,
               int volumenPP, int volumenSS, int UR, boolean tieneEquipo) {
        super(DNI, nombreCompleto, departamento, DNILider, esLider, volumenPP, volumenSS, UR);
        this.clasificacion = calcularClasificacion();
        this.tieneEquipo = tieneEquipo;
    }

    public String calcularClasificacion(){
        if(getVolumenPP() >= 7 && getVolumenSS() >= 20)
            return "Oro";
        else if(getVolumenPP() >= 5 && getVolumenSS() >= 15)
            return "Plata";
        return "Bronce";
    }

    @Override
    public double calcularPlanilla() {
        double auxPagoPlanilla = 0;
        if(clasificacion.equals("Oro")) auxPagoPlanilla = 1200;
        else if(clasificacion.equals("Plata")) auxPagoPlanilla = 1000;
        else if(clasificacion.equals("Bronce")) auxPagoPlanilla = 800;

        if(tieneEquipo) auxPagoPlanilla = auxPagoPlanilla + 50;

        if(getUR()/getVolumenPP() >= 0.55) auxPagoPlanilla = auxPagoPlanilla + 100;

        return  auxPagoPlanilla;
    }

    @Override
    public void imprimirEmpleado() {
        System.out.println("Tipo PDV - DNI: " + getDNI() + ", Nombre: " + getNombreCompleto() + ", Clasificacion: " + calcularClasificacion() +
                ", Pago planilla: " + calcularPlanilla());
    }
}
