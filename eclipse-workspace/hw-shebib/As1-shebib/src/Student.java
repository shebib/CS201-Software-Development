
/**
 * Student class, 1 for each student
 * @author Daniel Shebib
 *
 */
public class Student {
	private class Name{ //class to store the name (for json format)
		private String fname;
		private String lname;
	}
	private Name name;
	private double average;
	private int numGrades;
	
	public Student(String fname, String lname, double average, int numGrades)
	{
		this.name = new Name();
		this.name.fname = fname;
		this.name.lname=lname;
		this.average=average;
		this.numGrades=numGrades;
	}
	
	/**
	 * adds the given grade and updates numgrades
	 * @param grade grade to add
	 */
	public void addGrade(double grade)
	{
		average =(average*numGrades+grade)/(double)(numGrades+1);
		numGrades++;
	}
	
	public String toString()
	{
		return (name.lname + ", " + name.fname + " " + (int)Math.round(average));
	}
	
	public String getfname()
	{
		return name.fname;
	}

	public String getlname()
	{
		return name.lname;
	}
	
	public double getAverage()
	{
		return average;
	}
	
	public boolean equals(Student stu)
	{
		if((name.fname.equals(stu.name.fname))&&(name.lname.equals(stu.name.lname))
				&&(average==stu.average)&&(numGrades==stu.numGrades))
			return true;
		else
			return false;
	}

}
