package com.example;

import com.example.models.Koordynator;
import com.example.models.Podopieczny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tomek on 07.04.2017.
 */
public class AdminDAOImpl implements AdminDAO {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate template) {
        this.jdbcTemplate=template;
    }

    @Override
    public boolean zaloguj(String nazwa, String haslo) {
        SimpleJdbcCall funcGetAdmin = new SimpleJdbcCall(jdbcTemplate).
                withCatalogName("admin_funkcje").withFunctionName("sprawdzAdmina");

        SqlParameterSource in = new MapSqlParameterSource().addValue("p_login", nazwa, Types.VARCHAR).
                                                            addValue("p_haslo", haslo, Types.VARCHAR);
        //korzystamy z typu liczbowego, bo nie ma wsparcia dla typu boolean w pl/sql
        BigDecimal czyJestTakiAdmin = funcGetAdmin.executeFunction(BigDecimal.class, in);

        if(czyJestTakiAdmin.intValue()!=0)
            return true;
        else
            return false;
    }

    @Override
    public ArrayList<Koordynator> pobierzKoordynatorow() {
        SimpleJdbcCall funcGetKoordynatorow = new SimpleJdbcCall(jdbcTemplate).
                withCatalogName("admin_funkcje").withFunctionName("pobierzKoordynatorow").
                returningResultSet("koordynatorzy", new BeanPropertyRowMapper<Koordynator>(Koordynator.class));

        ArrayList<Koordynator> wyniki=new ArrayList<>();
        Map m = funcGetKoordynatorow.execute(new HashMap<String, Object>(0));
        for( Object koord: (ArrayList) m.get("koordynatorzy")) {
            Koordynator dodawany=(Koordynator)koord;
            wyniki.add((Koordynator)koord);
        }
        return wyniki;
    }

    @Override
    public void uaktualnijKoordynatora(Koordynator koordynator) {
        SimpleJdbcCall funcUaktualnijKoordynatora = new SimpleJdbcCall(jdbcTemplate).
                withCatalogName("admin_funkcje").withProcedureName("uaktualnijKoordynatora");

        SqlParameterSource in = new MapSqlParameterSource().addValue("p_id", koordynator.getIdKoordynatora(), Types.NUMERIC).
                                        addValue("p_imie", koordynator.getImie(), Types.VARCHAR).
                                        addValue("p_nazwisko", koordynator.getNazwisko(), Types.VARCHAR).
                                        addValue("data_urodzenia", koordynator.getData_urodzenia(), Types.DATE).
                                        addValue("data_szkolenia", koordynator.getData_szkolenia(), Types.DATE).
                                        addValue("miasto", koordynator.getMiasto(), Types.VARCHAR).
                                        addValue("ulica", koordynator.getUlica(), Types.VARCHAR).
                                        addValue("nr_telefonu", koordynator.getNrTelefonu(), Types.NUMERIC).
                                        addValue("haslo", koordynator.getHaslo(), Types.VARCHAR);

        funcUaktualnijKoordynatora.execute();
    }

    @Override
    public void usunKoordynatora(Koordynator koordynator) {

    }

    @Override
    public void dodajKoordynatora(Koordynator koordynator) {

    }
}
