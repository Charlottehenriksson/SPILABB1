package Interface.impl;

import Interface.CurrencyConverter;

public class StaticConverter implements CurrencyConverter {

    @Override
    public double convert(double amount, String from, String to) {
        if (from.equals("EURO") && to.equals("SEK")) {
            return amount * 10;
        } else if (from.equals("SEK") && to.equals("EURO")) {
            return amount / 10;
        } else {
            throw new IllegalArgumentException("Invalid currency pair");
        }
    }
}


