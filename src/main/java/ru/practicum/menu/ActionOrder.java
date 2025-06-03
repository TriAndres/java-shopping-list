package ru.practicum.menu;

public enum ActionOrder {
    ACTION1, ACTION2, ACTION3, ACTION4, ACTION5, ACTION6, ACTION7;

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
            case "5":
                return ACTION5;
            case "6":
                return ACTION6;
            case "7":
                return ACTION7;
            default:
                return null;
        }
    }
}
