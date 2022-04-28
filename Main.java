package CalculadoraPlanilla;

public class Main {
    public static void main(String[] args) {
        Planilla listaPlanilla = new Planilla();
        try {
            listaPlanilla.agregarEmpleado(new Emprendedor(76534586, "Pedro Sanchez", "Lima", 76534586, true, 4000, 2000, 3500, 4, 2022, 29));
            listaPlanilla.agregarEmpleado(new Emprendedor(34577654, "Marcos Carrasco", "Lima", 76534586, true, 40, 10, 10, 4, 2022, 29));
            listaPlanilla.agregarEmpleado(new PDV(34577654, "Jaime Hurtado", "Ica", 76534586, true, 30, 400, 20, true));
            
        }
        catch (DNIRepetido dniRep) {
            System.out.println(dniRep.getMessage());
        }

        listaPlanilla.imprimirPlanilla();
    }
}
