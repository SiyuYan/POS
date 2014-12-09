package parser;

import domain.Item;
import domain.Parser;

/**
 * Created by Administrator on 2014/11/23.
 */
public class ItemParser extends Parser {

    @Override
    public Item convert(String line) {
        return new Item(line.split(":")[0], Double.parseDouble(line.split(":")[1]));
    }
}