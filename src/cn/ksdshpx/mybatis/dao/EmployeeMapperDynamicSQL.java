package cn.ksdshpx.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ksdshpx.mybatis.beans.Employee;

/**
 * @author peng.x
 * @date 2019年1月30日 上午9:59:43
 */
public interface EmployeeMapperDynamicSQL {
	public List<Employee> getEmpsByConditionIfWhere(Employee condition);

	public void updateEmpByConditionSet(Employee condition);

	public List<Employee> getEmpsByConditionChoose(Employee condition);

	public List<Employee> getEmpsByIds(@Param("ids") List<Integer> ids);
	
	//批量操作：修改 删除 添加
}
