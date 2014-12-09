package parser;

import domain.Items;
import domain.Parser;

/**
 * Created by Administrator on 2014/11/23.
 */
public class CartParser extends Parser<Items> {
    @Override
    public Items convert(String line) {
        Integer amount = 1;
        if (line.split("-").length > 1) {
            amount = Integer.parseInt(line.split("-")[1]);
        }
        return new Items(line.split("-")[0], 0, amount);
    }


}