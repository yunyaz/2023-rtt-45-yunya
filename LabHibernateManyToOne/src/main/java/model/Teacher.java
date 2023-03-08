package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tit;
	private String salary;
	private String Teachername;

	@ManyToOne
	private Department department;

	public Teacher(int tit, String salary, String teachername) {
		this.tit = tit;
		this.salary = salary;
		Teachername = teachername;
	}

	public Department getDep() {
		return department;
	}

	public void setDep(Department department) {
		this.department = department;
	}

	public Teacher() {
	}

	public int getTit() {
		return tit;
	}

	public void setTit(int tit) {
		this.tit = tit;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTeachername() {
		return Teachername;
	}

	public void setTeachername(String teachername) {
		Teachername = teachername;
	}

}
