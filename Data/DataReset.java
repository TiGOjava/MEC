package com.MEC.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataReset {


    @Autowired
    public LocalDataRepository localDataRepository;

    public DataReset(LocalDataRepository localDataRepository) {
        this.localDataRepository = localDataRepository;
    }


    @GetMapping(value = "/reset")
    public String deleteAllData() {
        localDataRepository.deleteAll();
        return "Alert";
    }
}
