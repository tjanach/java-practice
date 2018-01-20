package lambda.ex;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class lambdaConsumer {

    public static void main(String[] args){
        List<Person> pList = PersonListCreator.getList();

        System.out.println("-- initial list --");
        pList.forEach(p -> System.out.println(p.toString()));

        Consumer<Person> add3ToAge = p -> p.setAge(p.getAge()+3) ;
        pList.forEach(add3ToAge);
        System.out.println("-- added 3 to ages --");
        pList.stream().forEach(p -> System.out.println(p.toString()));

        System.out.println("-- added 3 to ages again --");
        pList.forEach(add3ToAge.andThen(p -> System.out.println(p.toString())));

        class shiftIdsBy100 implements Consumer<Person>{
            @Override
            public void accept(Person person) {
                person.setId(person.getId()*100);
            }
        }

        System.out.println("-- id multiplied by 100 --");
        pList.forEach(new shiftIdsBy100().andThen(p -> System.out.println(p.toString())));

        System.out.println("-- id multiplied by 100 for the last 2 elements--");
        pList.stream().filter(p->p.getId()>300)
                .forEach(new shiftIdsBy100().andThen(p -> System.out.println(p.toString())));

        System.out.println("-- final list --");
        pList.forEach(p -> System.out.println(p.toString()));
    }
}
