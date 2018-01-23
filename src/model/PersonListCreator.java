package model;

import java.util.ArrayList;
import java.util.List;

public class PersonListCreator {

    public static List<Person> getList() {
        List<Person> pList = new ArrayList<>();
        pList.add(new Person.PersonBuilder()
                .setId(1)
                .setName("James Gordon")
                .setAge(15)
                .build()
        );
        pList.add(new Person.PersonBuilder()
                .setId(2)
                .setName("Tom Mickey")
                .setAge(11)
                .build()
        );
        pList.add(new Person.PersonBuilder()
                .setId(3)
                .setName("Hana Young")
                .setAge(25)
                .build()
        );
        pList.add(new Person.PersonBuilder()
                .setId(4)
                .setName("Rita Hell")
                .setAge(35)
                .build()
        );
        pList.add(new Person.PersonBuilder()
                .setId(5)
                .setName("Ivo Stiner")
                .setAge(75)
                .build()
        );

        return pList;
    }

}
