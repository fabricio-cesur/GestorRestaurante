public class Plato {

    public String codigo;
    public String nombre;
    public double precio;
    
    public Plato(String cod, String nam, double pre) {
        this.codigo = cod;
        this.nombre = nam;
        this.precio = pre;
    }

    public String getCodigo() { return this.codigo; }
    public String getNombre() { return this.nombre; }
    public double getPrecio() { return this.precio; }

    public void setCodigo(String cod) { this.codigo = cod; }
    public void setNombre(String nom) { this.nombre = nom; }
    public void setPrecio(double pre) { this.precio = pre; }
}

