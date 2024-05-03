package boleteriaClientes;

import java.util.Scanner;

public class ClientesListaDoble {

    ClientesNodoDoble primero;
    ClientesNodoDoble ultimo;

    public ClientesListaDoble() { //creamos punteros primero y ultimo
        this.primero = null;
        this.ultimo = null;
    }

    public boolean listaVacia() { //metodo para revisar si la lista está vacía
        boolean estaVacia;
        if (primero == null) {
            estaVacia = true;
        } else {
            estaVacia = false;
        }
        return estaVacia;
    }

    //metodo agregar al final
    public void Agregar_Final() {
        Scanner teclado = new Scanner(System.in);
        boolean datosvalidos = false;
        String nombre = "";
        int cedula = 0;
        String direccion = "";
        while (!datosvalidos) {
            try {
                System.out.print("Digite el nombre del cliente: ");
                nombre = teclado.nextLine();
                System.out.print("Digite la cedula del cliente: ");
                cedula = teclado.nextInt();
                teclado.nextLine();
                System.out.print("Digite la dirección del cliente: ");
                direccion = teclado.nextLine();
                datosvalidos = true;
            } catch (Exception e) {
                System.out.println("Error: Ingrese una opcion valida");
                teclado.nextLine();
                datosvalidos = false;
            }
        }
        ClientesNodoDoble nuevonodo = new ClientesNodoDoble(nombre, cedula, direccion);
        if (primero == null) {
            primero = nuevonodo;
            ultimo = nuevonodo;
            System.out.println("Cliente registrado. ");
            System.out.println("_____________________");
        } else {
            ClientesNodoDoble auxiliar = primero;
            while (auxiliar.siguiente != null) {
                auxiliar = auxiliar.siguiente;
            }
            nuevonodo.anterior = auxiliar;
            auxiliar.siguiente = nuevonodo;
            ultimo = nuevonodo;
            System.out.println("Cliente registrado. ");
            System.out.println("_____________________");
        }
    }

    //metodo eliminar cliente
    public void eliminarCliente() {
        Scanner teclado = new Scanner(System.in);
        ClientesNodoDoble auxiliar = primero;
        boolean datosvalidos = false;
        if (listaVacia() == true) {
            System.out.println("No hay clientes registrados aún");
            System.out.println("___________________");
        } else {
            int cedulaEliminar = 0;
            while (!datosvalidos) {
                try {
                    System.out.print("Digite la cedula del cliente a eliminar: ");//pedir cedula
                    cedulaEliminar = teclado.nextInt();
                    datosvalidos = true;
                } catch (Exception e) {
                    System.out.println("Error: Ingrese una opcion valida");
                    teclado.nextLine();
                    datosvalidos = false;
                }
            }
            if (cedulaEliminar == primero.cedula) { //revisar si el elemento a mover es el primero, para mover el puntero
                if(primero.siguiente == null){
                    primero = null;
                } else {
                    primero.siguiente.anterior = null;
                primero = primero.siguiente;
                System.out.println("El cliente con la cedula  " + cedulaEliminar + " ha sido eliminado.");
                }
            } else if (cedulaEliminar == ultimo.cedula) { //revisar si el elemento a mover es el ultimo, para mover el puntero
                ultimo.anterior.siguiente = null;
                ultimo = ultimo.anterior;
                System.out.println("El cliente con la cedula " + cedulaEliminar + " ha sido eliminada.");
            } else { //buscar elemento
                while (auxiliar.siguiente != null && auxiliar.siguiente.cedula != cedulaEliminar) {
                    auxiliar = auxiliar.siguiente;
                }
                if (auxiliar.siguiente == null) {
                    System.out.println("No hay clientes con ese numero de cédula.");
                    System.out.println("__________________________");
                } else {
                    auxiliar.siguiente = auxiliar.siguiente.siguiente;
                    auxiliar.siguiente.anterior = auxiliar;
                    System.out.println("El cliente con la cedula " + cedulaEliminar + " ha sido eliminado.");
                }

            }
        }

    }

    //metodo modificar(solo direccion)
    public void modificarDireccion() {
        Scanner teclado = new Scanner(System.in);
        ClientesNodoDoble auxiliar = primero;
        boolean datosvalidos = false;
        if (listaVacia() == true) {
            System.out.println("No hay clientes registrados aún");
            System.out.println("___________________");
        } else {
            int cedulaBuscar = 0;
            String nuevaDireccion = "";
            while (!datosvalidos) {
                try {
                    System.out.print("Digite la cedula de la persona a la que desea modificarle la direccion: ");//pedir cedula
                    cedulaBuscar = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Digite la nueva direccion: ");//pedir cedula
                    nuevaDireccion = teclado.nextLine();
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
                auxiliar.direccion = nuevaDireccion;
                System.out.println("La direccion ha sido modificada. ");

            } else {
                System.out.println("No hay cliente con ese numero de cédula.");
                System.out.println("__________________________");
            }
        }
    }

    public void mostrarDatos() {
        if (listaVacia() == true) {
            System.out.println("La lista está vacía");
            System.out.println("___________________");
        } else {
            ClientesNodoDoble auxiliar = primero; //se crea nodo auxiliar para recorrer los datos y mostrarlos
            System.out.println("Lista de clientes registrados: ");
            while (auxiliar != null) {
                String mensaje = "Nombre: " + auxiliar.nombre + " Cedula: " + auxiliar.cedula + " Direccion: " + auxiliar.direccion;
                System.out.print("<-" + mensaje + " -> \n");
                auxiliar = auxiliar.siguiente;
            }
            System.out.println("");
        }
    }
}
