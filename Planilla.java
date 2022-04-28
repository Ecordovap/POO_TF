package CalculadoraPlanilla;

import java.util.ArrayList;

public class Planilla {
    ArrayList<Empleado> planillaCompleta;

    public Planilla(){
        planillaCompleta = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) throws DNIRepetido{
        for (Empleado p:planillaCompleta){
            if(p.getDNI() == e.getDNI())
                throw new DNIRepetido("No se puede ingresar. DNI repetido.");
        }
        planillaCompleta.add(e);
    }

    public void imprimirPlanilla(){
        System.out.println("Planilla:");
        for(Empleado e: planillaCompleta)
            e.imprimirEmpleado();

    }

    public double calcularTotalPlanilla(){
        double totalPlanilla = 0;
        for(Empleado e: planillaCompleta){
            totalPlanilla = totalPlanilla + e.calcularPlanilla();
        }
        return totalPlanilla;
    }



}
