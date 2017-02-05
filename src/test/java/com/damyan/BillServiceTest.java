package com.damyan;

import com.damyan.pojo.Item;
import com.damyan.pojo.Type;
import com.damyan.pojo.Warmth;
import com.damyan.service.BillService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BillServiceTest {
    private BillService billService;

    @Before
    public void init() {
        billService = new BillService();
    }

    @Test
    public void testEnroll() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Cola", Warmth.COLD, Type.BEVARAGE, 2.0));
        items.add(new Item("Coffee", Warmth.HOT, Type.BEVARAGE, 1.0));
        Double result = billService.produceBill(items);
        assertTrue(result != null);
    }
}
