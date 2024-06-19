package common;

public enum Color {

    GREEN("green"),
    RED("red"),
    YELLOW("yellow"),
    BLUE("blue");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
