package lambda.ex;

import java.util.List;
import java.util.function.Consumer;


public class lambdaFunction {

    public static void main(String[] args){
        List<Person> pList = PersonListCreator.getList();

        System.out.println("-- initial list --");
        pList.forEach(p -> System.out.println(p.toString()));


    }
}
