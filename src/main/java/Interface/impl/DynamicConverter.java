package Interface.impl;

import Interface.CurrencyConverter;

public class DynamicConverter implements CurrencyConverter {

    @Override
    public double convert(double amount, String from, String to) {
        if (from.equals("EURO") && to.equals("SEK")) {
            double rate = Math.random() * (12 - 8) + 8;
            return amount * rate;
        } else if (from.equals("SEK") && to.equals("EURO")) {
            double rate = Math.random() * (12 - 8) + 8;
            return amount / rate;
        } else {
            throw new IllegalArgumentException("Invalid currency pair");

        }

    }

}
