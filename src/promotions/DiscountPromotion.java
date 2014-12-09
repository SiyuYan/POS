package promotions;

import domain.Items;
import domain.Promotion;

/**
 * Created by Administrator on 2014/12/7.
 */
public class DiscountPromotion implements Promotion {
    private double rate;

   public DiscountPromotion(double rate) {this.rate = rate;}

    public double getRate() {
        return rate;
    }

    @Override
    public Items calculate(Items item) {
        return new Items(item.getItem().getBarcode(), item.getItem().getPrice() * rate / 100, item.getNumber());
    }
}
