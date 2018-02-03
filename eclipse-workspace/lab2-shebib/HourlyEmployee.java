
public class HourlyEmployee extends Employee{
	private double hourlyRate;
	private int numberHours;
	
	public HourlyEmployee(String firstname, String lastname, String birthday, int employeeID, String jobtitle, String company, double hourlyRate, int numberHours)
	{
		super(firstname, lastname, birthday, employeeID, jobtitle, company);
		this.hourlyRate=hourlyRate;
		this.numberHours=numberHours;
	}
	
	public double getAnnualSalary()
	{
		return hourlyRate*(double)numberHours*52;
	}
	
	public void printDetails()
	{
		super.printDetails();
		System.out.println("Annual Salary: " + this.getAnnualSalary());
	}
}
