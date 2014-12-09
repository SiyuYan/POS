package domain;

import parser.ItemParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/7.
 */
public class ItemMap {
    private Map<String, Item> itemMap = new HashMap<String, Item>();

    public Item getItem(String barcode) {
        return itemMap.get(barcode);
    }

    String itemParserPath = "src/properties/item.txt";

    public void getItemMap() throws IOException {
        try {
            List<Item> list = new ItemParser().parse(itemParserPath);
            Iterator<Item> it = list.iterator();
            while (it.hasNext()) {
                Item item = it.next();
                itemMap.put(item.getBarcode(), item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
