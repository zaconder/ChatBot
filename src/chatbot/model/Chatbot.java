package chatbot.model;

import java.util.ArrayList;

/**
 * The chatbot model class. Used for checking and manipulationg Strings.
 * @author zcon5199
 * @version 1.1 9/26/14
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;
	
	/**
	 * Creates a Chatbot object with the supplied name and initializes the current number of chats to zero.
	 * @param name The supplied name for the Chatbot.
	 */
	public Chatbot(String name)
	{
		this.name = name;
		chatCount = 0;
	}
	
	/**
	 * Returns the name of the Chatbot object.
	 * @return The current name of the Chatbot.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * It will return the number of times the Chatbot has responded.
	 * @return The current number of chats
	 */
	public int getChatCount()
	{
		return chatCount;
	}
	
	/**
	 * Creates a string that shows the name of the user.
	 * @param name The new name for the chatbot.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Updates and adds one to the chat count everytime that param is called 
	 * @updateChatCount
	 */
	private void updateChatCount()
	{
		chatCount++;
	}
	
	/**
	 * Checks the input for a certain variable and will quit if true
	 * @param input If input is equal to sayonara than it will quit.
	 * @return okToQuit will check the input and return it's value of true or false.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input.equalsIgnoreCase("sayonara"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
}
