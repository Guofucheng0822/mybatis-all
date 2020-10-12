package com.pers.gfc.chapter3.factory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Properties;

/**
 * 自定义ObjectFactory
 *
 * @author guofucheng
 * @date 2020/10/12
 */
public class MyObjectFactory extends DefaultObjectFactory {
    private static Logger logger = LogManager.getLogger(MyObjectFactory.class.getName());

    @Override
    public void setProperties(Properties properties) {
        logger.info("自定义ObjectFactory定制属性:{}",properties);
        super.setProperties(properties);
    }

    @Override
    public <T> T create(Class<T> type) {
        logger.info("自定义ObjectFactory创建单个对象:{}",type);
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        logger.info("自定义ObjectFactory创建对象列表:{}|{}|{}",type,constructorArgTypes,constructorArgs);
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        logger.info("自定义ObjectFactory的isCollection方法:{}",type);
        return super.isCollection(type);
    }
}
