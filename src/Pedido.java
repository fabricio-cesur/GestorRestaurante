import java.util.LinkedList;

public class Pedido {
    
    //TODO: Agregar un número de ID para los pedidos
    public Mesa mesa;
    public LinkedList<Plato> platos = new LinkedList<>();
    public boolean completado;
    public double total;

    public Pedido(Mesa mes, LinkedList<Plato> pla) {
        this.mesa = mes;
        this.platos = pla;
        this.completado = false;
        this.total = this.calcularTotal();
    }

    public int getNumeroMesa() { return this.mesa.getNumero(); }
    public LinkedList<Plato> getListaPlatos() { return this.platos; }
    public boolean getEstadoCompletado() { return this.completado; }
    public double getPrecioTotal() { return this.total; }
    
    public void cambiarEstado() { this.completado = !this.completado; }
    private double calcularTotal() {
        double precio_resultado = 0;
        for (Plato plato : this.platos) { precio_resultado += plato.getPrecio(); }
        return precio_resultado;
    }
}
