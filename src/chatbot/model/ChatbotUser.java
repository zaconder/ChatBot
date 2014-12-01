package chatbot.model;

/**
 * This is the user that the client will create.
 * @author zcon5199
 *
 */
public class ChatbotUser
{
	/**
	 * This is the userName for the client.
	 */
	private String userName;
	
	/**
	 * This is the userAge for the client.
	 */
	private int age;
	
	/**
	 * Will ask if the user hasTattoos or not.
	 */
	private boolean hasTattoos;
	
	/**
	 * Will ask if the user needsCorrectiveLenses.
	 */
	private boolean needsCorrectiveLenses;
	
	/**
	 * will ask how much the user weighs.
	 */
	private double weight;
	
	/**
	 * Will build the client's responses.
	 */
	public ChatbotUser()
	{
		this.userName = "";
		this.age = -999;
		this.hasTattoos = false;
		this.needsCorrectiveLenses = false;
		this.weight = -45.7876;
	}
	
	/**
	 * Will get the userName for the user.
	 * @return Returns the name of the input for the user.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Will get the Age for the user.
	 * @return Returns the age of the input for the user.
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * Will check to see if the user has tattoos or not.
	 * @return Will return true or false depending on what the user said.
	 */
	public boolean hasTattoos()
	{
		return hasTattoos;
	}
	
	/**
	 * Will check to see if the user needs corrective lenses or not.
	 * @return Will return true or false depending on what the user said.
	 */
	public boolean needsCorrectiveLenses()
	{
		return needsCorrectiveLenses;
	}
	
	/**
	 * Will get the weight of the user.
	 * @return Will return the weight of the user for what he inputed.
	 */
	public double getWeight()
	{
		return weight;
	}
	
	/**
	 * Once the user name is specified, it will store the user name.
	 * @param userName The users name
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	/**
	 * Once the users weight is specified, it will store the weight.
	 * @param weight The users weight.
	 */
	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	/**
	 * Once the age is specified, it will store the age.
	 * @param userAge The users weight.
	 */
	public void setAge(int userAge)
	{
		this.age = userAge;
	}

	/**
	 * Once the user has specified whether or not he has tattoos, it will store the response.
	 * @param userTatts The users response of "yes" or "no".
	 */
	public void setHasTattoos(boolean userTatts)
	{
		this.hasTattoos = false;
	}

	/**
	 * Once the user has specified whether or not he needs corrective lenses, it will store the response.
	 * @param userLenses The users response of "yes" or "no".
	 */
	public void setNeedsCorrectiveLenses(boolean userLenses)
	{
		this.needsCorrectiveLenses = false;
	}

}
