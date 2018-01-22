package lambda.ex;

import model.Person;
import model.PersonListCreator;
import model.Seller;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


public class lambdaFunction {

    public static void main(String[] args){
        List<Person> pList = PersonListCreator.getList();

        System.out.println("-- initial list --");
        pList.forEach(p -> System.out.println(p.toString()));

        class createSellers implements Function<Person, Seller> {
            @Override
            public Seller apply(Person person) {
                final int itemSoldRand = new Random().nextInt(50);
                return new Seller.SellerBuilder()
                        .setId(person.getId())
                        .setAge(person.getAge())
                        .setName(person.getName())
                        .setItemSold(itemSoldRand)
                        .setTotalSale(itemSoldRand*100 + new Random().nextDouble())
                        .build();
            }
        }


        System.out.println("-- sellers based on persons --");
        List<Seller> sList = pList.stream().map(new createSellers()).collect(Collectors.toList());

        sList.forEach(s -> System.out.println(s.toString()));




    }
}
