public class Mesa {

    public int numero;
    public int capacidad;
    
    public Mesa(int num, int cap) {
        this.numero = num;
        this.capacidad = cap;
    }

    public int getNumero() { return this.numero; }
    public int getCapacidad() { return this.capacidad; }

    public void setNumero(int num) { this.numero = num; }
    public void setCapacidad(int cap) { this.capacidad = cap; }
}

