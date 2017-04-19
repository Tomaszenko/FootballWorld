package com.example.models;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by Tomek on 14.04.2017.
 */
public class Koordynator {
    private int idKoordynatora;
    private String imie;
    private String nazwisko;
    private DateTime data_urodzenia;
    private String ulica;
    private String miasto;
    private int nrTelefonu;
    private DateTime data_szkolenia;
    private String haslo;

    public Koordynator() {
    }

    public int getIdKoordynatora() {
        return idKoordynatora;
    }

    public void setIdKoordynatora(int id) {
        this.idKoordynatora = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public DateTime getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = new DateTime(data_urodzenia);
    }

    public DateTime getData_szkolenia() {
        return data_szkolenia;
    }

    public void setData_szkolenia(Date data_szkolenia) {
        this.data_szkolenia = new DateTime(data_szkolenia);
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(int nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
