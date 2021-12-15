package com.fundamentos.springboot.fundamentos.components;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements IComponentDependency {

    @Override
    public void sayHello() {
        System.out.println("Hello world from my component");
    }
}
