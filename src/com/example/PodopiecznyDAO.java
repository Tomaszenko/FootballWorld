package com.example;

import com.example.models.Podopieczny;

/**
 * Created by Tomek on 28.03.2017.
 */
public interface PodopiecznyDAO {
    public void zapiszPodopiecznego(Podopieczny podopieczny);
    public void uaktualnijPodopiecznego(Podopieczny fb);
    public Podopieczny pobierzPodopiecznego(int idFtb);
}
