public class EnumDemo {
    public static void main(String[] args){

        System.out.println(PowerState.OFF);
        System.out.println(PowerState.OFF.getDescription());
        System.out.println(PowerState.ON);
        System.out.println(PowerState.ON.getDescription());
        System.out.println(PowerState.SUSPEND);
        System.out.println(PowerState.SUSPEND.getDescription());
    }

}
