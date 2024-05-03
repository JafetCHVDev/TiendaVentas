
package boleteriaReservaciones;


public class ReservacionesNodoSimple {
    int cedula;
    String nombreEvento;
    int Ubicacion; //1 VIP 2 PREFERENCIAL 3 GENERAL
    
    ReservacionesNodoSimple siguiente;

    public ReservacionesNodoSimple(int cedula, String nombreEvento, int Ubicacion) { //metodo para agregar al final
        this.cedula = cedula;
        this.nombreEvento = nombreEvento;
        this.Ubicacion = Ubicacion;
        this.siguiente = null;
    }

}
