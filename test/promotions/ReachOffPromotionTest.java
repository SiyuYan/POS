package promotions;

import domain.Items;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Administrator on 2014/12/7.
 */
public class ReachOffPromotionTest {
    @Test
    public void should_Off_when_Reach() throws Exception {
        ReachOffPromotion reachOffPromotion = new ReachOffPromotion(300, 30);
        Items item = reachOffPromotion.calculate(new Items("Item0000000001", 300, 1));
        assertEquals(item.getTotal(), new Double(300 - 30));
    }

    @Test
    public void should_not_Off_when_not_Reach() throws Exception {
        ReachOffPromotion reachOffPromotion = new ReachOffPromotion(300, 30);
        Items item = reachOffPromotion.calculate(new Items("Item0000000001", 100, 1));
        assertEquals(item.getTotal(), 100.0);
    }
    @Test
    //TODO:contain is not implement
    public void should__not_Off_when_not_in_Reach() throws Exception {
        ReachOffPromotion reachOffPromotion = new ReachOffPromotion(300, 30);
        Items item = reachOffPromotion.calculate(new Items("Item0000000001", 300, 1));
        assertEquals(item.getTotal(), new Double(300 - 30));
    }

}
