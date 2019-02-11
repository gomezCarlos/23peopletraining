package hello.school;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public Course findById(Long id) {
		
		return courseRepository.findById(id).orElse(null);
	}

	@Override
	public Course save(Course course) {
		
		return courseRepository.save(course);
	}
	
	@Override
	public void delete(Long id) {
		courseRepository.deleteById(id);
	}

	@Override
	public List<Course> findAll() {
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	public CourseRepository getCourseRepository() {
		return courseRepository;
	}

	public void setCourseRepository(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public Page<Course> getCourses(Pageable pageable) {
		
		return courseRepository.findAll(pageable);
	}
}
