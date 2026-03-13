package com.solvd.util;

import java.math.BigDecimal;

public class ParserUtil {

    public static BigDecimal parse(String rawNumber) {
        if (rawNumber == null) {
            throw new IllegalArgumentException("Input is null");
        }
        String value = rawNumber.trim();
        if (!value.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("Input is not a raw number: " + rawNumber);
        }
        return new BigDecimal(value);
    }
}