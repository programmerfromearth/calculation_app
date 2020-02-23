package org.example.parts;

import org.example.domain.Goods;
import org.example.domain.Rate;
import org.example.parts.Calculator;

public class StandartCalculator implements Calculator {
    private Goods goods;
    private Rate rate;

    public StandartCalculator(Goods goods, Rate rate) {
        this.goods = goods;
        this.rate = rate;
    }

    @Override
    public double calculatePrice() {
        double priceForDistance = goods.getDistance() * rate.getPriceForDistance();
        double priceForWeight = goods.getWeight() * rate.getPriceForWeight();
        return priceForDistance + priceForWeight;
    }
}
