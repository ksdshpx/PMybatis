package cn.ksdshpx.mybatis.beans;

import java.util.List;

/**
 * @author peng.x
 * @date 2019年1月24日 下午1:37:22
 */
public class Department {
	private Integer id;
	private String deptName;
	private List<Employee> emps;

	public Department() {
		super();
	}

	public Department(Integer id, String deptName) {
		super();
		this.id = id;
		this.deptName = deptName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + "]";
	}

}
