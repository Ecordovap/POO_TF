package CalculadoraPlanilla;

public class Backoffice extends Empleado{
    private String cargo;
    private double antiguedad;

    public Backoffice(int DNI, String nombreCompleto, String departamento, int DNILider, boolean esLider,
                      String cargo, double antiguedad) {
        super(DNI, nombreCompleto, departamento, DNILider, esLider, 0,0,0);
        this.cargo = cargo;
        this.antiguedad = antiguedad;
    }

    public String getCargo() {
        return cargo;
    }

    public double pagoPorCargo(){
        double auxPagoPlanilla = 0;
        if(cargo.equals("Analista")) auxPagoPlanilla = 3000;
        else if(cargo.equals("Coordinador")) auxPagoPlanilla = 5000;
        else if(cargo.equals("KAM")) auxPagoPlanilla = 7000;
        else if(cargo.equals("Gerente")) auxPagoPlanilla = 9000;

        return auxPagoPlanilla;
    }

    public double pagoPorAntiguedad(){
        if(antiguedad >=2 && antiguedad <4) return 50;
        else if(antiguedad >= 4 && antiguedad < 5) return 100;
        else if(antiguedad >=5) return 200;
        return 0;
    }

    @Override
    public double calcularPlanilla() {
        return pagoPorCargo() + pagoPorAntiguedad();
    }

    @Override
    public void imprimirEmpleado() {
        System.out.println("Tipo Backoffice - DNI: " + getDNI() + ", Nombre: " + getNombreCompleto() + ", Cargo: " + cargo + ", Departamento: " + getDepartamento() +
                ", Pago planilla: " + calcularPlanilla());
    }
}
