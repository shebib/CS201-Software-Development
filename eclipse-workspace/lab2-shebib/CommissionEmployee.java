
public class CommissionEmployee extends SalariedEmployee{
	private double salesTotal;
	private double commissionPercentage;
	
	public CommissionEmployee(String firstname, String lastname, String birthday, int employeeID, String jobtitle, String company, double salary, double salesTotal, double commissionPercentage)
	{
		super(firstname, lastname, birthday, employeeID, jobtitle, company, salary);
		this.salesTotal=salesTotal;
		this.commissionPercentage=commissionPercentage;
	}
	
	public double getAnnualSalary()
	{
		return(salesTotal*commissionPercentage);
	}
	
	
}
