package com.pers.gfc.chapter3.typeHandle;

import com.pers.gfc.chapter3.main.Chapter3Main;
import org.apache.ibatis.type.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * 自定义String类型处理的TypeHandler
 *
 * @author guofucheng
 * @date 2020/10/09
 */
@MappedTypes({String.class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class MyStringTypeHandler  implements TypeHandler<String> {
    private static Logger logger = LogManager.getLogger(MyStringTypeHandler.class.getName());

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        logger.info("---自定义TypeHandler---MyStringTypeHandler.setParameter---");
        ps.setString(i, parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        logger.info("---自定义TypeHandler---MyStringTypeHandler.列名获取String---返回值:{}",rs.getString(columnName));
        return rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        logger.info("---自定义TypeHandler---MyStringTypeHandler.下标获取String---返回值:{}",rs.getString(columnIndex));
        return rs.getString(columnIndex);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        logger.info("---自定义TypeHandler---MyStringTypeHandler.CallableStatement下标获取String---返回值:{}",cs.getString(columnIndex));
        return cs.getString(columnIndex);
    }
}
