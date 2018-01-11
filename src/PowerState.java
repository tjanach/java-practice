public enum PowerState {
    OFF("Power is off"),
    ON("Power is on"),
    SUSPEND("Power usage is low");

    private String description;
    private PowerState(String desc){
        description = desc;
    }

    public String getDescription(){
        return description;
    }
}
