import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

/**
 * Main console interface for the program. Handles input and some processing
 * @author Daniel Shebib
 */
public class MainInterface {

	private Gson gson;
	private Students students;
	private boolean exit;
	private Scanner sysin;
	private String filename;
	
	/**
	 * Constructor, also runs the interface and stays until exit() is called
	 */
	public MainInterface()
	{
		gson = new Gson();
		sysin=new Scanner(System.in);
		System.out.println("Starting As1...");
		exit = false;
		this.readJson();
		while(!exit)
		{
			System.out.println("\t1) Display Roster");
			System.out.println("\t2) Add Student");
			System.out.println("\t3) Remove Student");
			System.out.println("\t4) Add Grade");
			System.out.println("\t5) Sort Roster");
			System.out.println("\t6) Write File");
			System.out.println("\t7) Exit");
			System.out.println("Please select a number between 1-7");
			int choice = -1;
			try {
			choice = sysin.nextInt();
			}
			catch (InputMismatchException e)
			{
				e.printStackTrace();
				System.out.println("Error: Not an int");
			}
			if(choice < 1 || choice > 7)
				System.out.println("Error: Invalid choice");
			else
			{
				switch(choice)
				{
				case 1: this.displayRoster();
				break;
				case 2: this.addStudent();
				break;
				case 3: this.removeStudent();
				break;
				case 4: this.addGrade();
				break;
				case 5: this.sortRoster();
				break;
				case 6: this.writeFile();
				break;
				case 7: this.exit();
				break;
				}
			}
		}


	}
	
	/**
	 * Reads in Json from user-given file using gson
	 */
	public void readJson()
	{
		boolean read = false;
		while(!read)
		{
		System.out.println("Please enter the name of the file you would like to read from (must be in Json format). Enter 0 to exit.");
		filename = sysin.next();
		FileReader fileRead;
		try {
			if(filename.equals("0")) 
			{
				exit = true;
				return;
			}
			fileRead = new FileReader(new File(filename));
			System.out.println("Reading from file " + filename);
			//Type listType = new TypeToken<List<Student>>() {}.getType();
			students = gson.fromJson(fileRead, Students.class);
			fileRead.close();
			read = true;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Error: File not found");
			e1.printStackTrace();
		} catch (JsonSyntaxException e) {
			System.out.println("Error: Invalid json file format");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Could not close filereader");
			e.printStackTrace();
		}
		}
		if(students == null)
		{
			System.out.println("Error: file is empty. Creating empty list of students");
			students = new Students();
		}
	}
	
	/**
	 * Helper function to get a choice (index number) from the roster
	 * @return chosen index
	 */
	public int getChoice()
	{
		//TODO: bounds checking
		int i = 1;
		if(students.students.isEmpty())
		{
			System.out.println("List Empty!");
			return -1;
		}
		for(Student s : students.students)
		{
			System.out.println(i + ") " + s.toString());
			i++;
		}
		boolean got = false;
		int index = -1;
		while(!got) {
			try {
				index = sysin.nextInt()-1;
				if(index < 0 || index > students.students.size())
				{
					got = false;
					System.out.println("Error, please choose a valid int.");
				}
				else  
					got = true;
				}
			catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Please insert an Int");
			}
		}
		return index;
	}
	
	/**
	 * displays entire roster
	 */
	public void displayRoster()
	{
		if(students.students.isEmpty())
			System.out.println("List is empty!");
		else {
			for(Student s : students.students)
			{
				System.out.println(s.toString());
			}
		}
	}

	/**
	 * Queries a student's information then adds them to the roster
	 */
	public void addStudent()
	{
		System.out.println("First name?");
		String fname = sysin.next();
		System.out.println("Last name?");
		String lname = sysin.next();
		System.out.println("Average?");
		double average = sysin.nextDouble();
		System.out.println("Number of grades?");
		int numGrades = sysin.nextInt();
		students.addStudent(fname, lname, average, numGrades);
		System.out.println("Student added!");
	}

	/**
	 * Allows user to choose a student to remove, then removes the student
	 */
	public void removeStudent()
	{
		System.out.println("Choose a student to remove");
		int choice = getChoice();
		if (choice == -1)
			return;
		students.removeStudent(choice);
		System.out.println("Student removed!");
	}

	/**
	 * Choose a student, then add a grade to their file
	 * Grade must be from 0-100
	 */
	public void addGrade()
	{
		int index = getChoice();
		if(index==-1)
			return;
		boolean got = false;
		double grade = 0;
		while(!got)
		{
			try {
				System.out.println("Enter grade to be added");
				grade = sysin.nextDouble();
				if(0<= grade && grade <= 100)
					got=true;
				else
					System.out.println("Please enter a grade between 0-100");
			}
			catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Please enter a double");
			}
		}
		students.addGrade(index, grade);
		System.out.println("Grade added!");
	}
	
	/**
	 * Sorts the roster by either name or average
	 */
	public void sortRoster()
	{
		int choice = -1;
		boolean got = false;
		while(!got)
		{
			try {
				System.out.println("How would you like to sort your roster?");
				System.out.println("\t1) Last name, First name, GPA");
				System.out.println("\t2) GPA, Last name, First name");
				choice = sysin.nextInt();
				if(choice < 3 && choice > 0)
					got = true;
			}
			catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Please enter an int");
			}
		}
		if(choice == 1) //sort by name
		{
			Collections.sort(students.students, new Comparator<Student>() {
				public int compare(Student lhs, Student rhs) { //define Comparator
					if(lhs.getlname().compareTo(rhs.getlname())<0)
						return -1;
					else if (lhs.getlname().compareTo(rhs.getlname())>0)
						return 1;
					else 
					{
						if(lhs.getfname().compareTo(rhs.getfname())<0)
							return -1;
						else if (lhs.getfname().compareTo(rhs.getfname())>0)
							return 1;
						else 
						{
							if(lhs.getAverage()<rhs.getAverage())
							{
								return -1;
							}
							else if(lhs.getAverage()>rhs.getAverage())
							{
								return 1;
							}
							else
								return 0;
						}
					}
					}
				});
		}
		if(choice == 2) //sort by average
		{
			Collections.sort(students.students, new Comparator<Student>() {
				public int compare(Student lhs, Student rhs) {
					if(lhs.getAverage()<rhs.getAverage())
						return -1;
					else if (lhs.getAverage()>rhs.getAverage())
						return 1;
					else 
					{
						if(lhs.getlname().compareTo(rhs.getlname())<0)
							return -1;
						else if (lhs.getlname().compareTo(rhs.getlname())>0)
							return 1;
						else 
						{
							if(lhs.getfname().compareTo(rhs.getfname())<0)
							{
								return -1;
							}
							else if(lhs.getfname().compareTo(rhs.getfname())>0)
							{
								return 1;
							}
							else
								return 0;
						}
					}
					}
				});
		}
		
		System.out.println("Roster sorted!");
	}

	/**
	 * Output to currently opened file
	 */
	public void writeFile()
	{
		try {
		FileWriter writer = new FileWriter(filename);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String out = gson.toJson(students);
		writer.write(out);
		writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Could not output to file");
		}
		System.out.println("Successfully wrote to file");
	}

	/*
	 * exit program
	 */
	public void exit()
	{
		//TODO: bound checking
		System.out.println("Would you like to save changes?");
		System.out.println("1) Yes");
		System.out.println("2) No"); 
		boolean got = false;
		while(!got) {
			try {
				int choice = sysin.nextInt();
				if(choice < 1 || choice > 2)
				System.out.println("Error: Invalid value");
			if(choice == 1)
			{
				writeFile();
			}
			got = true;
			}
			catch (InputMismatchException e)
			{
				e.printStackTrace();
				System.out.println("Error: Invalid input");
			}
		}
		exit = true;
	}
}
	