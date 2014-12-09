package domain;

import parser.CartParser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/8.
 */
public class CartMap {
    private Map<String, Items> cartMap = new HashMap<String, Items>();
    private ItemMap list = null;

    public CartMap(ItemMap list) {
        this.list = list;
    }

    String cartParserPath = "./src/properties/cart.txt";

    public void setCartMap() {
        try {
            List<Items> itemList = new CartParser().parse(cartParserPath);
            Iterator<Items> it = itemList.iterator();
            while (it.hasNext()) {
                Items item = it.next();
                Items existItem = cartMap.get(item.getItem().getBarcode());

                int newNumber = item.getNumber() + (existItem == null ? 0 : existItem.getNumber());
                double price = list.getItem(item.getItem().getBarcode()).getPrice();

                Items newItem = new Items(item.getItem().getBarcode(), price, newNumber);
                cartMap.put(item.getItem().getBarcode(), newItem);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

  public Map<String, Items> getCartMap() {return cartMap;}
}
