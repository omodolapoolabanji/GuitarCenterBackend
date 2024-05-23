package GuitarCenter.GuitarCenter.model;

public enum Brand {

    FENDER, TAYLOR, YAMAHA,GIBSON, PRS, IBANEZ, MARTIN, EPIPHONE, GRETSCH, JACKSON, SCHECTER, ESPLTD, CORT, KREMONA, DEAN;
    public static String getType(Brand brand){
        return switch(brand){
            case FENDER -> "FENDER";
            case TAYLOR -> "TAYLOR";
            case YAMAHA -> "YAMAHA";
            case KREMONA -> "KREMONA";
            case GIBSON -> "GIBSON";
            case PRS    -> "PRS";
            case IBANEZ -> "IBANEZ";
            case MARTIN -> "MARTIN";
            case EPIPHONE -> "EPIPHONE";
            case GRETSCH -> "GRETSCH";
            case JACKSON -> "JACKSON";
            case SCHECTER -> "SCHECTER";
            case ESPLTD -> "ESPLTD";
            case CORT   -> "CORT";
            case DEAN -> "DEAN";
        };
    }
    public static Brand getType(String brand){
        return switch(brand){
            case "FENDER" -> FENDER;
            case "TAYLOR" -> TAYLOR;
            case "YAMAHA" -> YAMAHA;
            case "GIBSON" -> GIBSON;
            case "PRS "   -> PRS;
            case "IBANEZ" -> IBANEZ;
            case "MARTIN" -> MARTIN;
            case "EPIPHONE" -> EPIPHONE;
            case "GRETSCH" -> GRETSCH;
            case "JACKSON" -> JACKSON;
            case "SCHECTER" -> SCHECTER;
            case "ESPLTD" -> ESPLTD;
            case "CORT"   -> CORT;
            case "DEAN" -> DEAN;
            case "KREMONA" -> KREMONA;
            default -> null ;
        };
    }
}
