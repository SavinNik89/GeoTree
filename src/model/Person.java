package model;

public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private GenderType gender;

    public Person(String firstName, String secondName, int age, GenderType gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public GenderType getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return  firstName + ' ' + secondName + ", " + age + " years old" + ", " + gender;
    }
}
