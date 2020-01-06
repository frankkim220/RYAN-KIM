
public class Member
{
	private String myName;
	private int myGrade;
	private String myEmail;
	private String myPhone;
	private String myStudents;
	private String myInstruments;
	private int myHours;
	
	public Member(String name, int grade, String email, String phone, int hours, String students, String instruments)
	{
		myName = name;
		myGrade = grade;
		myEmail = email;
		myPhone = phone;
		myStudents = students;
		myInstruments = instruments;
		myHours = hours;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public int getGrade()
	{
		return myGrade;
	}
	
	public String getEmail()
	{
		return myEmail;
	}
	
	public String getPhone()
	{
		return myPhone;
	}
	
	public String getStudents()
	{
		return myStudents;
	}
	
	public String getInstruments()
	{
		return myInstruments;
	}
	
	public int getHours()
	{
		return myHours;
	}
	
	public void setName(String name)
	{
		myName = name;
	}
	
	public void setGrade(int grade)
	{
		myGrade = grade;
	}
	
	public void setEmail(String email)
	{
		myEmail = email;
	}
	
	public void setPhone(String phone)
	{
		myPhone = phone;
	}
	
	public void setStudents(String students)
	{
		myStudents = students;
	}
	
	public void setInstruments(String instruments)
	{
		myInstruments = instruments;
	}
	
	public void setHours(int hours)
	{
		myHours = hours;
	}
}