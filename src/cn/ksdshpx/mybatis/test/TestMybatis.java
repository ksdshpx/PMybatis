package cn.ksdshpx.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @author peng.x
 * @date 2019年1月17日 下午12:26:23
 */
public class TestMybatis {

	@Test
	public void testSqlSessionFactory() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println(sqlSession);
	}

}
