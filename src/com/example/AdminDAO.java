package com.example;

import com.example.models.Koordynator;

import java.util.ArrayList;

/**
 * Created by Tomek on 07.04.2017.
 */
public interface AdminDAO {
    public boolean zaloguj(String nazwa, String haslo);
    public ArrayList<Koordynator> pobierzKoordynatorow();
    public void uaktualnijKoordynatora(Koordynator koordynator);
    public void usunKoordynatora(Koordynator koordynator);
    public void dodajKoordynatora(Koordynator koordynator);
}
