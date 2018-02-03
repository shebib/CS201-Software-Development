
public class SalariedEmployee extends Employee{
	private double annualsalary;
	
	public SalariedEmployee(String firstname, String lastname, String birthday, int employeeID, String jobtitle, String company, double annualsalary)
	{
		super(firstname, lastname, birthday, employeeID, jobtitle, company);
		this.annualsalary=annualsalary;
	}
	
	public double getAnnualSalary()
	{
		return annualsalary;
	}
	
	public void printDetails()
	{
		super.printDetails();
		System.out.println("Annual Salary: " + (int)this.getAnnualSalary());
	}
}
