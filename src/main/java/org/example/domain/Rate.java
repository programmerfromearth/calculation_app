package org.example.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Rate {
    private final Logger LOG = LoggerFactory.getLogger(Rate.class);

    private double priceForDistance;
    private double priceForWeight;

    public Rate() {
        setProperties();
    }

    private void setProperties() {
        Properties prop = new Properties();

        try(InputStream input = getClass().getClassLoader().getResourceAsStream("rate.properties")) {
            prop.load(input);
            priceForDistance = Double.parseDouble(prop.getProperty("rate.distance"));
            priceForWeight = Double.parseDouble(prop.getProperty("rate.weight"));
        } catch (IOException e) {
            LOG.info("There is no properties file. Properties are not set");
        }
    }

    public double getPriceForDistance() {
        return priceForDistance;
    }

    public void setPriceForDistance(double priceForDistance) {
        this.priceForDistance = priceForDistance;
    }

    public double getPriceForWeight() {
        return priceForWeight;
    }

    public void setPriceForWeight(double priceForWeight) {
        this.priceForWeight = priceForWeight;
    }
}
