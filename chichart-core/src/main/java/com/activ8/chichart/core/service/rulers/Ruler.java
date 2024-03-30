package com.activ8.chichart.core.service.rulers;

public enum Ruler {
    FOUNDATION(1),
    NULLIFY(2),
    ABUNDANT(3),
    BALANCE(4),
    STABILITY(5),
    INITIATE(6),
    CESSATION(7),
    UNPREDICTABLE(8),
    SUCCESS(9),
    RECEIVE(10),
    ACCESSIBLE(11),
    INSIGHTFUL(12);

    private int order;

    Ruler(int order) {
        this.order = order;
    }

    public static Ruler fromOrder(int order) {

        for (Ruler ruler : Ruler.values()) {
            if (ruler.getOrder() == order) {
                return ruler;
            }
        }
        throw new IllegalArgumentException(String.format("Unknown order %d for Ruler", order));
    }

    public int getOrder() {
        return order;
    }
}
