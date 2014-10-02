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
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		fillTheMemeList();
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
	
	private void fillTheMemeList()
	{
		memeList.add("Kitties");
		memeList.add("one does not simply");
		memeList.add("doge");
		memeList.add("Bad luck Brian");
		memeList.add("Toddler fist");
		memeList.add("y u no");
	}
	
	/**
	 * Processes input from the user against the checker methods.  Returns the next output for the view.
	 * @param currentInputThe supplied text.
	 * @return The Processed text based on checker or other methods.
	 */
	public String proccessText(String currentInput)
	{
		String result = "";
		
		if(memeChecker(currentInput))
		{
			result = "wow, " + currentInput + " is a meme, wohoo!";
		}
		else
		{
			result = "not a meme, try again";
		}
		
		return result;
	}
	/**
	 * Updates and adds one to the chat count everytime that param is called 
	 * @updateChatCount
	 */
	private void updateChatCount()
	{
		chatCount++;
	}
	
	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;
		
		for (String currentMeme : memeList)
		{
			if(input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}
		
		for(int loopCounter = 0; loopCounter < memeList.size(); loopCounter++)
		{
			if(input.equalsIgnoreCase(memeList.get(loopCounter)))
			{
				isAMeme = true;
			}
		}
		
		return isAMeme;
	}
	/**
	 * Checks the input for a certain variable and will quit if true
	 * @param input If input is equal to sayonara than it will quit.
	 * @return okToQuit will check the input and return it's value of true or false.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input != null && input.equalsIgnoreCase("sayonara"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
}
