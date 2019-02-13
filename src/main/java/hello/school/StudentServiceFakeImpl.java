package hello.school;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceFakeImpl implements StudentService {
	
	Map<Long, Student> students = new HashMap<>();

	int index=0;
	@Override
	public Page<Student> getStudents(Pageable pageable) {
		return new Page<Student>() {

			@Override
			public int getNumber() {
				return pageable.getPageNumber();
			}

			@Override
			public int getSize() {
				return pageable.getPageSize();
			}

			@Override
			public int getNumberOfElements() {
				return students.size();
			}

			@Override
			public List<Student> getContent() {
				List<Student> list = new ArrayList<>();
				list.addAll(students.values());
				return list;
			}

			@Override
			public boolean hasContent() {
				return (!students.isEmpty());
			}

			@Override
			public Sort getSort() {
				return null;
			}

			@Override
			public boolean isFirst() {
				return true;
			}

			@Override
			public boolean isLast() {
				return false;
			}

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public boolean hasPrevious() {
				return false;
			}

			@Override
			public Pageable nextPageable() {
				return null;
			}

			@Override
			public Pageable previousPageable() {
				return null;
			}

			@Override
			public Iterator<Student> iterator() {
				return students.values().iterator();
			}

			@Override
			public int getTotalPages() {
				return 0;
			}

			@Override
			public long getTotalElements() {
				
				return students.size();
			}

			@Override
			public <U> Page<U> map(Function<? super Student, ? extends U> converter) {
				return null;
			}

			
		};
	}

	@Override
	public Student save(Student student) {
		
		student.setId(++index+0L);
		students.put(index +0L, student);
		return student;
	}

	@Override
	public void delete(Long id) {
		students.remove(id);
	}

	@Override
	public Student findById(Long id) {
		
		return students.get(id);
	}

	@Override
	public List<Student> findAll() {
		List<Student> list = new ArrayList<>();
		list.addAll(students.values());
		return list;
	}

}