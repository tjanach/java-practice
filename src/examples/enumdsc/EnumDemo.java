package examples.enumdsc;

public class EnumDemo {
    public static void main(String[] args){

        System.out.println(EnumStateWithDescription.OFF);
        System.out.println(EnumStateWithDescription.OFF.getDescription());
        System.out.println(EnumStateWithDescription.ON);
        System.out.println(EnumStateWithDescription.ON.getDescription());
        System.out.println(EnumStateWithDescription.SUSPEND);
        System.out.println(EnumStateWithDescription.SUSPEND.getDescription());
    }

}
