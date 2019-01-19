package cn.ksdshpx.mybatis.dao;

import cn.ksdshpx.mybatis.beans.Employee;

/**
 * @author peng.x
 * @date 2019年1月18日 下午1:59:39
 */
public interface EmployeeMapper {
	// 根据id返回Employee对象
	public Employee getEmployeeById(Integer id);
}
