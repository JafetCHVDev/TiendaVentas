package boleteriaCompra;

import boleteriaReservaciones.ReservacionesListaSimple;
import boleteriaReservaciones.ReservacionesNodoSimple;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ComprasListaCircular {

    ComprasNodoCircular primero;

    public ComprasListaCircular() {
        this.primero = null;
    }

    //metodo validar si esta vacia
    public boolean estaVacia() {
        boolean vacia;
        if (primero == null) {
            vacia = true;
        } else {
            vacia = false;
        }
        return vacia;
    } //fin metodo esta vacia


    
    //metodo agregar compras
    public void Agregar(int pcedula, int pUbicacion, String pnombreEvento) {
        int costo = 0;
        if(pUbicacion==1){//1 VIP 2 PREFERENCIAL 3 GENERAL
            costo = 30000;
        } else if(pUbicacion==2){
            costo = 20000;
        } else{
            costo = 10000;
        }
        ComprasNodoCircular nuevonodo = new ComprasNodoCircular(pnombreEvento, pcedula, pUbicacion, costo);
        if (primero == null) {
            primero = nuevonodo;
            nuevonodo.siguiente = primero;
            System.out.println("Compra realizada. ");
            System.out.println("__________________");
        } else {
            ComprasNodoCircular auxiliar = primero;
            while (auxiliar.siguiente != primero) {
                auxiliar = auxiliar.siguiente;
            }
            auxiliar.siguiente = nuevonodo;
            nuevonodo.siguiente = primero;
            primero = nuevonodo;
            System.out.println("Compra realizada. ");
            System.out.println("__________________");
        }
    }//fin metodo agregar lista circular
    
    //metodo mostrar lista de compras
    public void mostrarGanancias() {
        ComprasNodoCircular actual;
        int ganancias=0;
        String ubicacion1;
        if(estaVacia() == true){
            System.out.println("No hay compras aún");
        } else{
            actual = primero;
            System.out.println("Ganancias obtenidas: ");
            
            do {
                if(actual.Ubicacion==1){
                ubicacion1 = "VIP";
            } else if(actual.Ubicacion == 2){
                ubicacion1 = "Preferencial";
            } else {
                ubicacion1 = "General";
            }
                String mensaje = "Cedula: " + actual.cedula + " Evento: " + actual.nombreEvento + " Ubicacion: " + ubicacion1 + " Costo: " + actual.costo + " \n";
                System.out.println("-->" + mensaje);
                ganancias = ganancias + actual.costo;
                actual = actual.siguiente;
            } while (actual != primero);
            System.out.println("El total de ganancias es de " + ganancias);
        }
    }
    

}
