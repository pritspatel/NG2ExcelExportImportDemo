package com.prits.importexportapi.util;

import com.prits.importexportapi.entity.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 3ppat on 1/22/2017.
 */
public class DataUtil {

    public static List<Car> getCars() {
        List<Car> cList = new ArrayList<Car>();
        Car c1 = new Car();
        c1.setBrand("Toyota");
        c1.setColor("Black");
        c1.setVin("1-AS678DASDA876");
        c1.setYear(1995);
        cList.add(c1);

        Car c2 = new Car();
        c2.setBrand("Honda");
        c2.setColor("Gray");
        c2.setVin("2-AS678D3333DA876");
        c2.setYear(2016);


        cList.add(c1);
        cList.add(c2);

        return cList;

    }
}
