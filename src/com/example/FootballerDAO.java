package com.example;

/**
 * Created by Tomek on 28.03.2017.
 */
public interface FootballerDAO {
    public void saveFootballer(Footballer fb);
    public void updateFootballer(Footballer fb);
    public Footballer getFootballer(int idFtb);
}
