package cn.ksdshpx.mybatis.dao;

import cn.ksdshpx.mybatis.beans.Department;

/**
 * @author peng.x
 * @date 2019年1月24日 下午2:02:36
 */
public interface DepartmentMapperResultMap {
	public Department getDeptById(Integer id);
	public Department getDeptAndEmps(Integer id);
}
