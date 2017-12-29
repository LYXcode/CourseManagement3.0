package xmu.crms.mapper;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * XXX class
 * 
 * @author 吕柏翰
 * @date 2017/12/20
 */
public class MyBatisUtils {
	 private static final String CONFIG_PATH = "mybatis.xml";

	    /*
	     * 获取数据库访问链接
	     */
	    public static SqlSession getSqlSession() {
	        SqlSession session = null;
	        try {
	            InputStream stream = Resources.getResourceAsStream(CONFIG_PATH);
	            //可以根据配置的相应环境读取相应的数据库环境
	            // SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
	            // stream, "development"); 
	            SqlSessionFactory factory = new SqlSessionFactoryBuilder()
	                    .build(stream);
	            session = factory.openSession();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	        return session;
	    }

	    /*
	     * 获取数据库访问链接
	     */
	    public static void closeSession(SqlSession session) {
	        session.close();
	    }
}
