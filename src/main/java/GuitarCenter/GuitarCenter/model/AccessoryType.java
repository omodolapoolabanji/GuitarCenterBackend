package GuitarCenter.GuitarCenter.model;

public enum AccessoryType {
    PICKS, STRAPS, CASES, CABLES,STRINGS, STANDS, RACKS;

    public String getAccessoryType(AccessoryType type){
        return switch(type){
            case PICKS -> "PICKS";
            case STRAPS -> "STRAPS";
            case CASES -> "CASES";
            case CABLES -> "CABLES";
            case STRINGS-> "STRINGS";
            case STANDS -> "STANDS";
            case RACKS -> "RACKS";
        };
    }

    public AccessoryType getAccessoryType(String type){
        return switch(type){
            case "PICKS" -> PICKS;
            case "STRAPS" -> STRAPS;
            case "CASES" -> CASES;
            case "CABLES" -> CABLES;
            case "STRINGS" -> STRINGS;
            case "STANDS" -> STANDS;
            case "RACKS" -> RACKS;
            default -> null;
        };
    }
}
