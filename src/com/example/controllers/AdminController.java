package com.example.controllers;

import com.example.AdminDAO;
import com.example.forms.KoordynatorWybor;
import com.example.models.Koordynator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by Tomek on 07.04.2017.
 */

@Controller
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    private AdminDAO dao;

    @RequestMapping(value="")
    public String adminWidok() {
        System.out.println("kukulele");
        return "adminlogin";
    }

    @RequestMapping(value = "/autoryzacja", method = RequestMethod.POST)
    public String adminAutoryzacja(@RequestParam("nazwa") String nazwa,
                                   @RequestParam("haslo") String haslo) {
        if(dao.zaloguj(nazwa,haslo))
            return "adminstrona";
        else
            return "adminlogin";
    }

    @RequestMapping(value = "/koordynatorzy", method = RequestMethod.POST)
    public String adminPodgladKoordynatorow(/*@RequestParam(value="Koordynator")Optional<Koordynator> koordynator,*/ Model model) {
//        if(koordynator.isPresent())
//            dao.usunKoordynatora(koordynator.get());

        ArrayList<Koordynator> koordynatory=dao.pobierzKoordynatorow();
        for(Koordynator koord: koordynatory) {
            System.out.println(koord.getImie()+" "+koord.getNazwisko());
        }


        model.addAttribute("koordynatorzy", koordynatory);
        model.addAttribute("koordynator_edycja", new KoordynatorWybor());
        model.addAttribute("koordynator_usuniecie", new KoordynatorWybor());
        return "admin_koordynatorzy_zarzadzanie";
    }

    @RequestMapping(value="/koordynatorzy/edycja", method = RequestMethod.POST)
    public String adminEdycjaKoordynatora(@ModelAttribute("koordynator_edycja") KoordynatorWybor koordynatorwyb, Model model) {
        model.addAttribute("koordynator", koordynatorwyb.getKoordynator());
        return "admin_koordynator_edycja";
    }
}
