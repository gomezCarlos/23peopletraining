package hello.school;

import java.util.List;
import hello.school.Page;
public class StudentPage {
	
	private List<Student> students;
	private Page page;
	
	public StudentPage() {
		super();
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
}
