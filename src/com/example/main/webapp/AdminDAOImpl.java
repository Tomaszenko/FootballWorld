package com.example.main.webapp;

import com.example.main.webapp.models.Koordynator;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
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
    public Koordynator pobierzKoordynatora(int koordynatorId) {
        Koordynator krd=(Koordynator) jdbcTemplate.queryForObject(this.koordynator_select,
                new Object[]{new Integer(koordynatorId)},
                new RowMapper() {
                    public Object mapRow(ResultSet rs, int arg1) throws SQLException{
                        Koordynator kord=new Koordynator();
                        kord.setIdKoordynatora(rs.getInt("id_koordynatora"));
                        kord.setImie(rs.getString("imie"));
                        kord.setNazwisko(rs.getString("nazwisko"));
                        kord.setData_urodzenia(rs.getDate("data_urodzenia"));
                        kord.setData_szkolenia(rs.getDate("data_szkolenia"));
                        kord.setMiasto(rs.getString("miasto"));
                        kord.setNrTelefonu(rs.getInt("nr_telefonu"));
                        kord.setUlica(rs.getString("ulica"));
                        kord.setHaslo(rs.getString("haslo"));
                        return kord;
                    }
                });
//        SimpleJdbcCall funcGetKoordynator = new SimpleJdbcCall(jdbcTemplate).
//                withCatalogName("admin_funkcje").withFunctionName("pobierzKoordynatorow").withReturnValue();

//        SqlParameterSource in = new MapSqlParameterSource().addValue("p_id", koordynatorId, Types.NUMERIC);
//        //korzystamy z typu liczbowego, bo nie ma wsparcia dla typu boolean w pl/sql
//        Koordynator koordynator = funcGetKoordynator.executeFunction(Koordynator.class, in);

        return krd;
    }

    @Override
    public void uaktualnijKoordynatora(Koordynator koordynator) {

        System.out.println("ID="+koordynator.getIdKoordynatora());
        SimpleJdbcCall funcUaktualnijKoordynatora = new SimpleJdbcCall(jdbcTemplate).
                withCatalogName("admin_funkcje").withFunctionName("uaktualnijKoordynatora");

        SqlParameterSource in = new MapSqlParameterSource().
                                        addValue("p_id", koordynator.getIdKoordynatora(), Types.NUMERIC).
                                        addValue("p_imie", koordynator.getImie(), Types.VARCHAR).
                                        addValue("p_nazwisko", koordynator.getNazwisko(), Types.VARCHAR).
                                        addValue("p_dataurodzenia", koordynator.getData_urodzenia(), Types.DATE).
                                        addValue("p_dataszkolenia", koordynator.getData_szkolenia(), Types.DATE).
                                        addValue("p_miasto", koordynator.getMiasto(), Types.VARCHAR).
                                        addValue("p_ulica", koordynator.getUlica(), Types.VARCHAR).
                                        addValue("p_nrtelefonu", koordynator.getNrTelefonu(), Types.NUMERIC).
                                        addValue("p_haslo", koordynator.getHaslo(), Types.VARCHAR);
        BigDecimal czyZaktualizowano = funcUaktualnijKoordynatora.executeFunction(BigDecimal.class, in);
        if(czyZaktualizowano.intValue()==1)
            System.out.println("ZAKTUALIZOWANO!!!");
        else
            System.out.println("NIE ZAKTUALIZOWANO!!!");
        System.out.println("ID="+koordynator.getIdKoordynatora());
        //funcUaktualnijKoordynatora.execute(in);
    }

    @Override
    public void usunKoordynatora(Koordynator koordynator) {

    }

    @Override
    public void dodajKoordynatora(Koordynator koordynator) {

    }

    private final String koordynator_select="SELECT * FROM koordynator WHERE id_koordynatora=?";
}
