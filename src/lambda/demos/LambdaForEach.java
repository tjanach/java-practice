package lambda.demos;

import model.Person;
import model.PersonListCreator;

import java.util.List;


public class LambdaForEach {

    public static void main(String[] args){
        List<Person> pList = PersonListCreator.getList();

        System.out.println("-- initial list --");
        pList.forEach(p -> System.out.println(p.toString()));

        System.out.println("-- modified list by stream action: age++ --");
        pList.stream().peek(p -> p.setAge(p.getAge()+1)).forEach(p -> System.out.println(p.toString()));

        pList.forEach(p -> System.out.println(p.toString()));

        System.out.println("-- modified list: age++ --");
        pList.forEach(p -> p.setAge(p.getAge()+1));
        pList.forEach(p -> System.out.println(p.toString()));
    }
}
