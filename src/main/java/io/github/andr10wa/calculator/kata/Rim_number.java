package io.github.andr10wa.calculator.kata;

public enum Rim_number {
    X("10"),
    XX("20"),
    XXX("30"),
    XL("40"),
    L("50"),
    LX("60"),
    LXX("70"),
    LXXX("80"),
    XC("90"),
    C("100");
    private String arabic;

    Rim_number(String arabic) {
        this.arabic = arabic;
    }

    public static Rim_number findByName(String name) {
        Rim_number result = null;

        for (Rim_number rim_number : values()) {
            if (rim_number.arabic.equalsIgnoreCase(name)) {
                result = rim_number;
                break;
            }
        }
        return result;

    }
}


