package model;

public class Seller extends Person {
    private int itemSold;
    private double totalSale;

    public int getItemSold() {
        return itemSold;
    }

    public void setItemSold(int itemSold) {
        this.itemSold = itemSold;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public Seller(SellerBuilder b) {
        super(b);
        this.itemSold = b.itemSold;
        this.totalSale = b.totalSale;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", age=" + getAge() +
                ", itemSold=" + itemSold +
                ", totalSale=" + String.format("%.02f", totalSale) +
                '}';
    }

    public static class SellerBuilder extends PersonBuilder {
        private int itemSold = 0;
        private double totalSale = 0.0;

        public SellerBuilder() {}

        public SellerBuilder setId(long id){
            super.setId(id);
            return this;
        }

        public SellerBuilder setName(String name){
            super.setName(name);
            return this;
        }

        public SellerBuilder setAge(int age){
            super.setAge(age);
            return this;
        }

        public SellerBuilder setItemSold(int itemSold) {
            this.itemSold = itemSold;
            return this;
        }

        public SellerBuilder setTotalSale(double totalSale) {
            this.totalSale = totalSale;
            return this;
        }

        public Seller build(){
            return new Seller(this);
        }
    }


}
