package com.pers.gfc.chapter3.typeHandle;

import com.pers.gfc.chapter3.po.SexEnum2;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 性别枚举类型的处理程序
 *
 * @author guofucheng
 * @date 2020/10/12
 */
public class SexEnum2TypeHandler implements TypeHandler<SexEnum2> {
    private static Logger logger = LogManager.getLogger(SexEnum2TypeHandler.class.getName());
    @Override
    public void setParameter(PreparedStatement ps, int i, SexEnum2 parameter, JdbcType jdbcType) throws SQLException {
        logger.info("---自定义TypeHandler---SexEnum2TypeHandler.setParameter---");
        ps.setInt(i,parameter.getId());
    }

    @Override
    public SexEnum2 getResult(ResultSet rs, String columnName) throws SQLException {
        int id = rs.getInt(columnName);
        logger.info("---自定义TypeHandler---SexEnum2TypeHandler.列名获取Enum---返回值:{}",SexEnum2.entity(id));
        return SexEnum2.entity(id);
    }

    @Override
    public SexEnum2 getResult(ResultSet rs, int columnIndex) throws SQLException {
        int id = rs.getInt(columnIndex);
        logger.info("---自定义TypeHandler---SexEnum2TypeHandler.下标获取Enum---返回值:{}",SexEnum2.entity(id));
        return SexEnum2.entity(id);
    }

    @Override
    public SexEnum2 getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int id = cs.getInt(columnIndex);
        logger.info("---自定义TypeHandler---SexEnum2TypeHandler.CallableStatement下标获取Enum---返回值:{}",SexEnum2.entity(id));
        return SexEnum2.entity(id);
    }
}
