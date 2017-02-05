package com.damyan.service;

import com.damyan.pojo.Item;
import com.damyan.pojo.Type;
import com.damyan.pojo.Warmth;

import java.math.BigDecimal;
import java.util.List;

public class BillService {

    public Double produceBill(List<Item> items) {
        Double itemTotal =items.stream().map(Item::getPrice).mapToDouble(Double::new).sum();
        boolean hasFood = items.stream().map(Item::getType).filter(Type.FOOD::equals).findFirst().isPresent();

        if (hasFood) {
            itemTotal = itemTotal + BigDecimal.valueOf(itemTotal/10).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            boolean hasHotFood = items.stream().map(Item::getWarmth).filter(Warmth.HOT::equals).findFirst().isPresent();

            if (hasHotFood) {
                Double hotServiceCharge = itemTotal/5;
                if (hotServiceCharge < 20) {
                    itemTotal = itemTotal + hotServiceCharge;
                } else {
                    itemTotal = itemTotal + 20;
                }
            }
        }
        return itemTotal;
    }
}
