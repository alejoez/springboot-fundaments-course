package com.fundamentos.springboot.fundamentos.bean;

public class MyTwoBeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("Hello world from my own bean implementation 2 :)");
    }
}
