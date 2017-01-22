package com.prits.importexportapi.web;

import com.prits.importexportapi.entity.Car;
import com.prits.importexportapi.util.DataUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 3ppat on 1/22/2017.
 */
@RestController
public class CarController {

    @RequestMapping(value = "/cars")
    public @ResponseBody   List<Car> getCars(){
        return DataUtil.getCars();
    }
}
