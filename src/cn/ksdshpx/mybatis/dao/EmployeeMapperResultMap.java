package cn.ksdshpx.mybatis.dao;

import cn.ksdshpx.mybatis.beans.Employee;

/**
 * @author peng.x
 * @date 2019年1月24日 上午9:42:04
 */
public interface EmployeeMapperResultMap {
	public Employee	getEmployeeById(Integer id);
	public Employee getEmpAndDept(Integer id);
}
