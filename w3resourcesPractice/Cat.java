package w3resourcesPractice;

public class Cat {
    // data field
    private int age;
    private String name;

    // constructor
    Cat() {
        this("unkown",0);
    }

    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter setter

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
