package ru.practicum.menu;

public enum ActionOrder {
    ACTION1, ACTION2, ACTION3, ACTION4;

    public static ActionOrder from(String order) {
        switch (order.toUpperCase()) {
            case "1":
                return ACTION1;
            case "2":
                return ACTION2;
            case "3":
                return ACTION3;
            case "4":
                return ACTION4;
            default:
                return null;
        }
    }
}
