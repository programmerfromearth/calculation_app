package org.example;

import org.example.domain.Goods;
import org.example.domain.Rate;
import org.example.exception.InvalidInputException;
import org.example.parts.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.example.domain.Menu.*;

public class App {
    private Goods goods;
    private Rate rate;
    private Calculator calc;
    private Validator menuValidator;
    private Validator inputValidator;
    private StandartMenu menu;
    private BufferedReader br;

    public App() {
        goods = new Goods();
        rate = new Rate();
        calc = new StandartCalculator(goods, rate);
        menuValidator = new MenuValidator();
        inputValidator = new UserInputValidator();
        menu = new StandartMenu();
        br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        setUpInitialMenu();
    }

    public static void main(String[] args) throws IOException {
        new App().showMenu();
    }

    private void showMenu() throws IOException {
        int menuItem;
        do {
            menu.showItem();
            menuItem = getMenuItem(br);
            processUserInput(menuItem);
        } while (menuItem != EXIT.getNumber());
    }

    private void setUpInitialMenu() {
        menu.setDistancePrice(Double.toString(rate.getPriceForDistance()));
        menu.setWeightPrice(Double.toString(rate.getPriceForWeight()));
    }

    private double getUserInput(BufferedReader br) throws IOException {
        do {
            String input = br.readLine();
            try {
                double doubleInput = Double.parseDouble(input);
                if (!inputValidator.isValid(doubleInput)) {
                    throw new InvalidInputException();
                }
                return doubleInput;
            } catch (InvalidInputException | NumberFormatException e) {
                System.out.println("You have to type a positive double number");
            }
        } while (true);
    }

    private int getMenuItem(BufferedReader br) throws IOException {
        do {
            String input = br.readLine();
            try {
                int intInput = Integer.parseInt(input);
                if (!menuValidator.isValid(intInput)) {
                    throw new InvalidInputException();
                }
                return intInput;
            } catch (InvalidInputException | NumberFormatException e) {
                System.out.println("You have to type number from 1 to 5 or 0 to exit");
                menu.showItem();
            }
        } while (true);

    }

    private void processUserInput(int number) throws IOException {
        switch (number) {
            case 1:
                System.out.println(DISTANCE.getMessage());
                double dist = getUserInput(br);
                goods.setDistance(dist);
                menu.setDistance(Double.toString(dist));
                menu.setCalculate("");
                break;
            case 2:
                System.out.println(DISTANCE_PRICE.getMessage());
                double distPrice = getUserInput(br);
                rate.setPriceForDistance(distPrice);
                menu.setDistancePrice(Double.toString(distPrice));
                menu.setCalculate("");
                break;
            case 3:
                System.out.println(WEIGHT.getMessage());
                double weight = getUserInput(br);
                goods.setWeight(weight);
                menu.setWeight(Double.toString(weight));
                menu.setCalculate("");
                break;
            case 4:
                System.out.println(WEIGHT_PRICE.getMessage());
                double weightPrice = getUserInput(br);
                rate.setPriceForWeight(weightPrice);
                menu.setWeightPrice(Double.toString(weightPrice));
                menu.setCalculate("");
                break;
            case 5:
                double calculate = calc.calculatePrice();
                menu.setCalculate(Double.toString(calculate));
                break;
        }
    }
}

