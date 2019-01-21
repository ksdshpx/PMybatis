package cn.ksdshpx.mybatis.beans;

/**
 * @author peng.x
 * @date 2019年1月17日 上午11:21:03
 */
public class Employee {
	private Integer id;
	private String lastName;
	private String email;
	private Integer gender;

	public Employee() {
		super();
	}

	public Employee(Integer id, String lastName, String email, Integer gender) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + "]";
	}

}
