package test;

import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * ClassName: TestMyBatis
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/4/13
 */

public class TestMyBatis {
	SqlSessionFactory mSqlSessionFactory;
	private SqlSession mSqlSession;

	@Test
	public void initFactory() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		mSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		mSqlSession = mSqlSessionFactory.openSession();

		if (mSqlSessionFactory == null) {
			System.out.println("mSqlSessionFactory == null");
		}
	}

	@Test
	public void testListAll() throws IOException {
		initFactory();
		List<User> list = mSqlSession.selectList("pojo.UserMapper.findAll");
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testCheckUserName() throws IOException {
		initFactory();
		User user = mSqlSession.selectOne("pojo.UserMapper.checkUsername", "admin");
		System.out.println(user);
	}

	@Test
	public void testInsertUser() throws IOException {
		initFactory();
		User user = new User("chen", "chen", "lin", "hole@163.com");
		int res = mSqlSession.insert("pojo.UserMapper.insertUser", user);
		mSqlSession.commit();
		System.out.println(res);
	}

	@Test
	public void testUpdateUser() throws IOException {
		initFactory();
		User user = mSqlSession.selectOne("pojo.UserMapper.checkUsername", "admin");
		user.setPassWord("chen");
		user.setEmail("hole@163.com");
		int res = mSqlSession.update("pojo.UserMapper.update", user);
		mSqlSession.commit();
		System.out.println(res);
		testListAll();
	}

	@Test
	public void testDelete() throws IOException {
		initFactory();
		int res = mSqlSession.delete("pojo.UserMapper.delete", "chen");
		mSqlSession.commit();
		testListAll();
	}
}
