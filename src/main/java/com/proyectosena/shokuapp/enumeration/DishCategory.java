package com.proyectosena.shokuapp.enumeration;

public enum DishCategory {

    SUSHI("SUSHI"),
    RAMEN("RAMEN"),
    SALAD("SALAD"),
    CHICKENWINGS("CHICKENWINGS"),
    DESSERT("DESSERT");



    private String value;

    DishCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DishCategory fromId(String id) {
        for (DishCategory dishCategory : DishCategory.values()) {
            if (dishCategory.getValue().equals(id)) {
                return dishCategory;
            }
        }
        return null;
    }

    public static DishCategory fromString(String text) {
        for (DishCategory dishCategory : DishCategory.values()) {
            if (dishCategory.name().equalsIgnoreCase(text)) {
                return dishCategory;
            }
        }
        return null;
    }
}
