package com.pers.gfc.chapter3.typeHandle;

import com.pers.gfc.chapter3.main.Chapter3Main;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * 自定义字符串类型处理的TypeHandler
 *
 * @author guofucheng
 * @date 2020/10/09
 */
public class MyStringTypeHandler  extends BaseTypeHandler<String> {
    private static Logger logger = LogManager.getLogger(MyStringTypeHandler.class.getName());
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
        logger.info("---setNonNullParameter---自定义TypeHandler---");
        ps.setString(i, parameter);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        logger.info("---getNullableResult---自定义TypeHandler---返回值:{}",rs.getString(columnName));
        return rs.getString(columnName);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        logger.info("---getNullableResult---自定义TypeHandler--返回值:{}",rs.getString(columnIndex));
        return rs.getString(columnIndex);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        logger.info("---getNullableResult---自定义TypeHandler---返回值:{}",cs.getString(columnIndex));
        return cs.getString(columnIndex);
    }
}
