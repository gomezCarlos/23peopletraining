package hello.school;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping(path="/students")
	public Object getStudents(@RequestParam(name="page", defaultValue="0") int page, @RequestParam(name="size", defaultValue="10") int size) {
		return studentService.getStudents(PageRequest.of(page, size));
	}
	
	@GetMapping(path="/students/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping(path="/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student student = studentService.findById(id);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/students")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
		return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
	}
	
	@PutMapping(path="/students/{id}")
	public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student, @PathVariable Long id) {
		Student oldStudent = studentService.findById(id);
		oldStudent.setFirstName(student.getFirstName());
		oldStudent.setLastName(student.getLastName());
		oldStudent.setAddress(student.getAddress());
		oldStudent.setRut(student.getRut());
		return new ResponseEntity<>(studentService.save(oldStudent), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/students/{id}")
	public ResponseEntity<Student> delete(@PathVariable Long id) {
		Student oldStudent = studentService.findById(id);
		studentService.delete(id);
		return new ResponseEntity<>(oldStudent, HttpStatus.OK);
	}
}
