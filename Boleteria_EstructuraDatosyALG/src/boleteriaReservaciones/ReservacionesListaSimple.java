package boleteriaReservaciones;

import java.util.Scanner;

public class ReservacionesListaSimple {

    ReservacionesNodoSimple primero;
    ReservacionesNodoSimple ultimo;

    public ReservacionesListaSimple() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean listaSVacia() { //metodo para revisar si la lista está vacía
        boolean estaVacia;
        if (primero == null) {
            estaVacia = true;
        } else {
            estaVacia = false;
        }
        return estaVacia;
    } // fin metodo listaVacia

    public void agregarFinal() {
        Scanner teclado = new Scanner(System.in);
        boolean datosvalidos = false;
        int cedula = 0;
        int Ubicacion = 0;
        String nombreEvento = "";
        while (!datosvalidos) {
            try {
                System.out.print("Digite la cedula del cliente: ");
                cedula = teclado.nextInt();
                teclado.nextLine();
                System.out.print("Digite el nombre del evento: ");
                nombreEvento = teclado.nextLine();
                System.out.print("Digite la ubicacion(1 VIP 2 PREFERENCIAL 3 GENERAL): ");
                Ubicacion = teclado.nextInt();
                teclado.nextLine();
                datosvalidos = true;
            } catch (Exception e) {
                System.out.println("Error: Ingrese una opcion valida");
                teclado.nextLine();
                datosvalidos = false;
            }
        }
        ReservacionesNodoSimple nuevonodo = new ReservacionesNodoSimple(cedula, nombreEvento, Ubicacion);//1 VIP 2 PREFERENCIAL 3 GENERAL
        if (primero == null) {  //validar si la lista esta vacía
            ultimo = nuevonodo;
            primero = ultimo;
        } else {  //sino esta vacía:
            ReservacionesNodoSimple auxiliar = primero; //nodo auxiliar para recorrer la lista y buscar que nodo enlaza con null
            while (auxiliar.siguiente != null) {
                auxiliar = auxiliar.siguiente;
            }                        //cuando se encuentra el ultimo nodo, se crea uno nuevo y se le apunta al final

            auxiliar.siguiente = nuevonodo;
            ultimo = nuevonodo;
            System.out.println("Reservacion realizada. ");
        }

    }//fin metodo agregarFinal

    //metodo valdiar si hay reservacion
    public boolean hayReservacion(int pcedula) {
        boolean hayReservacion = false;
        if (listaSVacia() == true) {
            System.out.println("No hay reservas aún");
            System.out.println("___________________");
        } else {
            ReservacionesNodoSimple auxiliar = primero;
            int cedulaBuscar = pcedula;
            while (auxiliar.siguiente != null && auxiliar.cedula != cedulaBuscar) {//buscar elemento
                auxiliar = auxiliar.siguiente;
            }
            if (auxiliar.cedula == cedulaBuscar) {
                hayReservacion = true;
            } else {
                hayReservacion = false;
            }
        }
        return hayReservacion;
    }

    //metodo validar obtener datos de reservacion
    public String[] obtenerDatosReservacion(int pcedula) {
        String[] datosReservacion = {"", "", "",}; //hayreservacion, nombreevento, ubicacion
        String hayReservacion; //Yes o No
        String ubicacionR;
        String nombreEventoR;
        if (listaSVacia() == true) {
            System.out.println("No hay reservaciones.");
        } else {
            ReservacionesNodoSimple auxiliar = primero;
            int cedulaBuscar = pcedula;
            //buscar elemento
            while (auxiliar.siguiente != null && auxiliar.cedula != cedulaBuscar) {
                auxiliar = auxiliar.siguiente;
            }
            if (auxiliar.cedula == cedulaBuscar) {
                //pasar variables a un arreglo
                hayReservacion = "Yes";
                ubicacionR = Integer.toString(auxiliar.Ubicacion);
                nombreEventoR = auxiliar.nombreEvento;
                datosReservacion[0] = hayReservacion;
                datosReservacion[1] = nombreEventoR;
                datosReservacion[2] = ubicacionR;
            } else {
                hayReservacion = "No";
                System.out.println("No hay una reservacion con esa cedula.");
            }
        }
        return datosReservacion;
    }//fin metodo validar si existe una reservacion con cedula

    public void modificarUbicacion() {
        Scanner teclado = new Scanner(System.in);
        ReservacionesNodoSimple auxiliar = primero;

        if (listaSVacia() == true) {
            System.out.println("No hay clientes registrados aún");
            System.out.println("___________________");
        } else {
            boolean datosvalidos = false;
            int cedulaBuscar = 0;
            int nuevaUbicacion = 0;
            while (!datosvalidos) {
                try {
                    System.out.print("Digite la cedula de la reserva a la cual desea modificarle la direccion: ");//pedir cedula
                    cedulaBuscar = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Digite la nueva ubicacion (1 VIP 2 PREFERENCIAL 3 GENERAL): ");//pedir cedula
                    nuevaUbicacion = teclado.nextInt();
                    teclado.nextLine();
                    datosvalidos = true;
                } catch (Exception e) {
                    System.out.println("Error: Ingrese una opcion valida");
                    teclado.nextLine();
                    datosvalidos = false;
                }
            }
            //buscar elemento
            while (auxiliar.siguiente != null && auxiliar.cedula != cedulaBuscar) {
                auxiliar = auxiliar.siguiente;
            }
            if (auxiliar.cedula == cedulaBuscar) {
                auxiliar.Ubicacion = nuevaUbicacion;
                System.out.println("La ubicación ha sido modificada. ");

            } else {
                System.out.println("No hay reservaciones con ese numero de cédula.");
                System.out.println("__________________________");
            }
        }
    }//fin metodo modificarUbicacion

    public void eliminarReservacion() {
        Scanner teclado = new Scanner(System.in);
        ReservacionesNodoSimple auxiliar = primero;

        if (listaSVacia() == true) {
            System.out.println("No hay clientes registrados aún");
            System.out.println("___________________");
        } else {
            boolean datosvalidos = false;
            int cedulaEliminar = 0;
            while (!datosvalidos) {
                try {
                    System.out.print("Digite la cedula del cliente a eliminar: ");//pedir cedula
                    cedulaEliminar = teclado.nextInt();
                    teclado.nextLine();
                    datosvalidos = true;
                } catch (Exception e) {
                    System.out.println("Error: Ingrese una opcion valida");
                    teclado.nextLine();
                    datosvalidos = false;
                }
            }
            if (cedulaEliminar == primero.cedula) { //revisar si el elemento a eliminar es el primero, para mover el puntero
                primero = primero.siguiente;
                System.out.println("La reservacion relacionada a la cedula  " + cedulaEliminar + " ha sido eliminada.");
            } else { //buscar elemento
                while (auxiliar.siguiente != null && auxiliar.siguiente.cedula != cedulaEliminar) {
                    auxiliar = auxiliar.siguiente;
                }
                if (auxiliar.siguiente == null) {
                    System.out.println("No hay reservaciones con ese numero de cédula.");
                    System.out.println("__________________________");
                } else {
                    auxiliar.siguiente = auxiliar.siguiente.siguiente;
                    System.out.println("La reservacion relacionada a la cedula " + cedulaEliminar + " ha sido eliminada.");
                }

            }
        }

    } //fin metodo eliminarReservacion

    public void mostrarDatos() {
        if (listaSVacia() == true) {
            System.out.println("La lista está vacía");
            System.out.println("___________________");
        } else {
            ReservacionesNodoSimple auxiliar = primero; //se crea nodo auxiliar para recorrer los datos y mostrarlos
            String Ubicacion1 = "";
            if (auxiliar.Ubicacion == 1) {
                Ubicacion1 = "VIP";
            } else if (auxiliar.Ubicacion == 2) {
                Ubicacion1 = "Preferencial";
            } else {
                Ubicacion1 = "General";
            }
            while (auxiliar != null) {
                String mensaje = "Cedula: " + auxiliar.cedula + " Ubicacion: " + Ubicacion1 + " Evento: " + auxiliar.nombreEvento;//mostrar nombre de ubicacion
                System.out.print(mensaje + " -> ");
                auxiliar = auxiliar.siguiente;
            }
            System.out.println("");
        }
    }

}
