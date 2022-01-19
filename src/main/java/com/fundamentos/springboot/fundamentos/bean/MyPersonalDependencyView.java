package com.fundamentos.springboot.fundamentos.bean;

import com.fundamentos.springboot.fundamentos.dto.PersonDTO;

public class MyPersonalDependencyView implements IMyPersonalDependency {

    private IPrintPersonalInfo iPrintPersonalInfo;
    public MyPersonalDependencyView(IPrintPersonalInfo iPrintPersonalInfo) {
        this.iPrintPersonalInfo = iPrintPersonalInfo;
    }

    @Override
    public void personInformation() {
        System.out.println(iPrintPersonalInfo.sayPersonalInfo(new PersonDTO("Alejandro", "Escobar marin",
                24, "Cali")));
    }
}
