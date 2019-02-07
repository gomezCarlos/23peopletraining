package hello.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(path="/students",method=RequestMethod.GET)
	public Object getStudents(@RequestParam("page") int page, @RequestParam("size") int size) {
		return studentService.getStudents(PageRequest.of(page, size));
	}
	
	@RequestMapping(path="/students/all",method=RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(studentService.findAll(), HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/students/{id}", method=RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student oldStudent = studentService.findById(id);
		if(null == oldStudent )
			return new ResponseEntity<Student>(oldStudent, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Student>(oldStudent, HttpStatus.OK);
	}
	
	@RequestMapping(path="/students", method=RequestMethod.POST)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.save(student), HttpStatus.OK);
	}
	
	@RequestMapping(path="/students/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id) {
		Student oldStudent = studentService.findById(id);
		if(null == oldStudent )
			return new ResponseEntity<Student>(oldStudent, HttpStatus.NOT_FOUND);
		oldStudent.setFirstName(student.getFirstName());
		oldStudent.setLastName(student.getLastName());
		oldStudent.setAddress(student.getAddress());
		return new ResponseEntity<Student>(oldStudent, HttpStatus.OK);
	}
	
	@RequestMapping(path="/students/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Student> delete(@PathVariable Long id) {
		Student oldStudent = studentService.findById(id);
		if(null == oldStudent )
			return new ResponseEntity<Student>(oldStudent, HttpStatus.NOT_FOUND);
		studentService.delete(id);
		return new ResponseEntity<Student>(oldStudent, HttpStatus.OK);
	}
}
