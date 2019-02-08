package hello.school;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping(path="/courses/", method=RequestMethod.POST)
	public ResponseEntity<Course> saveCourse(@RequestBody Course course){
		return new ResponseEntity<Course>(courseService.save(course),HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/courses/{id}",method=RequestMethod.GET)
	public ResponseEntity<Course> getCourse(@PathVariable Long id){
		Course oldCourse = courseService.findById(id);
		if(null == oldCourse)
			return new ResponseEntity<Course>(oldCourse, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Course>(oldCourse, HttpStatus.OK);
	}
	
	@RequestMapping(path="/courses/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course){
		Course oldCourse = courseService.findById(id);
		if(null == oldCourse)
			return new ResponseEntity<Course>(oldCourse, HttpStatus.NOT_FOUND);
		oldCourse.setCode(course.getCode());
		oldCourse.setName(course.getName());
		return new ResponseEntity<Course>(courseService.save(oldCourse), HttpStatus.OK);
	}
	
	@RequestMapping(path="/courses/all", method=RequestMethod.GET)
	public List<Course> getAllCourses(){
		return courseService.findAll();
	}
	
	@RequestMapping(path="/courses/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Course> deleteCourse(Long id) {
		Course oldCourse = courseService.findById(id);
		if(null == oldCourse)
			return new ResponseEntity<Course>(oldCourse, HttpStatus.NOT_FOUND);
		courseService.delete(id);
		return new ResponseEntity<Course>(oldCourse, HttpStatus.OK);
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
}
