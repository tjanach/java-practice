package model;

import java.util.ArrayList;
import java.util.List;

public class SellerListCreator {

    public static List<Seller> getList() {
        List<Seller> sList = new ArrayList<Seller>();

        sList.add(new Seller.SellerBuilder()
                .setId(1)
                .setName("James Gordon")
                .setAge(15)
                .setItemSold(10)
                .setTotalSale(12.5)
                .build()
        );
        sList.add(new Seller.SellerBuilder()
                .setId(2)
                .setName("Tom Mickey")
                .setAge(11)
                .setItemSold(18)
                .setTotalSale(112.5)
                .build()
        );
        sList.add(new Seller.SellerBuilder()
                .setId(3)
                .setName("Hana Young")
                .setAge(25)
                .setItemSold(3)
                .setTotalSale(52.5)
                .build()
        );
        sList.add(new Seller.SellerBuilder()
                .setId(4)
                .setName("Rita Hell")
                .setAge(35)
                .setItemSold(110)
                .setTotalSale(128.43)
                .build()
        );
        sList.add(new Seller.SellerBuilder()
                .setId(5)
                .setName("Ivo Stiner")
                .setAge(75)
                .setItemSold(55)
                .setTotalSale(144.11)
                .build()
        );

        return sList;
    }

}
