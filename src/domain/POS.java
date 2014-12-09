package domain;

import parser.DiscountParser;
import parser.ReachOffParser;
import parser.SecondHalfParser;

import java.io.IOException;

/**
 * Created by Administrator on 2014/12/8.
 */
public class POS {

    public static void main(String[] args) throws IOException {
        ItemMap itemList = new ItemMap();
        itemList.getItemMap();

        CartMap cartMap = new CartMap(itemList);
        cartMap.setCartMap();

        String discountPath = "./src/properties/discount_promotion.txt";
        String secondHalfPath = "./src/properties/second_half_price_promotion.txt";
        String reachOffPath = "./src/properties/reach_off_promotion.txt";

        PromotionAdd promotionAdd = new PromotionAdd();
        try {
            promotionAdd.add(new DiscountParser(), discountPath);
            promotionAdd.add(new SecondHalfParser(), secondHalfPath);
            promotionAdd.add(new ReachOffParser(), reachOffPath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Printer printer = new Printer();
        printer.Print(promotionAdd, cartMap);
    }
}
