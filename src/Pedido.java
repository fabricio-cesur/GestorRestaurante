import java.util.LinkedList;

public class Pedido {
    
    public int id;
    public Mesa mesa;
    public LinkedList<Plato> platos = new LinkedList<>();
    public boolean completado;
    public double total;

    public Pedido(int id, Mesa mes, LinkedList<Plato> pla) {
        this.id = id;
        this.mesa = mes;
        this.platos = pla;
        this.completado = false;
        this.total = this.calcularTotal();
    }

    public int getID() { return this.id; }
    public int getNumeroMesa() { return this.mesa.getNumero(); }
    public LinkedList<Plato> getListaPlatos() { return this.platos; }
    public boolean getEstadoCompletado() { return this.completado; }
    public double getPrecioTotal() { return this.total; }

    public void setID(int id) { this.id = id; }
    public void setNumeroMesa(Mesa mes) { this.mesa = mes; }
    public void setListaPlatos(LinkedList<Plato> pla) { this.platos = pla; }
    public void setEstadoCompletado(boolean com) { this.completado = com; }
    public void setPrecioTotal(double tot) { this.total = tot; }


    
    public void cambiarEstado() { this.completado = !this.completado; }
    private double calcularTotal() {
        double precio_resultado = 0;
        for (Plato plato : this.platos) { precio_resultado += plato.getPrecio(); }
        return precio_resultado;
    }
}
