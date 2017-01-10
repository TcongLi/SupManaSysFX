package Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by L T on 2017/1/8.
 */
public class SqlSessionFactoryProvider {
    private static SqlSessionFactory ourInstance;

    public static SqlSessionFactory getInstance() {
        if(ourInstance==null){
            new SqlSessionFactoryProvider();
        }
        return ourInstance;
    }

    private SqlSessionFactoryProvider() {
        String resource = "config/mybatis-conf.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ourInstance = new SqlSessionFactoryBuilder().build(inputStream);
    }
}
