package lambda.ex;

import model.Person;
import model.PersonListCreator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class lambdaOptional {

    public static void main(String[] args){
        List<Person> pList = PersonListCreator.getList();
        pList.add(new Person.PersonBuilder().setId(6).setName("Joan Fogel").setAge(25).build());
        pList.add(new Person.PersonBuilder().setId(7).setName("Joan Oldest").setAge(75).build());

        System.out.println("-- initial list --");
        pList.forEach(p -> System.out.println(p.toString()));

        System.out.println("-- select first having 25 years --");
        Optional<Person> p25YearsOld = pList.stream()
                .filter(p -> p.getAge()==25)
                .findFirst();
        if (p25YearsOld.isPresent()){
            System.out.println(p25YearsOld.get().toString());
        }

        System.out.println("-- select any having 25 years --");
        p25YearsOld = pList.stream()
                .filter(p -> p.getAge()==25)
                .findAny();
        if (p25YearsOld.isPresent()){
            System.out.println(p25YearsOld.get().toString());
        }

        System.out.println("-- select any having 24 years --");
        Optional<Person> p24YearsOld = pList.stream()
                .filter(p -> p.getAge()==24)
                .findAny();
        if (p24YearsOld.isPresent()){
            System.out.println(p24YearsOld.get().toString());
        } else {
            System.out.println("-- select any having 24 years: NONE --");
        }

        System.out.println("-- select the oldest --");
        Optional<Person> pOldest = pList.stream()
                .max(Comparator.comparing(Person::getAge));
        if (pOldest.isPresent()){
            System.out.println(pOldest.get().toString());
        } else {
            System.out.println("-- select the oldest: NONE --");
        }

    }
}
