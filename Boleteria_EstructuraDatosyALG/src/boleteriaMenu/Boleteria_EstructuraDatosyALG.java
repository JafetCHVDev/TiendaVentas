package boleteriaMenu;

import boleteriaClientes.ClientesListaDoble;
import boleteriaReservaciones.ReservacionesListaSimple;
import boleteriaCompra.ComprasListaCircular;
import java.util.Scanner;

public class Boleteria_EstructuraDatosyALG {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ClientesListaDoble clientes = new ClientesListaDoble();
        ReservacionesListaSimple reservaciones = new ReservacionesListaSimple();
        ComprasListaCircular compras = new ComprasListaCircular();
        int opcion = 0;
        while (opcion != 11) { //ciclo para el menu
            boolean datosvalidos = false;
            while (!datosvalidos) {
                try {
                    mostrarOpciones();
                    opcion = teclado.nextInt(); 
                    teclado.nextLine();
                    datosvalidos = true;
                } catch (Exception e) {
                    System.out.println("Error: Ingrese una opcion valida");
                    teclado.nextLine();
                    datosvalidos = false;
                }
            }

            if (opcion == 1) { //registrar cliente
                clientes.Agregar_Final();
            } else if (opcion == 2) { //eliminar cliente
                clientes.eliminarCliente();
            } else if (opcion == 3) { //cambiar direccion de un cliente
                clientes.modificarDireccion();
            } else if (opcion == 9) { //mostrar datos lista doble
                clientes.mostrarDatos();
            } else if (opcion == 4) { //registrar reservación
                reservaciones.agregarFinal();
            } else if (opcion == 5) {//modificar ubicacion de reservacion
                reservaciones.modificarUbicacion();
            } else if (opcion == 6) {// eliminar una reservacion
                reservaciones.eliminarReservacion();
            } else if (opcion == 7) {//hacer compras
                int tieneReservacion = 0;
                datosvalidos = false;
                while (!datosvalidos) {
                    try {
                        System.out.print("Cuenta con una reservacion (1. Si 2. No): "); //preguntar si hay reservacion y cedula
                        tieneReservacion = teclado.nextInt();
                        teclado.nextLine();
                        datosvalidos = true;
                    } catch (Exception e) {
                        System.out.println("Error: Ingrese una opcion valida");
                        teclado.nextLine();
                        datosvalidos = false;
                    }
                }
                if (tieneReservacion == 1) { //si tiene reservacion
                    int cedulaReservacion = 0;
                    datosvalidos = false;
                    while (!datosvalidos) {
                        try {
                            System.out.print("Digite la cedula de la reservacion: ");
                            cedulaReservacion = teclado.nextInt();
                            teclado.nextLine();
                            datosvalidos = true;
                        } catch (Exception e) {
                            System.out.println("Error: Ingrese una opcion valida");
                            teclado.nextLine();
                            datosvalidos = false;
                        }
                    }
                    boolean validaReservacion = reservaciones.hayReservacion(cedulaReservacion); //validar si hay una reservacion con esa cedula
                    if (validaReservacion == true) {
                        int ubicacionObtenida = obtenerUbicacionReservacion(reservaciones, cedulaReservacion);
                        String nombreEventoObtenido = obtenerNombreEventoReservacion(reservaciones, cedulaReservacion);
                        compras.Agregar(cedulaReservacion, ubicacionObtenida, nombreEventoObtenido);
                    } else {
                        System.out.println("No existe una reservacion con esa cedula.");
                    }
                } else if (tieneReservacion == 2) {//compra sin reservacion tiene reservacion
                    int cedulaCompra = 0;
                    int ubicacionCompra = 0;
                    String nombreEventoCompra = "";
                    datosvalidos = false;
                    while (!datosvalidos) {
                        try {
                            System.out.print("Digite su cedula: ");
                            cedulaCompra = teclado.nextInt();
                            teclado.nextLine();
                            System.out.print("Digite la ubicacion de su compra(1 VIP 2 PREFERENCIAL 3 GENERAL): ");
                            ubicacionCompra = teclado.nextInt();
                            teclado.nextLine();
                            System.out.print("Digite el nombre del Evento: ");
                            nombreEventoCompra = teclado.nextLine();
                            datosvalidos = true;
                        } catch (Exception e) {
                            System.out.println("Error: Ingrese una opcion valida");
                            teclado.nextLine();
                            datosvalidos = false;
                        }
                    }
                    compras.Agregar(cedulaCompra, ubicacionCompra, nombreEventoCompra);
                } else {
                    System.out.println("Opcion no valida");
                }
                //hacer compra1

            } else if (opcion == 8) {
                //imprimir ganancias
                compras.mostrarGanancias();
            } else if (opcion == 10) {//mostrar datos lista simple
                reservaciones.mostrarDatos();
            } else if (opcion == 11) {//salir
                System.out.println("Programa finalizado");
                System.exit(0);
            } else if (opcion > 11 || opcion < 0) {
                System.out.println("Opcion no valida.");
            }
        } //fin while menu
    }//fin de main

    public static void mostrarOpciones() {
        System.out.println("____________________________________");
        System.out.println("Menu de opciones: ");
        System.out.println("1. Registrar Cliente.");
        System.out.println("2. Eliminar Cliente");
        System.out.println("3. Modificar Direccion de Cliente.");
        System.out.println("4. Registrar reservacion");
        System.out.println("5. Modificar ubicacion de reservacion por cedula. ");
        System.out.println("6. Eliminar reservacion. ");
        System.out.println("7. Hacer compra.");
        System.out.println("8. Imprimir ganancias. ");
        System.out.println("9. Mostrar Datos de Clientes");
        System.out.println("10. Mostrar Datos reservaciones");
        System.out.println("11. Salir.");
        System.out.println("____________________________________");
        System.out.print("Digite la opcion: ");
    }

    //validar si hay reservacion y obtener ubicacion
    public static int obtenerUbicacionReservacion(ReservacionesListaSimple preservaciones, int cedula) {
        Scanner teclado = new Scanner(System.in);
        int Ubicacion = 0;
        int cedulaBuscar = cedula;
        ReservacionesListaSimple reservaciones = preservaciones;
        String[] datosReservacion = reservaciones.obtenerDatosReservacion(cedulaBuscar);
        if (datosReservacion[0] == "Yes") {
            Ubicacion = Integer.parseInt(datosReservacion[2]);
        } else {
            System.out.println("No hay una reservacion con esa cedula");
        }
        return Ubicacion;
    }//fin metodo obtenerDatosRerservacion()

    //validar si hay reservacion y obtener nombre del evento
    public static String obtenerNombreEventoReservacion(ReservacionesListaSimple preservaciones, int cedula) {
        Scanner teclado = new Scanner(System.in);
        String nombreEvento = "";
        int cedulaBuscar = cedula;
        ReservacionesListaSimple reservaciones = preservaciones;
        String[] datosReservacion = reservaciones.obtenerDatosReservacion(cedulaBuscar);
        if (datosReservacion[0] == "Yes") {
            nombreEvento = datosReservacion[1];
        } else {
            System.out.println("");
        }
        return nombreEvento;

    }//fin metodo obtenerDatosRerservacion()

}
