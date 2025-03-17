import java.util.LinkedList;

public class Order {
    
    public int table;
    public LinkedList<String> dishes = new LinkedList<>();
    public String status;
    public float total;

    //Builder
    public Order(int tab, LinkedList<String> dis, String sta, float tot) {
        this.table = tab;
        this.dishes = dis;
        this.status = sta;
        this.total = tot;
    }

    //

}
