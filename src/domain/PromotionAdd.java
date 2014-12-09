package domain;

import java.util.*;

/**
 * Created by Administrator on 2014/12/8.
 */
public class PromotionAdd {

    private HashMap<String, List<Promotion>> promotionmap = new HashMap<String, List<Promotion>>();

    public Items calculate(Items item) {
        Items promotionitem = item;
        if (promotionmap.containsKey(item.getItem().getBarcode())) {
            Iterator<Promotion> it = promotionmap.get(item.getItem().getBarcode()).iterator();
            while (it.hasNext()) {
                Promotion promotion = it.next();
                promotionitem = promotion.calculate(promotionitem);
            }
        }
        return promotionitem;
    }

    public void add(Parser parser, String path) {
        try {
            List<Map<String, Promotion>> promotionList = parser.parse(path);
            Iterator<Map<String, Promotion>> it = promotionList.iterator();

            while (it.hasNext()) {
                Map<String, Promotion> map = it.next();

                Iterator iter = map.entrySet().iterator();
                Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iter.next();

                String barcode = entry.getKey();
                Promotion promotion = map.get(entry.getKey());
                List<Promotion> proList = null;
                if (promotionmap.containsKey(barcode)) {
                    proList = promotionmap.get(barcode);
                } else {
                    proList = new LinkedList<Promotion>();
                }
                proList.add(promotion);
                promotionmap.put(barcode, proList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
