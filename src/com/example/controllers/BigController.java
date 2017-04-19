package com.example.controllers;

import com.example.models.Podopieczny;
import com.example.PodopiecznyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tomek on 25.03.2017.
 */

@Controller
@RequestMapping("/")
public class BigController {

    @Autowired
    private PodopiecznyDAO dao;

    //@RequestMapping("/home")
    @RequestMapping("/")
    public String func() {
        Podopieczny fbl=dao.pobierzPodopiecznego(1);
        System.out.println("Numer na koszulce: "+fbl.getId());
        System.out.println("Imię i nazwisko: "+fbl.getName());
        System.out.println("Wiek: "+fbl.getAge());
        return "index";
    }
}
