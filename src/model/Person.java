package model;


public class Person {

    private long id;
    private String name;
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(PersonBuilder b){
        this.id = b.id;
        this.name = b.name;
        this.age = b.age;
    }

    public static class PersonBuilder {
        private long id = 0L;
        private String name ="";
        private int age = 0;

        public PersonBuilder(){}

        public PersonBuilder setId(long id){
            this.id = id;
            return this;
        }

        public PersonBuilder setName(String name){
            this.name = name;
            return this;
        }

        public PersonBuilder setAge(int age){
            this.age = age;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

}
