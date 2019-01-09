package enums;

public enum WeaponsType {
    ROCKETS,
    LASERS,
    ROCKETS_AND_LASERS;

    @Override
    public String toString() {
        switch (this) {
            case ROCKETS:
                return "Rockets";
            case LASERS:
                return "Lasers";
            case ROCKETS_AND_LASERS:
                return "Rockets and lasers";
            default:
                throw new IllegalArgumentException();
        }
    }
}
