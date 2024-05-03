
package boleteriaClientes;


public class ClientesNodoDoble {
    String nombre;
    int cedula;
    String direccion;
    ClientesNodoDoble siguiente;
    ClientesNodoDoble anterior;

    public ClientesNodoDoble(String nombre, int cedula, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
}
