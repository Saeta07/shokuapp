package com.proyectosena.shokuapp.enumeration;

public enum UserRole {
    WAITER("WAITER"),
    ADMIN("ADMIN"),
    MANAGER("MANAGER"),
    CUSTOMER("CUSTOMER");

    private String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UserRole fromId(String id) {
        for (UserRole rol : UserRole.values()) {
            if (rol.getValue().equals(id)) {
                return rol;
            }
        }
        return null;
    }

    public static UserRole fromString(String text) {
        for (UserRole rol : UserRole.values()) {
            if (rol.name().equalsIgnoreCase(text)) {
                return rol;
            }
        }
        return null;
    }
}
