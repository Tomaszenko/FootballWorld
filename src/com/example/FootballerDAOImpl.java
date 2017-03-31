package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Tomek on 28.03.2017.
 */

public class FootballerDAOImpl implements FootballerDAO {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate template) {
        this.jdbcTemplate=template;
    }


    @Override
    public void saveFootballer(Footballer fb) {

    }

    @Override
    public void updateFootballer(Footballer fb) {

    }

    @Override
    public Footballer getFootballer(int idFtb) {
        Footballer fbl=(Footballer)jdbcTemplate.queryForObject(this.football_select,
                new Object[]{new Integer(idFtb)},
                new RowMapper() {
                    public Object mapRow(ResultSet rs, int arg1) throws SQLException{
                        Footballer ftb=new Footballer();
                        ftb.setId(rs.getInt("id_ftb"));
                        ftb.setName(rs.getString("name"));
                        ftb.setAge(rs.getInt("age"));
                        return ftb;
                    }
                });
        return fbl;
    }

    private final String football_select="SELECT * FROM footballer WHERE id_ftb=?";
    private final String footballer_insert="INSERT INTO footballer (id_ftb,name,age) VALUES(?,?,?)";
    //private final String footballer_update="UPDATE footballer SET ";
}
