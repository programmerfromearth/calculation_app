package org.example.parts;

import org.example.domain.Menu;
import org.example.parts.MenuItem;

public class StandartMenu implements MenuItem {
    private String distance = "";
    private String distancePrice = "";
    private String weight = "";
    private String weightPrice = "";
    private String calculate = "";

    @Override
    public void showItem() {
        showCurrentItem(Menu.DISTANCE, distance);
        showCurrentItem(Menu.DISTANCE_PRICE, distancePrice);
        showCurrentItem(Menu.WEIGHT, weight);
        showCurrentItem(Menu.WEIGHT_PRICE, weightPrice);
        showCurrentItem(Menu.CALCULATE, calculate);
        showCurrentItem(Menu.EXIT, "");
    }

    public void showCurrentItem(Menu menu, String count) {
        System.out.println(String.format("%d. %s: %s", menu.getNumber(), menu, count));
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setDistancePrice(String distancePrice) {
        this.distancePrice = distancePrice;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setWeightPrice(String weightPrice) {
        this.weightPrice = weightPrice;
    }

    public void setCalculate(String calculate) {
        this.calculate = calculate;
    }
}
