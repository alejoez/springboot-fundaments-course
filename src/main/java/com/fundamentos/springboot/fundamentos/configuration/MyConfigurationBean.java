package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyTwoBeanImplement();
    }

    @Bean
    public IMyOperation iMyOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public IMyBeanWithDependency myOperationWithDependency(IMyOperation iMyOperation){
        return new MyBeanWithDependencyImplement(iMyOperation);
    }

    /*@Bean
    public IMyPersonalDependency myPersonalDependency(IPrintPersonalInfo iPrintPersonalInfo){
        return new MyPersonalDependencyView(iPrintPersonalInfo);
    }*/

}
