package com.example.joseph.savingdata;

/**
 * Created by joseph on 10/2/17.
 */

public class Person {

    String name;
    String age;
    String gender;

    public Person(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return  "name = " + name + ", age = " + age + ", gender = " + gender;
    }
}
