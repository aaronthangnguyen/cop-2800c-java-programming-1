package com.valencia;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Forecast {
    private final double DEFAULT_TEMPERATURE = 72;
    private final String DEFAULT_SKY_CONDITION = "clear";
    private final int DEFAULT_CHANCE_OF_RAIN = 0;
    private final String RESULT_FILE = "forecast_result.txt";

    private double temperature;
    private String skyCondition;
    private int chanceOfRain;

    public Forecast(double temperature, String skyCondition, int chanceOfRain) {
        setTemperature(temperature);
        setSkyCondition(skyCondition);
        setChanceOfRain(chanceOfRain);
    }

    public Forecast() {
        setTemperature();
        setSkyCondition();
        setChanceOfRain();
    }

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * ((double) 5 / 9);
    }

    public static double convertCelsiusToFahrenheit(double celcius) {
        return celcius * ((double) 9 / 5) + 32;
    }

    public static double convertFahrenheitToKelvin(double fahrenheit) {
        return convertFahrenheitToCelsius(fahrenheit) + 273;
    }

    public static double convertKelvinToFahrenheit(double kelvin) {
        return convertCelsiusToFahrenheit(kelvin - 273);
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if (temperature >= -100 && temperature <= 150) {
            this.temperature = temperature;
        } else {
            setTemperature();
        }
    }

    public void setTemperature() {
        this.temperature = DEFAULT_TEMPERATURE;
    }

    public String getSkyCondition() {
        return skyCondition;
    }

    public void setSkyCondition(String skyCondition) {
        this.skyCondition = skyCondition;
    }

    public void setSkyCondition() {
        this.skyCondition = DEFAULT_SKY_CONDITION;
    }

    public int getChanceOfRain() {
        return chanceOfRain;
    }

    public void setChanceOfRain(int chanceOfRain) {
        if (chanceOfRain >= 0 && chanceOfRain <= 100) {
            this.chanceOfRain = chanceOfRain;
        } else {
            setChanceOfRain();
        }
    }

    public void setChanceOfRain() {
        this.chanceOfRain = DEFAULT_CHANCE_OF_RAIN;
    }

    public boolean isRaining() {
        return skyCondition.equals("raining");
    }

    public void print() {
        System.out.printf("Temperature: %.2f °F\n", temperature);
        System.out.printf("Sky condition: %s\n", skyCondition);
        System.out.printf("Chance of rain: %d%%\n", chanceOfRain);
    }

    public void printToFile() {
        try (FileWriter writer = new FileWriter(RESULT_FILE)) {
            writer.write(String.format("Temperature: %.2f °F", temperature));
            writer.write(System.getProperty("line.separator"));
            writer.write("Sky condition: " + skyCondition);
            writer.write(System.getProperty("line.separator"));
            writer.write("Chance of rain: " + chanceOfRain + "%");
            writer.write(System.getProperty("line.separator"));
            writer.flush();
        } catch (FileNotFoundException exc) {
            System.out.println("FileNotFoundException" + exc.getMessage());
        } catch (IOException exc) {
            System.out.println("IOException: " + exc.getMessage());
        } catch (Exception exc) {
            System.out.println("Exception: " + exc.getMessage());
        }
    }
}
