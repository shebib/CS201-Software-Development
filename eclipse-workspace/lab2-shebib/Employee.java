
public abstract class Employee extends Person{
	private int employeeID;
	private String jobtitle;
	private String company;
	
	public Employee(String firstname, String lastname, String birthday, int employeeID, String jobtitle, String company)
	{
		super(firstname, lastname, birthday);
		this.employeeID=employeeID;
		this.jobtitle=jobtitle;
		this.company=company;
	}
	
	public void printDetails()
	{
		super.printDetails();
		System.out.println("Title and Company: " + jobtitle + "at "+ company);
		System.out.println("ID: " + employeeID);
	}
	
	public int getEmployeeID()
	{
		return employeeID;
	}
	
	public String getJobTitle()
	{
		return jobtitle;
	}
	
	public String getCompany()
	{
		return company;
	}
	
	
	public abstract double getAnnualSalary();
}
