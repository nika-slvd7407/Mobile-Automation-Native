package com.solvd.carinanative.page.pageenum;

public enum SortType {

    NAME_ASC(true, "Name (A to Z)"),
    NAME_DESC(false, "Name (Z to A)"),
    PRICE_LOW_TO_HIGH(true, "Price (low to high)"),
    PRICE_HIGH_TO_LOW(false, "Price (high to low)");

    private final boolean ascending;
    private final String label;

    SortType(boolean ascending, String label) {
        this.ascending = ascending;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isAscending() {
        return ascending;
    }
}