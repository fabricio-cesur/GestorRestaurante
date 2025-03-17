public class Mesa {

    public int numero;
    public int capacidad;
    
    //Builder
    public Mesa(int num, int cap) {
        this.numero = num;
        this.capacidad = cap;
    }

    public int getNum() { return numero; }
    public int getCap() { return capacidad; }
}

