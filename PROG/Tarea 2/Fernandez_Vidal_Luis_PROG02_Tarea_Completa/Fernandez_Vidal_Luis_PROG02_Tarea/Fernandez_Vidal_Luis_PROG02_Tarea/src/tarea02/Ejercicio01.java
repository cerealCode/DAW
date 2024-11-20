package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 1. SUELDOS DE EMPLEADOS.
 *
 * @author Luis Fern�ndez Vidall
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaraci�n de variables 
        //----------------------------------------------
        // Constantes
        final double SUELDO_BASE = 1500.00;
        final int NUMERO_PAGAS = 14;

        // Variables de entrada
        int opcion;
        int antiguedadEmpleado1  = 0, antiguedadEmpleado2  = 0, antiguedadEmpleado3 = 0 ;

        // Variables de salida
        double sueldoEmpleadoNuevo, sueldoEmpleado1, sueldoEmpleado2, sueldoEmpleado3;

        //Variables  auxiliares
        int extra1, extra2, extra3;
        
        // Clase Scanner para petici�n de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 2: Sueldos de Empleados\n");
        System.out.println("-----------------------------------------");

        // Bloque 1: Sacamos por pantalla el men� de opciones y pedimos que introduzca una.
        // En caso de introducir una opci�n inv�lida, debemos indicarlo y volver a pedirla.  
        //Men� de opciones 
        do {
            System.out.println("Men� de opciones");
            System.out.println("1.- Calcular sueldo en funci�n de la antig�edad");
            System.out.println("2.- Calcular coste total en sueldos para la empresa");
            System.out.println("3.- Salir");

            // Elusuario elige una opci�n
            opcion = teclado.nextInt();

            // Si no ha elegido ninguna de las 3 opciones, mostramos que no es una opci�n v�lida
            if (opcion < 1 || opcion > 3) {
                System.out.println("Opci�n inv�lida. Por favor, elija una opci�n v�lida.");
            }
            //El bucle se repite mientras el usuario no elija una opci�n entre el 1 y el 3
        } while (opcion < 1 || opcion > 3);
        


        //Opci�n 1: Se pide la antig�edad de cada empleado
        if (opcion == 1) {
            do {
                System.out.println("Introduce la antig�edad del empleado 1:");
                antiguedadEmpleado1 = teclado.nextInt();

                System.out.println("Introduce la antig�edad del empleado 2:");
                
                antiguedadEmpleado2 = teclado.nextInt();

                System.out.println("Introduce la antig�edad del empleado 3:");
                
                antiguedadEmpleado3 = teclado.nextInt();
                // Si el valor introducido es negativo  se informa al usuario para que introduzca un n�mero positivo
                if (antiguedadEmpleado1 < 0 || antiguedadEmpleado2 < 0 || antiguedadEmpleado3 < 0) {
                    System.out.println("El numero de a�os no puede ser negativo");
                }
                //Repetimos el bucle hasta que los 3 valores introcidos sean positivos
            } while (antiguedadEmpleado1 < 0 || antiguedadEmpleado2 < 0 || antiguedadEmpleado3 < 0);
        }        

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Cuando haya introducido una opci�n v�lida, llevamos a cabo la acci�n oportuna
        //  -Si nos indica 'Salir', nos despedimos y terminamos
        //  -Si nos indica las opciones 1 o 2
        // Realizamos los c�lculos oportunos

        //C�lculo de salario por antiguedad
        //C�lculo el extra de cada empleado con un boolean aunque podr�a usar if-else, es m�s eficiente el boolean
        extra1 = antiguedadEmpleado1 > 5 ? 100 : 20;
        extra2 = antiguedadEmpleado2 > 5 ? 100 : 20;
        extra3 = antiguedadEmpleado3 > 5 ? 100 : 20;
        sueldoEmpleado1 = SUELDO_BASE + extra1 + (50 * antiguedadEmpleado1); 
        sueldoEmpleado2 = SUELDO_BASE + extra2+ (50 * antiguedadEmpleado2);
        sueldoEmpleado3 = SUELDO_BASE + extra3 + (50 * antiguedadEmpleado3);

        //Calculo Empleado sin antig�edad
        //Sumamos el SUELDO_BASE (1500) m�s la extra de un empleado sin antig�edad (20) y el resultado se multiplica por el NUMERO_PAGAS (14 pagas)
        sueldoEmpleadoNuevo = (SUELDO_BASE + 20) * NUMERO_PAGAS;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        //Uso un switch para mostrar los resultados de cada opci�n
        switch (opcion) {
            case 1:
                System.out.println("Los salarios de los empleados sin pagas extra prorrateadas son:");
                System.out.println("El salario del Empleado 1 es de: " + sueldoEmpleado1);
                System.out.println("El salario del Empleado 2 es de: " + sueldoEmpleado2);
                System.out.println("El salario del Empleado 3 es de: " + sueldoEmpleado3);
                break;
            case 2:
                //C�lculo sueldo anual de 14 pagas
                System.out.printf("El salario anual de un empleado sin antig�edad es de: %.2f\n", sueldoEmpleadoNuevo);
                //C�lculo salario mensual con prorrateo, diviendo el sueldo anual de 14 pagas entre 12
                System.out.printf("El salario mensual de un empleado sin antig�edad es de: %.2f\n", (sueldoEmpleadoNuevo / 12));
                break;
            case 3:
                System.out.println("Saliendo del programa...");
                System.exit(0);
            default:
                System.out.println("Opci�n no v�lida");
        }
    }
}
