package GuitarCenter.GuitarCenter.model;

public enum GuitarType {

    ACOUSTIC, ELECTRIC, CLASSICAL;
    public static String getType(GuitarType type){
        return switch(type){
            case ACOUSTIC -> "ACOUSTIC";
            case ELECTRIC -> "ELECTRIC";
            case CLASSICAL -> "CLASSICAL";
        };
    }
    public static GuitarType getType(String type){
        return switch(type){
            case "ACOUSTIC" -> ACOUSTIC;
            case "ELECTRIC" -> ELECTRIC;
            case "CLASSICAL" -> CLASSICAL;
            default -> null ;
        };
    }
}
