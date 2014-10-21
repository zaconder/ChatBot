package chatbot.model;

import java.util.ArrayList;

/**
 * The chatbot model class. Used for checking and manipulating Strings.
 * @author zcon5199
 * @version 1.1 9/26/14
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;
	private String contentArea;
	private ArrayList<String> contentList;
	
	/**
	 * Creates a Chatbot object with the supplied name and initializes the current number of chats to zero.

	 * @param name The supplied name for the Chatbot.
	 */
	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();
		contentList = new ArrayList<String>();
		this.name = name;
		contentArea = "";
		chatCount = 0;
		fillTheMemeList();
		fillTheContentList();
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
	
	private void fillTheContentList()
	{
		contentList.add("motorcycles");
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
	
	public boolean contentChecker(String currentInput)
	{
		boolean contentMessages = false;
		
		if(currentInput != null && currentInput.contains("motorcycle"))
		{
			contentMessages = true;
		}
		
		return contentMessages;
		
	}
	
	private boolean stringLengthChecker(String input)
	{
		boolean isFour = false;
		
		if (input.length() >= 20)
		{
			isFour = true;
		}
		return isFour;
	}
	
	public String processText(String currentInput)
	{
		String result = "";
		
		int randomPosition = (int) (Math.random() * 3);
		if (currentInput != null)
		{
			if (randomPosition == 0)
			{
				if (stringLengthChecker(currentInput))
				{
					result = "too long";
				}
				else
				{
					result = "short words";
				}
			}
			else if (randomPosition == 1)
			{
				if (contentChecker(currentInput))
				{
					result = "That's really cool I love motorcycles";
				}
				else
				{
					result = "Try other words!";
				}
			}
			else
			{
				if (memeChecker(currentInput))
				{
					result = "Wow, " + currentInput + " is a meme, wahoo!";
				}
				else
				{
					result = "not a meme, try again";
				}
			}
		}
		return result;
	}
	
}
