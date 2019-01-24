package cn.ksdshpx.mybatis.test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.ksdshpx.mybatis.beans.Employee;
import cn.ksdshpx.mybatis.dao.EmployeeMapper;
import cn.ksdshpx.mybatis.dao.EmployeeMapperResultMap;

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
	
	@Test
	public void testHelloWorldByMapper() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//mapper接口：其实就是dao接口
			/*
			 * 两个绑定：
			 * 		1.Mapper接口与SQL映射文件的绑定===>映射文件的namespace值必须指定为Mapper接口的全类名
			 * 		2.Mapper接口的方法与SQL映射文件的具体SQL语句的绑定===>SQL语句的id值必须指定为Mpper接口的方法名
			 * 
			 * Mapper接口开发：
			 * 		1.有更明确的类型
			 * 		2.接口本身:接口本身就是抽象，抽出了规范
			 * 			EmployeeDao:EmployeeDaoJdbcImpl、EmployeeDao:EmployeeDaoHibernateImpl、MyBatis代理实现类
			 */
			//获取MyBatis为Mapper接口生成的代理实现类对象
			EmployeeMapper dao = sqlSession.getMapper(EmployeeMapper.class);
			System.out.println(dao.getClass().getName());//com.sun.proxy.$Proxy4
			Employee employee = dao.getEmployeeById(2);
			System.out.println(employee);
		} finally {
			sqlSession.close();
		}
	}

	private SqlSessionFactory getSqlSessionFactory() throws Exception{
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	@Test
	public void testCRUD() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//获取Mapper接口的代理实现类对象
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			//查询
			//Employee employee = mapper.getEmployeeById(1);
			//System.out.println(employee);
			//添加
			Employee employee = new Employee(null, "wangWu", "wangWu@163.com", 1,null);
			mapper.addEmployee(employee);
			System.out.println("返回的主键值："+employee.getId());
			//更新
			//Employee employee = new Employee(1, "zhangSan", "zhangSan123@163.com", 1);
			//mapper.updateEmployee(employee);
			//删除
			Integer result = mapper.deleteEmployeeById(4);
			System.out.println("影响的条数："+result);
			//提交
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testParameter() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//获取Mapper接口的代理实现类对象
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			//查询
			Employee employee = mapper.getEmployeeByIdAndlastName(1, "zhangSan");
//			Map<String,Object> map = new HashMap<>();
//			map.put("map_id", 2);
//			map.put("map_lastName", "liSi");
//			Employee employee = mapper.getEmployeeByMap(map);
			System.out.println(employee);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelect() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//获取Mapper接口的代理实现类对象
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			//查询多行数据返回一个对象的集合
			List<Employee> emps = mapper.getEmps();
			System.out.println(emps);
			
			// 查询单条数据返回一个Map
			Map<String, Object> map = mapper.getEmployeeByIdReturnMap(5);
			System.out.println(map);
			
			// 查询多条数据返回一个Map
			Map<Integer,Employee> map2 = mapper.getEmpsReturnMap();
			System.out.println(map2);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testResultMap() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//获取Mapper接口的代理实现类对象
			EmployeeMapperResultMap mapper = sqlSession.getMapper(EmployeeMapperResultMap.class);
			Employee employee = mapper.getEmployeeById(5);
			System.out.println(employee);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testResultMapCascade() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//获取Mapper接口的代理实现类对象
			EmployeeMapperResultMap mapper = sqlSession.getMapper(EmployeeMapperResultMap.class);
			Employee employee = mapper.getEmpAndDept(1);
			System.out.println(employee.getDept());
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testResultMapStep() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//获取Mapper接口的代理实现类对象
			EmployeeMapperResultMap mapper = sqlSession.getMapper(EmployeeMapperResultMap.class);
			Employee employee = mapper.getEmployeeByStep(1);
			System.out.println(employee.getEmail());
			System.out.println("---------------------------");
			System.out.println(employee.getDept());
		}finally {
			sqlSession.close();
		}
	}
}
