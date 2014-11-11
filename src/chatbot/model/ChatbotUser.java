package chatbot.model;

public class ChatbotUser
{
	private String userName;
	private int age;
	private boolean hasTattoos;
	private boolean needsCorrectiveLenses;
	private double weight;
	
	public ChatbotUser()
	{
		this.userName = "";
		this.age = -999;
		this.hasTattoos = false;
		this.needsCorrectiveLenses = false;
		this.weight = -45.7876;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public boolean hasTattoos()
	{
		return hasTattoos;
	}
	
	public boolean needsCorrectiveLenses()
	{
		return needsCorrectiveLenses;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public void setAge(int userAge)
	{
		this.age = userAge;
	}
}
