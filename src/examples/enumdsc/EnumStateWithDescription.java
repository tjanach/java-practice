package examples.enumdsc;

public enum EnumStateWithDescription {
    OFF("Power is off"),
    ON("Power is on"),
    SUSPEND("Power usage is low");

    private String description;
    private EnumStateWithDescription(String desc){
        description = desc;
    }

    public String getDescription(){
        return description;
    }
}
