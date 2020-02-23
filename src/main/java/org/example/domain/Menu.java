package org.example.domain;

public enum Menu {
    DISTANCE(1, "type distance in km: "),
    DISTANCE_PRICE(2, "type price for 1 km: "),
    WEIGHT(3, "type weight of goods in kg: "),
    WEIGHT_PRICE(4, "type price for 1 kg: "),
    CALCULATE(5, "calculation of price for delivering: "),
    EXIT(0, "Exit program");

    private String message;
    private final int number;

    private Menu(int number, String message) {
        this.message = message;
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }
}
