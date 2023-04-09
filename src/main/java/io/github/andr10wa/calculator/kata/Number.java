package io.github.andr10wa.calculator.kata;

public enum Number {
    I("1"),
    II("2"),
    III("3"),
    IV("4"),
    V("5"),
    VI("6"),
    VII("7"),
    VIII("8"),
    IX("9"),
    X("10")
    ;
    private String arabic;
    Number(String arabic){
        this.arabic = arabic;
    }
    public String getArabic(){
        return arabic;
    }
    public static boolean isArabic(String expected) {
        for (Number number : values()) {
            if (number.arabic.equals(expected)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isRim(String expected) {
        for (Number number : values()) {
            if (number.name().equals(expected)) {
                return true;
            }
        }
        return false;
    }
    public static Number findByName(String name) {
        Number result = null;

        for (Number number: values()) {
            if (number.arabic.equalsIgnoreCase(name)) {
                result = number;
                break;
            }
        }
        return result;
    }

}
