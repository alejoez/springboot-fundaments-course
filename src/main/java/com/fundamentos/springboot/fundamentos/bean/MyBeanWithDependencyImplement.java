package com.fundamentos.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements IMyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private IMyOperation iMyOperation;

    public MyBeanWithDependencyImplement(IMyOperation iMyOperation) {
        this.iMyOperation = iMyOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Metodo printWithDependency");
        int number = 1;
        LOGGER.debug("El numero enviado fue: "+number);
        System.out.println(iMyOperation.suma(number));
        System.out.println("Hello from implementation of dependency bean");
    }
}
