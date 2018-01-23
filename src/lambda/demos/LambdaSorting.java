package lambda.demos;

import model.Person;
import model.PersonListCreator;

import java.util.Comparator;
import java.util.List;


public class LambdaSorting {

    public static void main(String[] args){
        List<Person> pList = PersonListCreator.getList();
        pList.add(new Person.PersonBuilder().setId(6).setName("Joan Fogel").setAge(25).build());
        pList.add(new Person.PersonBuilder().setId(7).setName("Joan Oldest").setAge(75).build());
        pList.add(new Person.PersonBuilder().setId(8).setName("Alan Bismarck").setAge(25).build());

        System.out.println("-- initial list --");
        pList.forEach(p -> System.out.println(p.toString()));

        System.out.println("-- sorted list by age --");
        pList.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(p -> System.out.println(p.toString()));

        System.out.println("-- sorted list by age and name reversed--");
        pList.stream()
                .sorted(
                        Comparator.comparing(Person::getAge)
                                .reversed()
                                .thenComparing(Person::getName)
                                )
                .forEach(p -> System.out.println(p.toString()));
    }
}
