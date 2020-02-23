package org.example.parts;

public class UserInputValidator implements Validator {

    @Override
    public boolean isValid(Number input) {
        double userInput = input.doubleValue();
        return userInput >= 0;
    }
}
