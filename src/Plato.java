public class Plato {

    public String codigo;
    public String nombre;
    public float precio;
    
    //Builder
    public Plato(String cod, String nam, float pri) {
        this.codigo = cod;
        this.nombre = nam;
        this.precio = pri;
    }

    public String getCod() { return codigo; }
    public String getNam() { return nombre; }
    public float getPri() { return precio; }
}

