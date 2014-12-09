package parser;

import org.junit.Test;
import promotions.DiscountPromotion;

import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2014/12/7.
 */
public class DiscountParserTest {
    @Test
    public void should_parse_when_give_the_item_data() throws Exception {

        DiscountParser discountParser = new DiscountParser();
        //    BufferedReader reader = mock(BufferedReader.class);
        //   Mockito.when(reader.readLine()).thenReturn("ITEM000001:75").thenReturn("-1");

        //   List<Map<String, DiscountPromotion>> list = discountParser.parse(reader);

        Map<String, DiscountPromotion> map = discountParser.convert("ITEM000001:75");
        Iterator it = map.entrySet().iterator();
        Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
        assertThat(entry.getKey(), is("ITEM000001"));
        assertThat(map.get(entry.getKey()).getRate(), is(75d));


        // assertThat(list.get(0).getKey(), is("ITEM000001"));
        //   assertThat(map.get(entry.getKey()).getRate(), is(75d));

    }

}
