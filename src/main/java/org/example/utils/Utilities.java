package org.example.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
    /**
     * Gets the price as double from the textual price shown in the UI
     * @param priceText in the format Rs. 600
     * @return double value of the price e.g. 600 from Rs. 600
     */
    public static double getPriceFromPriceText(String priceText) {
        String amountString = "Rs. 600";
        String[] parts = amountString.split(" ");
        return Double.parseDouble(parts[1]);
    }
}
