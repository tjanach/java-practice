package lambda.demos;

import model.Person;
import model.PersonListCreator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class LambdaCollector {

    public static void main(String[] args){
        List<Person> pList = PersonListCreator.getList();
        pList.add(new Person.PersonBuilder().setId(6).setName("Joan Fogel").setAge(25).build());
        pList.add(new Person.PersonBuilder().setId(7).setName("Joan Oldest").setAge(75).build());
        pList.add(new Person.PersonBuilder().setId(8).setName("Alan Bismarck").setAge(25).build());

        System.out.println("-- initial list --");
        pList.forEach(p -> System.out.println(p.toString()));

        System.out.println("-- under 40 new list --");
        List<Person> youngList = pList.stream()
                .filter(p -> p.getAge()<40)
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        youngList
                .forEach(p -> System.out.println(p.toString()));

        String names = youngList.stream()
                .map(Person ::getName)
//                .map(p -> p.getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println("-- names list of under 40 --: "+names);
    }
}
