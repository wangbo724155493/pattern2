package com.wb.pattern.template;

import java.sql.ResultSet;

/**
 *  rowMapper
 * @author wangbo
 * @since 2019/11/5 17:05
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs,int rowNum)throws Exception;

}
