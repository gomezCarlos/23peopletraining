package hello.school;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	private String code;
	private String name;
	@OneToMany
	private List<Student> students = new ArrayList<Student>();
	
	public Course() {
		super();
	}
	
	public Course(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public String toString() {
		return String.format("Course: [code=%s, name=%s, students=%s]", code, name, students);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}