package org.example.parts;


public class MenuValidator implements Validator {

    @Override
    public boolean isValid(Number input) {
        int menuItem = input.intValue();
        return menuItem >= 0 && menuItem <= 5;
    }
}
