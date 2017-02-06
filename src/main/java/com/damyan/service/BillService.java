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
        Double serviceCharge = 0.0;

        if (hasFood) {
            serviceCharge = BigDecimal.valueOf(itemTotal/10).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            boolean hasHotFood = items.stream().map(Item::getWarmth).filter(Warmth.HOT::equals).findFirst().isPresent();

            if (hasHotFood) {
                serviceCharge += itemTotal/5;
            }
        }

        if (serviceCharge > 20) {
            return itemTotal + 20;
        } else {
            return itemTotal + serviceCharge;
        }
    }
}
