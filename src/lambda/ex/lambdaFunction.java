package lambda.ex;

import model.Person;
import model.PersonListCreator;

import java.util.List;
import java.util.function.Consumer;


public class lambdaFunction {

    public static void main(String[] args){
        List<Person> pList = PersonListCreator.getList();

        System.out.println("-- initial list --");
        pList.forEach(p -> System.out.println(p.toString()));

        class ConsumerEx implements Consumer<Person> {
            @Override
            public void accept(Person person) {
                System.out.println("Id: "+person.getId()+" name: "+person.getName()+" age: "+person.getAge());
            }
        }

        System.out.println("-- formated by the Consumer class --");
        pList.forEach(new ConsumerEx());



    }
}
