package com.pers.gfc.chapter3.typeHandle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 自定义字符串类型处理的TypeHandler
 *
 * @author guofucheng
 * @date 2020/10/09
 */
public class MyStringTypeHandler  extends BaseTypeHandler<String> {
    private static final Logger logger=Logger.getLogger(MyStringTypeHandler.class.getName());
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
        logger.log(Level.INFO,"---setNonNullParameter---自定义TypeHandler---");
        ps.setString(i, parameter);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        logger.log(Level.INFO,"---getNullableResult---自定义TypeHandler---返回值:{}",rs.getString(columnName));
        return rs.getString(columnName);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        logger.log(Level.INFO,"---getNullableResult---自定义TypeHandler--返回值:{}",rs.getString(columnIndex));
        return rs.getString(columnIndex);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        logger.log(Level.INFO,"---getNullableResult---自定义TypeHandler---返回值:{}",cs.getString(columnIndex));
        return cs.getString(columnIndex);
    }
}
