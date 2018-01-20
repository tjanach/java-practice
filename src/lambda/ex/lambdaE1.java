package lambda.ex;

import java.util.List;


public class lambdaE1 {

    public static void main(String[] args){
        List<Person> pList = PersonListCreator.getList();

        //pList.forEach(p -> System.out.println(p));
        pList.forEach(p -> System.out.println(p.toString()));
        pList.forEach(p -> p.setAge(p.getAge()+1));
        pList.forEach(p -> System.out.println(p.toString()));
    }
}
