package cn.ksdshpx.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import cn.ksdshpx.mybatis.beans.Employee;

/**
 * @author peng.x
 * @date 2019年1月18日 下午1:59:39
 */
public interface EmployeeMapper {
	// 根据id返回Employee对象
	public Employee getEmployeeById(Integer id);

	// 添加一个新的Employee
	public void addEmployee(Employee employee);

	// 修改一个Employee
	public void updateEmployee(Employee employee);

	// 删除一个Employee
	public Integer deleteEmployeeById(Integer id);

	// 根据id和lastName返回Employee对象
	public Employee getEmployeeByIdAndlastName(@Param("id") Integer id, @Param("lastName") String lastName);

	public Employee getEmployeeByMap(Map<String, Object> map);

	// 查询多行数据返回一个对象的集合
	public List<Employee> getEmps();

	// 查询单条数据返回一个Map
	public Map<String, Object> getEmployeeByIdReturnMap(Integer id);

	// 查询多条数据返回一个Map
	// 指定使用对象的哪个属性作为map的key
	@MapKey("id")
	public Map<Integer, Employee> getEmpsReturnMap();
}
