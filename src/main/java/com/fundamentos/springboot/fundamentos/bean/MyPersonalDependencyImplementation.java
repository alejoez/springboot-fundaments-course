package com.fundamentos.springboot.fundamentos.bean;

import com.fundamentos.springboot.fundamentos.dto.PersonDTO;

public class MyPersonalDependencyImplementation implements IPrintPersonalInfo{

    @Override
    public String sayPersonalInfo(PersonDTO personDTO) {
        return "Hello "+personDTO.getName()+" "+personDTO.getLastName()+", you're "+
                personDTO.getAge()+" years, and you're from "+personDTO.getCity();
    }
}
