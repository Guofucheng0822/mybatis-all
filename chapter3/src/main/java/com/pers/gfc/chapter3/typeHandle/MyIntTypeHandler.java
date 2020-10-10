package com.pers.gfc.chapter3.typeHandle;

import org.apache.ibatis.type.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes({int.class})
@MappedJdbcTypes({JdbcType.INTEGER})
public class MyIntTypeHandler implements TypeHandler<Integer> {
    private static Logger logger = LogManager.getLogger(MyIntTypeHandler.class.getName());

    @Override
    public void setParameter(PreparedStatement ps, int i, Integer parameter, JdbcType jdbcType) throws SQLException {
        logger.info("---自定义TypeHandler---MyIntTypeHandler.setParameter---");
        ps.setInt(i, parameter);
    }

    @Override
    public Integer getResult(ResultSet rs, String columnName) throws SQLException {
        logger.info("---自定义TypeHandler---MyIntTypeHandler.列名获取int---返回值:{}",rs.getString(columnName));
        return rs.getInt(columnName);
    }

    @Override
    public Integer getResult(ResultSet rs, int columnIndex) throws SQLException {
        logger.info("---自定义TypeHandler---MyIntTypeHandler.下标获取int---返回值:{}",rs.getString(columnIndex));
        return rs.getInt(columnIndex);
    }

    @Override
    public Integer getResult(CallableStatement cs, int columnIndex) throws SQLException {
        logger.info("---自定义TypeHandler---MyIntTypeHandler.CallableStatement下标获取int---返回值:{}",cs.getString(columnIndex));
        return cs.getInt(columnIndex);
    }
}
