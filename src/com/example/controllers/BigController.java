package com.example.controllers;

import com.example.Footballer;
import com.example.FootballerDAO;
import com.example.FootballerDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

/**
 * Created by Tomek on 25.03.2017.
 */

@Controller
@RequestMapping("/")
public class BigController {

    @Autowired
    private FootballerDAO dao;

    //@RequestMapping("/home")
    @RequestMapping("/")
    public String func() {
        Footballer fbl=dao.getFootballer(1);
        System.out.println("Numer na koszulce: "+fbl.getId());
        System.out.println("Imię i nazwisko: "+fbl.getName());
        System.out.println("Wiek: "+fbl.getAge());
        return "index";
    }
}
