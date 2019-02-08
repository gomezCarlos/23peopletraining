package hello.school;

import java.util.List;

public interface CourseService {

	Course findById(Long id);

	Course save(Course course);
	
	List<Course> findAll();

	void delete(Long id);
}
