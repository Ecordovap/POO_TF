package ProyectoGrupal;

import java.time.LocalDate;

public class Emprendedor extends Empleado {
    private String escala;
    private int mesCreacion;
    private int añocreacion;
    private int diasActivos;

    public Emprendedor(int dni, String nombreCompleto, String departamento, int dniLider, boolean esLider, int volumenPP, int volumenSS, int ur, String escala, int mesCreacion, int añocreacion, int diasActivos) {
        super(dni, nombreCompleto, departamento, dniLider, esLider, volumenPP, volumenSS, ur);
        this.escala = escala;
        this.mesCreacion = mesCreacion;
        this.añocreacion = añocreacion;
        this.diasActivos = diasActivos;
    }

    //public String getEscala() {
        //return escala;
    //}

    public String calcularEscala(){
        LocalDate fechaDeHoy = LocalDate.now();
        if (getVolumenPP() >= 207 && getUr() >= 122 && getVolumenSS() >= 34)
            return "E5";
        else if (getVolumenPP() >= 207 && getUr() >= 114 && getVolumenSS() >= 30)
            return "E4";
        else if(getVolumenPP() >= 188 && getUr() >= 103 && getVolumenSS() >= 24)
            return "E3";
        else if(getVolumenPP() >= 147 && getUr() >= 81 && getVolumenSS() >= 18)
            return "E2";
        else if(getVolumenPP() >= 106 && getUr() >= 58 && getVolumenSS() >= 14)
            return "E1";
        else if(getVolumenPP() >= 63 && getUr() >= 35 && getVolumenSS() >= 12 &&
                fechaDeHoy.getYear() == añocreacion && fechaDeHoy.getMonthValue()==mesCreacion) //No puede tener E0 un código antiguo
            return "E0";
        else    return "Sin Escala";
    }

    public double calcularBonoURM1(){
        double porcURM1 = getUr()/getVolumenPP();
        if (porcURM1 >= 0.38)
            return getUr()*3;
        else return  0;
    }

    public double calcularBonoDiasActivos (){
        if (diasActivos >= 28)
            return 10;
        else return 0;
    }

    @Override
    public double calcularPlanilla() {
        double pagoPlanillaAux = 0;
        switch (escala){
            case "E5": pagoPlanillaAux = 4890;
            case "E4": pagoPlanillaAux = 4455;
            case "E3": pagoPlanillaAux = 3921;
            case "E2": pagoPlanillaAux = 3067;
            case "E1": pagoPlanillaAux = 2230;
            case "E0": pagoPlanillaAux = 1314;
            case "Sin Escala": pagoPlanillaAux = 0;
        }
        return pagoPlanillaAux = pagoPlanillaAux + calcularBonoURM1() + calcularBonoDiasActivos();
    }

    @Override
    public void imprimirEmpleado() {
        System.out.println("Tipo emprendedor - DNI: "+getDni()+ " , Nombre: "+getNombreCompleto()+ " , Escala: "+calcularEscala()+
                " , Pago planilla: "+calcularPlanilla());
    }
}
