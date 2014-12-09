package promotions;

import domain.Items;
import domain.Promotion;

/**
 * Created by Administrator on 2014/12/7.
 */
public class SecondHalfPromotion implements Promotion {
    private String barcode;

    public SecondHalfPromotion(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public Items calculate(Items item) {
        if (item.getNumber() >= 2) {
            int halfnumber = item.getNumber() / 2;
            double halfprice = item.getItem().getPrice() / 2;
            double total = halfprice * halfnumber + (item.getNumber() - halfnumber) * item.getItem().getPrice();
            return new Items(item.getItem().getBarcode(), total / item.getNumber(), item.getNumber());
        } else
            return item;
    }
}
