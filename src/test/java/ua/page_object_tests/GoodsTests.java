package ua.page_object_tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GoodsTests extends TestBase {

    @Test
    public void deleteGoodsFromBagTest() {
        app.addGoodsToBag(3);
        app.goToCheckout();
        app.deleteAllGoodsFromBag();
        assertTrue(app.getEmptyBagMessage().equals("There are no items in your cart."));
    }
}
