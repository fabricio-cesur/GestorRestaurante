public class Table {

    public int number;
    public int capacity;
    
    //Builder
    public Table(int num, int cap) {
        this.number = num;
        this.capacity = cap;
    }

    public int getNum() { return number; }
    public int getCap() { return capacity; }
}

