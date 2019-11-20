package com.wb.pattern.template.dao;

import com.wb.pattern.template.JdbcTemplate;
import com.wb.pattern.template.RowMapper;
import com.wb.pattern.template.entity.Menber;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *  dao
 * @author wangbo
 * @since 2019/11/5 16:56
 */
public class MenberDao{

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public List<? extends Object> query(){
        String sql = "select * from t_menber";
        return jdbcTemplate.executeQuery(sql, new RowMapper<Menber>() {
            @Override
            public Menber mapRow(ResultSet rs, int rowNum) throws Exception {
                Menber menber = new Menber();
                menber.setAdd(rs.getString("add"));
                menber.setAge(rs.getInt("age"));
                menber.setUserName(rs.getString("userName"));
                return menber;
            }
        },new Object[]{});
    }

    public Object processResult(ResultSet rs,Integer rowNum) throws SQLException {
        Menber menber = new Menber();
        menber.setAdd(rs.getString("add"));
        menber.setAge(rs.getInt("age"));
        menber.setUserName(rs.getString("userName"));
        return menber;
    }
}
