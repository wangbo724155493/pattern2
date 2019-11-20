package com.wb.pattern.template;

import com.wb.pattern.template.entity.Menber;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangbo
 * @since 2019/11/5 16:28
 */
public class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    private PreparedStatement createPreparedStatement(Connection conn,String sql) throws SQLException {
        return  conn.prepareStatement(sql);
    }

    private ResultSet executeQuery(PreparedStatement pstm,Object[] params) throws SQLException {
        if(params!=null){
            for(int i = 1;i < params.length;i++){
                pstm.setObject(i,params[i]);
            }
        }
        return pstm.executeQuery();
    }

    private void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void closePreparedStatement(PreparedStatement pstm){
        if(pstm != null){
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private List<? extends Object> parseResultSet(ResultSet rs,RowMapper rowMapper)throws Exception{
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()){
            result.add(rowMapper.mapRow(rs,rowNum));
        }
        return result;
    }


    /**
     * 执行查询
     * @param sql
     * @param params
     * @return
     */
    public List<?> executeQuery(String sql, RowMapper<? extends Object> rowMapper,Object[] params){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //1. 获取连接
            conn = this.getConnection();
            //2. 创建语句集
            pstm = this.createPreparedStatement(conn,sql);
            //3. 执行语句集
            rs = this.executeQuery(pstm,params);

            //4. 解析语句集
//            List<Object> result = new ArrayList<>();
//            int rowNum = 1;
//            while(rs.next()){
//                result.add(processResult(rs,rowNum));
//            }
            List<?> result = this.parseResultSet(rs,rowMapper);

            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5. 关闭连接
            closeResultSet(rs);
            closePreparedStatement(pstm);
            closeConnection(conn);
        }
        return null;
    }

//    public abstract Object processResult(ResultSet rs,Integer rowNum) throws SQLException;

}
