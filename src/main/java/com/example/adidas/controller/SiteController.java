package com.example.adidas.controller;


import com.example.adidas.CarRepository;
import com.example.adidas.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class SiteController {
    @Autowired
    private CarRepository carRepository;

    @RequestMapping(path = "/add")
    public @ResponseBody Iterable<Car> postAdd(@RequestBody Car car, Model model) {
        if (car==null){
//            error();
            return null;
        }
        car.setDatetime(new Date());
        model.addAttribute("car",car);
        carRepository.save(car);
        return getAll();
    }
//    @RequestMapping(path = "/addget", method = RequestMethod.GET)
//    public @ResponseBody Iterable<Car> getAdd(@RequestBody Car car, Model model) {
//        if (car==null){
//            error();
//            return null;
//        }
//        car.setDatetime(new Date());
//        model.addAttribute("car",car);
//        carRepository.save(car);
//        return getAll();
//    }


//    @RequestMapping(path = "/error")
//    public String error(){
//        return "404";
//    }

    @RequestMapping(path = "/addone")
    public String addone(Model model) {
        Car c = new Car();
        c.setDatetime(new Date());
        c.setLicense("jq22134");
        c.setHC(0.8);
        c.setNOx(99);
        c.setPM(88);
        model.addAttribute("car", c);
        carRepository.save(c);
        return "index";

    }

    @RequestMapping(path = "/all")
    public @ResponseBody
    Iterable<Car> getAll() {
        return carRepository.findAll();
    }

    @RequestMapping(value = {"/","/myindex"})
    public String index(Model model) {
        model.addAttribute("carslist", carRepository.findAll());
        return "myindex";
    }
}

