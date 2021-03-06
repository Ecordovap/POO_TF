package CalculadoraPlanilla;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Planilla {
    ArrayList<Empleado> planillaCompleta;

    public Planilla(){
        planillaCompleta = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) throws ExcepcionIngresoPlanilla{
        for (Empleado p:planillaCompleta){
            if(p.getDNI() == e.getDNI())
                throw new ExcepcionIngresoPlanilla("No se puede ingresar. DNI " + e.getDNI() + " repetido.");
            if(e instanceof Emprendedor || e instanceof PDV)
                if (e.getUR() == 0 && e.getVolumenSS() == 0 && e.getVolumenPP() == 0)
                    throw new ExcepcionIngresoPlanilla("No se puede ingresar. DNI " + e.getDNI() + " no tiene ventas.");
            if(e.getUR()>e.getVolumenPP())
                throw new ExcepcionIngresoPlanilla("No se puede ingresar. No se puede tener más UR que venta PP.");
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

    public Empleado buscaEmpleado(int dni) throws ExcepcionIngresoPlanilla{
        for(Empleado e: planillaCompleta){
            if(e.getDNI()==dni)
                return e;
        }
        throw new ExcepcionIngresoPlanilla("El empleado no fue encontrado.");
    }

    public void listarEmpleadoPorTipo (String tipo) throws ExcepcionIngresoPlanilla {
        if (tipo.equals("Emprendedor") || tipo.equals("PDV") || tipo.equals("Backoffice")){
            for (Empleado e : planillaCompleta) {
                if (tipo.equals("Emprendedor")) {
                    if (e instanceof Emprendedor)
                        e.imprimirEmpleado();
                } else if (tipo.equals("PDV")) {
                    if (e instanceof PDV)
                        e.imprimirEmpleado();
                } else if (tipo.equals("Backoffice")) {
                    if (e instanceof Backoffice)
                        e.imprimirEmpleado();
                }
            }
        }
        else
            throw new ExcepcionIngresoPlanilla("El tipo " + tipo + " no es válido.");
    }

    public void listarEmpleadoPorDepartamento(String dpto) throws ExcepcionIngresoPlanilla{
        int flagNoEncontrado = 0;
        for (Empleado e : planillaCompleta) {
            if(dpto.equals(e.getDepartamento())) {
                flagNoEncontrado = 1;
                e.imprimirEmpleado();
            }
        }

        if(flagNoEncontrado == 0)
            throw new ExcepcionIngresoPlanilla("No existen empleados del departamento " + dpto + ".");
    }

    public void calcularResumen(){
        double planillaEmprendedor = 0;
        double planillaPDV = 0;
        double planillaBackoffice = 0;
        for(Empleado e: planillaCompleta){
            if(e instanceof Emprendedor)
                planillaEmprendedor = planillaEmprendedor + e.calcularPlanilla();
            if(e instanceof PDV)
                planillaPDV = planillaPDV + e.calcularPlanilla();
            if(e instanceof Backoffice)
                planillaBackoffice = planillaBackoffice + e.calcularPlanilla();
        }

        double planillaTotal = planillaBackoffice+planillaPDV+planillaEmprendedor;

        System.out.println("Planilla por tipo: ");
        System.out.println("Total emprendedor: S/" + planillaEmprendedor);
        System.out.println("Total PDV: S/" + planillaPDV);
        System.out.println("Total Backoffice: S/" + planillaBackoffice);
        System.out.println("Total general: S/"+ planillaTotal);

    }

    public void calcularPlanillaPorDpto(){
        String dptoDelMomento;
        double planillaDpto = 0 ;
        int flag = 0;

        ArrayList<String> departamentosRepetidos;
        departamentosRepetidos = new ArrayList<>();

        System.out.println("Planilla por departamento: ");

        for (Empleado e: planillaCompleta){
            dptoDelMomento = e.getDepartamento();
            for(String d:departamentosRepetidos){
                if(d.equals(dptoDelMomento)){
                    flag = 1;
                }
            }
            if(flag == 0) {
                for (Empleado p : planillaCompleta) {
                    if (p.getDepartamento().equals(dptoDelMomento)) {
                        planillaDpto = planillaDpto + p.calcularPlanilla();
                    }
                }
                System.out.println(dptoDelMomento + ": S/" + planillaDpto);
                departamentosRepetidos.add(dptoDelMomento);

            }
            planillaDpto = 0;
            flag = 0;

        }
    }


}
