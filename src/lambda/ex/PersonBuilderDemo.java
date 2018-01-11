package lambda.ex;

public class PersonBuilderDemo {
    public static void main(String[] args){

        Person p1 = new Person.Builder()
                .setId(1)
                .setName("Carl Mion")
                .setAge(10)
                .build();
        Person p2 = new Person.Builder()
                .setId(2)
                .setName("Mickey Brown")
                .setAge(11)
                .build();
        Person p3 = new Person.Builder()
                .setId(2)
                .setName("Carl Gustaw")
                .setAge(81)
                .build();

        System.out.println(p1.getId()+" "+p1.getName()+" "+p1.getAge());
        System.out.println(p2.getId()+" "+p2.getName()+" "+p2.getAge());
        System.out.println(p3.getId()+" "+p3.getName()+" "+p3.getAge());
    }
}
