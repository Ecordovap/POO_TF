package CalculadoraPlanilla;

import java.time.LocalDate;

public class Emprendedor extends Empleado{
    private String escala;
    private int mesCreacion;
    private int añoCreacion;
    private int diasActivos;


    public Emprendedor(int DNI, String nombreCompleto, String departamento, int DNILider, boolean esLider,
                       int volumenPP, int volumenSS, int UR,  int mesCreacion, int añoCreacion, int diasActivos) {
        super(DNI, nombreCompleto, departamento, DNILider, esLider, volumenPP, volumenSS, UR);
        calcularEscala();
        this.mesCreacion = mesCreacion;
        this.añoCreacion = añoCreacion;
        this.diasActivos = diasActivos;
    }

    public void calcularEscala(){
        /*LocalDate fechaDeHoy = LocalDate.now();
        int añoHoy = fechaDeHoy.getYear();
        int mesHoy = fechaDeHoy.getMonthValue();*/
        if(getVolumenPP() >= 222 && getUR() >= 122 && getVolumenSS() >= 34)
            escala = "E5";
        else if(getVolumenPP() >= 207 && getUR() >= 114 && getVolumenSS() >= 30)
            escala = "E4";
        else if(getVolumenPP() >= 188 && getUR() >= 103 && getVolumenSS() >= 24)
            escala = "E3";
        else if(getVolumenPP() >= 147 && getUR() >= 81 && getVolumenSS() >= 18)
            escala = "E2";
        else if(getVolumenPP() >= 106 && getUR() >= 58 && getVolumenSS() >= 14)
            escala = "E1";
        else if(getVolumenPP() >= 63 && getUR() >= 35 && getVolumenSS() >= 12)
            escala =  "E0";
        else
            escala = "Sin Escala";
    }

    public double calcularBonoURM1(){
        double porcURM1 = getUR()/getVolumenPP();
        if(porcURM1 >= 0.38)
            return getUR()*3;
        return 0;
    }

    public double calcularBonoDiasActivos(){
        if(diasActivos>=28)
            return 10;
        return 0;
    }


    @Override
    public double calcularPlanilla() {
        double pagoPlanillaAux = 0;
        if (escala.equals("E5")) pagoPlanillaAux = 4890;
        else if (escala.equals("E4")) pagoPlanillaAux = 4455;
        else if (escala.equals("E3")) pagoPlanillaAux = 3921;
        else if (escala.equals("E2")) pagoPlanillaAux = 3067;
        else if (escala.equals("E1")) pagoPlanillaAux = 2230;
        else if (escala.equals("E0")) pagoPlanillaAux = 1314;
        else if (escala.equals("Sin escala")) pagoPlanillaAux = 0;

        return pagoPlanillaAux + calcularBonoURM1() + calcularBonoDiasActivos();
    }

    @Override
    public void imprimirEmpleado() {
        System.out.println("Tipo Emprendedor - DNI: " + getDNI() + ", Nombre: " + getNombreCompleto() + ", Escala: " + escala + ", Departamento: " + getDepartamento() +
                ", Pago planilla: " + calcularPlanilla());
    }
}
