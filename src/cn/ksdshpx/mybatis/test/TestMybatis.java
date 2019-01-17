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

	/**
	 * MyBatis HelloWorld小结：
	 * 	 两个重要的配置文件
	 * 		mybatis-config.xml：全局配置文件，数据库连接信息，引入SQL映射文件
	 * 		EmployeeMapper.xml：SQL映射文件，配置增删改查的SQL语句的映射
	 * 
	 *   两个重要的对象
	 *   	SqlSessionFactory:SqlSession的工厂对象，主要用于获取SqlSession对象
	 *      SqlSession:Java程序与数据库的会话对象，可以理解为是对Connection的封装
	 * 
	 */
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
