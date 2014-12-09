package parser;

import domain.Parser;
import promotions.SecondHalfPromotion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/11/23.
 */
public class SecondHalfParser extends Parser<Map<String, SecondHalfPromotion>> {
    @Override
    public Map<String, SecondHalfPromotion> convert(String line) {

        Map<String, SecondHalfPromotion> map = new HashMap<String, SecondHalfPromotion>();
        map.put(line.split(":")[0], new SecondHalfPromotion(line.split(":")[0]));
        return map;
    }

}
