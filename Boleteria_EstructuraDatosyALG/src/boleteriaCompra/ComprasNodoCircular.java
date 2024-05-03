
package boleteriaCompra;


public class ComprasNodoCircular {
    String nombreEvento;
    int cedula;
    int Ubicacion; //1 VIP 2 PREFERENCIAL 3 GENERAL
    int costo;
    ComprasNodoCircular siguiente;
    

    public ComprasNodoCircular(String nombreEvento, int cedula, int Ubicacion, int costo) {
        this.nombreEvento = nombreEvento;
        this.cedula = cedula;
        this.Ubicacion = Ubicacion;
        this.costo = costo;
        this.siguiente = null;
    }
    
    
    
}
