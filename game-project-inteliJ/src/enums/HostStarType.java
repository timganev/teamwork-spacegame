package enums;

public enum HostStarType {

    GIANT,
    BLUE,
    YELLOW,
    WHITE;

    @Override
    public String toString() {
        switch (this) {
            case GIANT:
                return "Giants";
            case BLUE:
                return "Blue";
            case YELLOW:
                return "Yellow";
            case WHITE:
                return "White";
            default:
                throw new IllegalArgumentException();
        }
    }


}
