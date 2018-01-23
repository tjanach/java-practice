package lambda.demos;

import model.Person;
import model.PersonListCreator;

import java.util.List;
import java.util.function.Predicate;


public class LambdaPredicate {

    public static void main(String[] args){
        List<Person> pList = PersonListCreator.getList();

        System.out.println("-- initial list --");
        pList.forEach(p -> System.out.println(p.toString()));

        System.out.println("-- over 15 --");
        pList.stream()
                .filter(p -> p.getAge()>15)
                .forEach(p -> System.out.println(p.toString()));

        System.out.println("-- age divided by 5 --");
        pList.stream()
                .filter(p -> p.getAge()%5==0)
                .forEach(p -> System.out.println(p.toString()));

        Predicate<Person> olderThan15 = p -> p.getAge()>15;
        System.out.println("-- predicate olderThan 15 --");
        pList.stream()
                .filter(olderThan15)
                .forEach(p -> System.out.println(p.toString()));

        class First3 implements Predicate<Person>{
            @Override
            public boolean test(Person person) {
                return person.getId()<=3;
            }
        }

        System.out.println("-- class predicate first 3 elements --");
        pList.stream()
                .filter(new First3())
                .forEach(p -> System.out.println(p.toString()));

        System.out.println(new First3().test(pList.get(0)));
    }
}
