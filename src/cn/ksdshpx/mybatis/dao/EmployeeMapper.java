package cn.ksdshpx.mybatis.dao;

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
}
