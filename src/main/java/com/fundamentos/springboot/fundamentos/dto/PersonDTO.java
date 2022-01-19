package com.fundamentos.springboot.fundamentos.dto;

public class PersonDTO {
    public String name;
    public String lastName;
    public Integer age;
    public String city;

    public PersonDTO(String name, String lastName, Integer age, String city) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
