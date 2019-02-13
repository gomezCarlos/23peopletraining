package hello.school;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolApplicationTests {

	Course course = new Course();
	Student student = new Student();
	
	@Autowired
	StudentService studentService;
	
	@Before
	public void init() {
		course.setCode("001");
		course.setId(1L);
		course.setName("Calculo I");
		//student.setId(2L);
		student.setFirstName("Firstony");
		student.setLastName("Laster");
		student.setRut("00.000.000-0");
	}
	@Test
	public void testPojo() {
		
			Assert.assertNotNull(student);	
	}
	
	@Test
	public void testSave() {
		Student saved = studentService.save(student);
		Assert.assertNotNull(student);
	}

}

