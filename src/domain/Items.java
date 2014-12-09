package domain;

/**
 * Created by Administrator on 2014/12/8.
 */
public class Items {

    private Item item;
    private int number;
    public Items(String barcode, double price, int number) {
        item = new Item(barcode, price);
        this.number = number;
    }
    public Item getItem() {
        return item;
    }
    public int getNumber() {
        return number;
    }
    public double getTotal() {
        return number * item.getPrice();
    }

}
