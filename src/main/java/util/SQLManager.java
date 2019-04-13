package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * ClassName: SQLManager
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/4/13
 */

public class SQLManager {
	private static SqlSession mSqlSession = null;
	public final static String NAMESPACE = "pojo.UserMapper.";

	static {
		// 创建MyBatis SessionFactory
		String resource = "mybatis-config.xml";
		SqlSessionFactory sqlSessionFactory = null;
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		} catch (IOException e) {
			e.printStackTrace();
		}
		mSqlSession = sqlSessionFactory.openSession();
	}

	private SQLManager() {
	}

	public static SqlSession getSqlSession() {
		return mSqlSession;
	}
}
