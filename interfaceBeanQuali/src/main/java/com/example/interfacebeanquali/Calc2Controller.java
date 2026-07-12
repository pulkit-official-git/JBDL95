package com.example.interfacebeanquali;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Calc2Controller {

    @Autowired
            @Qualifier("uk-bean")
    Calculator calculator;

    public HashMap<String,Object> getDetails(){
        HashMap<String,Object> hm = new HashMap<>();
        int sum = calculator.add(5,6);
        int sub = calculator.sub(5,6);
        hm.put("sum",sum);
        hm.put("sub",sub);
        return hm;
    }
}
