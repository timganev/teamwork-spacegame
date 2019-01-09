package enums;

public enum PropulsionType {
    SAIL,
    NUKES,
    FUSION_ENGINE,
    ANTIMMATER;


    @Override
    public String toString() {
        switch (this) {
            case SAIL:
                return "Sail";
            case NUKES:
                return "Nukes";
            case FUSION_ENGINE:
                return "Fusion Engine";
            case ANTIMMATER:
                return "Antimatter";
            default:
                throw new IllegalArgumentException();
        }
    }

}
