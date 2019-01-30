package cn.ksdshpx.mybatis.dao;

import java.util.List;

import cn.ksdshpx.mybatis.beans.Employee;

/**
 * @author peng.x
 * @date 2019年1月30日 上午9:59:43
 */
public interface EmployeeMapperDynamicSQL {
	public List<Employee> getEmpsByConditionIfWhere(Employee condition);
	public void updateEmpByConditionSet(Employee condition);
}
