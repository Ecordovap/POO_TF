package CalculadoraPlanilla;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Planilla listaPlanilla = new Planilla();

        //Ingreso de personas a la planilla
        try {
            listaPlanilla.agregarEmpleado(new Emprendedor(76534582, "Samuel Espinoza", "Lima", 76534582, true, 64, 13, 36, 4, 2022, 29));
            listaPlanilla.agregarEmpleado(new Emprendedor(76534586, "Pedro Sanchez", "Lima", 76534586, true, 320, 100, 280, 4, 2022, 29));
            listaPlanilla.agregarEmpleado(new Emprendedor(34577654, "Marcos Carrasco", "Ica", 76534586, false, 40, 10, 10, 4, 2022, 29));
            listaPlanilla.agregarEmpleado(new Emprendedor(34275488, "Luis Alzamora", "Arequipa", 23747332, false, 221, 36, 116, 2, 2021, 10));
            listaPlanilla.agregarEmpleado(new Emprendedor(12347362, "Pedro Cevallos", "Cusco", 12347362, true, 190, 36, 110, 1, 2020, 28));
            listaPlanilla.agregarEmpleado(new Emprendedor(43726332, "Miguel Lopez", "Lima", 32412334, false, 147, 18, 81, 5, 2021, 28));
            listaPlanilla.agregarEmpleado(new Emprendedor(67847332, "Lourdes Montalvo", "Piura", 67847332, true, 110, 15, 59, 3, 2022, 29));
            listaPlanilla.agregarEmpleado(new Emprendedor(54873223, "Diego Rodriguez", "Tacna", 12347362, false, 65, 12, 35, 4, 2022, 29));
            listaPlanilla.agregarEmpleado(new PDV(07633475, "Carlos Abad", "Lambayeque", 07633475, true, 3, 5, 1, true));
            listaPlanilla.agregarEmpleado(new PDV(23564234, "Kevin Valle", "Junin", 23564234, true, 7, 20, 6, true));
            listaPlanilla.agregarEmpleado(new PDV(37564923, "Fabiana Sanchez", "Arequipa", 37564923, true, 5, 15, 5, true));
            listaPlanilla.agregarEmpleado(new Backoffice(42845734,"Jesus Zavala","Lima",42845734,true,"KAM",5));
            listaPlanilla.agregarEmpleado(new Backoffice(33478583,"Giancarlo Soto","Lima",33478583,true,"Gerente",10));
            listaPlanilla.agregarEmpleado(new Backoffice(84573473,"Laura Carlos","Lima",84573473,true,"Analista",2));
            listaPlanilla.agregarEmpleado(new Backoffice(23423848,"Jaime Perez","Lima",23423848,true,"Coordinador",4));

            //Excepción de repetición de DNI
            //listaPlanilla.agregarEmpleado(new PDV(34577654, "Jaime Hurtado", "Ica", 76534586, true, 30, 400, 20, true));
            //listaPlanilla.agregarEmpleado(new PDV(23564234, "Kevin Valle", "Junin", 23564234, true, 7, 20, 6, true));

            //Excepción de ingreso de personas sin ventas
            //listaPlanilla.agregarEmpleado(new Emprendedor(34875834,"Christian Herencia","Lima",254364555,true,0,0,0,8,2021,30));

            //Excepción de UR > venta PP
            //listaPlanilla.agregarEmpleado(new Emprendedor(34875834,"Christian Herencia","Lima",254364555,true,20,4,30,8,2021,30));
        }
        catch (ExcepcionIngresoPlanilla ex) {
            System.out.println(ex.getMessage());
            System.out.println();
        }


        System.out.println("Sistema de Registro de Planilla del Canal Masivo Entel");
        System.out.println("Elija una opción:");
        System.out.println("1 - Listar todos los empleados pertenecientes a la planilla.");
        System.out.println("2 - Búsqueda de un empleado por DNI.");
        System.out.println("3 - Listar empleados por tipo.");
        System.out.println("4 - Listar empleados por departamento.");
        System.out.println("5 - Calcular total a pagar en la planilla.");

        Scanner input = new Scanner(System.in);
        int opcion = input.nextInt();

        if(opcion == 1){
            listaPlanilla.imprimirPlanilla();
        }
        else if (opcion == 2){
            System.out.println("Ingrese el DNI a buscar: ");
            int dniParaBuscar = input.nextInt();
            //Búsqueda de un dni en Planilla
            try {
                //Empleado e = listaPlanilla.buscaEmpleado(76534586); //Caso que sí funciona
                //Empleado e = listaPlanilla.buscaEmpleado(73648584); //Caso que no funciona
                Empleado e = listaPlanilla.buscaEmpleado(dniParaBuscar);
                System.out.println("Resultado de Búsqueda de DNI: ");
                e.imprimirEmpleado();
                System.out.println();
            }
            catch (ExcepcionIngresoPlanilla ex){
                System.out.println("Resultado de Búsqueda de DNI: ");
                System.out.println(ex.getMessage());
                System.out.println();
            }
        }
        else if (opcion == 3){
            System.out.println("Ingrese el tipo a buscar:");
            String tipoParaBuscar = input.next();
            if(tipoParaBuscar.equals("Emprendedor")){
                //Listar empleados tipo Emprendedor
                System.out.println("Listado de empleados tipo Emprendedor:");
                try{
                    listaPlanilla.listarEmpleadoPorTipo("Emprendedor");
                }
                catch(ExcepcionIngresoPlanilla ex){
                    System.out.println(ex.getMessage());
                }
                finally {
                    System.out.println();
                }
            }
            else if(tipoParaBuscar.equals("PDV")){
                //Listar empleados tipo PDV
                System.out.println("Listado de empleados tipo PDV:");
                try{
                    listaPlanilla.listarEmpleadoPorTipo("PDV");
                }
                catch(ExcepcionIngresoPlanilla ex){
                    System.out.println(ex.getMessage());
                }
                finally {
                    System.out.println();
                }
            }
            else if(tipoParaBuscar.equals("Backoffice")){
                //Listar empleados tipo Backoffice
                System.out.println("Listado de empleados tipo Backoffice:");
                try{
                    listaPlanilla.listarEmpleadoPorTipo("Backoffice");
                }
                catch(ExcepcionIngresoPlanilla ex){
                    System.out.println(ex.getMessage());
                }
                finally {
                    System.out.println();
                }
            }
        }
        else if (opcion == 4) {
            try {
                System.out.println("Ingrese el departamento: ");
                String dptoABuscar = input.next();
                listaPlanilla.listarEmpleadoPorDepartamento(dptoABuscar);
            } catch (ExcepcionIngresoPlanilla ex) {
                System.out.println(ex.getMessage());
            }
        }
        else if(opcion == 5){
            System.out.println("Costo total de planilla: " + listaPlanilla.calcularTotalPlanilla());
        }
    }
}
