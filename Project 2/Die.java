package com.valencia;

import java.util.Random;

public class Die {
    private int value;
    final int MIN_VALUE = 1;
    final int MAX_VALUE = 6;

    public Die() {
        this.value = generateValidValue();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void roll() {
        int newValue = generateValidValue();
        setValue(newValue);
    }

    private int generateValidValue() {
        return new Random().nextInt(MIN_VALUE, MAX_VALUE + 1);
    }
}
