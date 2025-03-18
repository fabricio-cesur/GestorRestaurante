public class Plato {

    public String codigo;
    public String nombre;
    public double precio;
    
    public Plato(String cod, String nam, double pri) {
        this.codigo = cod;
        this.nombre = nam;
        this.precio = pri;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}

