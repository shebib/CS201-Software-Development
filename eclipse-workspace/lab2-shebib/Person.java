
public class Person {
	private String firstname;
	private String lastname;
	private String birthday;

	public Person(String firstname, String lastname, String birthday) 
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.birthday=birthday;
	}
	
	public void printDetails()
	{
		System.out.println("Name: " + firstname + " " + lastname);
		System.out.println("Birthday: " + birthday);
	}
	
	public String getFirstName()
	{
		return firstname;
	}
	
	public String getLastName()
	{
		return lastname;
	}
	
	public String getBirthdate()
	{
		return birthday;
	}
}
