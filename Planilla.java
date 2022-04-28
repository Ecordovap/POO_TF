package Grupo3;

import java.util.ArrayList;

public class Planilla {
    ArrayList<Empleado> planillaCompleta;

    public Planilla(){
        planillaCompleta = new ArrayList<>();
    }
    public void agregarEmpleado(Empleado e){
        planillaCompleta.add(e);
    }

    public void imprimirPlanilla(){
        System.out.println("planilla: ");
        for (Empleado e : planillaCompleta)
            e.imprimirEmpleado();
    }

    public double calcularTotalPlanilla () {
        double totalPlanilla = 0;
        for (Empleado e : planillaCompleta){
            totalPlanilla = totalPlanilla + e.calcularPlanilla();
        }
        return totalPlanilla;
    }
}