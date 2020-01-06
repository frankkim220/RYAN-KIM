
public class Student
{
	private String myName;
	private int myGrade;
	private String myParentEmail;
	private String myParentPhone;
	private String myInstrument;
	
	public Student(String name, int grade, String parentEmail, String parentPhone, String instrument)
	{
		myName = name;
		myGrade = grade;
		myParentEmail = parentEmail;
		myParentPhone = parentPhone;
		myInstrument = instrument;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public int getGrade()
	{
		return myGrade;
	}
	
	public String getParentEmail()
	{
		return myParentEmail;
	}
	
	public String getParentPhone()
	{
		return myParentPhone;
	}
	
	public String getInstrument()
	{
		return myInstrument;
	}
	
	public void setName(String name)
	{
		myName = name;
	}
	
	public void setGrade(int grade)
	{
		myGrade = grade;
	}
	
	public void setParentEmail(String parentEmail)
	{
		myParentEmail = parentEmail;
	}
	
	public void setParentPhone(String parentPhone)
	{
		myParentPhone = parentPhone;
	}
	
	public void setInstrument(String instrument)
	{
		myInstrument = instrument;
	}
}