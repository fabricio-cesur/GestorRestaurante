public class Dish {

    public String code;
    public String name;
    public float price;
    
    //Builder
    public Dish(String cod, String nam, float pri) {
        this.code = cod;
        this.name = nam;
        this.price = pri;
    }

    public String getCod() { return code; }
    public String getNam() { return name; }
    public float getPri() { return price; }
}

