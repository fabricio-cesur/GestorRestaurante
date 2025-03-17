import java.util.LinkedList;

public class Pedido {
    
    public int mesa;
    public LinkedList<String> platos = new LinkedList<>();
    public String estado;
    public float total;

    //Builder
    public Pedido(int tab, LinkedList<String> dis, String sta, float tot) {
        this.mesa = tab;
        this.platos = dis;
        this.estado = sta;
        this.total = tot;
    }

    //

}
