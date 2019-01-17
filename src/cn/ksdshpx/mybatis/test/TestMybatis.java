package cn.ksdshpx.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.ksdshpx.mybatis.beans.Employee;

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
		try {
			/**
			 * statement:SQL语句的唯一标识
			 * parameter:执行SQL用到的参数
			 */
			Employee employee = sqlSession.selectOne("org.mybatis.suibian.EmployeeMapper.selectEmployee", 1);
			System.out.println(employee);
		} finally {
			sqlSession.close();
		}
	}

}
