import java.util.ArrayList;
import java.util.List;

/**
 * A container to store the students list and make basic changes
 * @author Daniel Shebib
 *
 */
public class Students {
	public List<Student> students;
	
	public Students()//constructor
	{
		students = new ArrayList<Student>();
	}
	
	/**
	 * adds a student with the specified details. Checks for duplicates first
	 * @param fname first name
	 * @param lname last name
	 * @param average average
	 * @param numGrades number of grades
	 */
	public void addStudent(String fname, String lname, double average, int numGrades)
	{
		boolean dup = false;
		Student stu = new Student(fname, lname, average, numGrades);
		for(Student s : students)
		{
			if(s.equals(stu))
				dup = true;
		}
		if(dup)
			return;
		students.add(stu);
	}
	
	/** Removes a student from the given index
	 *
	 * @param index index to remove
	 */
	public void removeStudent(int index)
	{
		students.remove(index);
	}
	
	/**
	 * adds a grade to the student at index
	 * @param index index of student
	 * @param grade grade to add
	 */
	public void addGrade(int index, double grade)
	{
		students.get(index).addGrade(grade);
	}
}
