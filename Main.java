package Grupo3;

public class Ejecutora {
    public static void main(String[] args) {
        Planilla listaPlanilla = new Planilla();
        listaPlanilla.agregarEmpleado(new Emprendedor(12345678,"Camila Galarreta", "Lima", 12345677, true, 400,
                200, 350, "AB", 4, 2022,29));

        listaPlanilla.imprimirPlanilla();
    }
}