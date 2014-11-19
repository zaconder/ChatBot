package chatbot.model;

import java.util.ArrayList;

/**
 * The chatbot model class. Used for checking and manipulating Strings.
 * @author zcon5199
 * @version 1.5 11/19/14 Added some new methodes for the process text.
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;
	private String contentMessages;
	private ArrayList<String> contentList;
	private ChatbotUser myUser;
	private ArrayList<String> userInputList;
	
	/**
	 * Creates a Chatbot object with the supplied name and initializes the current number of chats to zero.
	 *
	 * @param name The supplied name for the Chatbot.
	 */
	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();
		contentList = new ArrayList<String>();
		userInputList = new ArrayList<String>();
		this.name = name;
		setContentMessages("");
		chatCount = 0;
		fillTheMemeList();
		fillTheContentList();
		myUser = new ChatbotUser();
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
	
	public boolean contentChecker(String input)
	{
		boolean contentMessages = false;
		
		if(input != null && input.contains("motorcycle"))
		{
			contentMessages = true;
		}
		
		return contentMessages;
		
	}
	
	private boolean stringLengthChecker(String input)
	{
		boolean isFour = false;
		
		if (input.length() >= 10)
		{
			isFour = true;
		}
		return isFour;
	}
	
	public String processText(String currentInput)
	{
		String result = "";
		
		if(getChatCount() < 5)
		{
			result = introduceUser(currentInput);
		}
		else if (currentInput != null && currentInput.length() > 0)
		{
			result = introduceUser(currentInput);
		}
		else
		{
			result = "use words!!!";
			chatCount--;
		}
		updateChatCount();
		return result;
	}
	
	private String introduceUser(String input)
	{
		String userQuestion = "";
		
		if(getChatCount() == 0)
		{
			myUser.setUserName(input);
			userQuestion = "Good name " + myUser.getUserName() + " how old are you?";
		}
		else if(getChatCount() == 1)
		{
			int userAge = Integer.parseInt(input);
			myUser.setAge(userAge);
			userQuestion = "Garsh, you are really old " + myUser.getUserName() + " how much do you weigh?";
		}
		else if(getChatCount() == 2)
		{
			double userWeight = Double.parseDouble(input);
			myUser.setWeight(userWeight);
			userQuestion = "Yikes that is a lot less than a dwarf star " + myUser.getUserName() + " do you have tattoos?";
		}
		else if(getChatCount() == 3)
		{
			boolean userTatts = Boolean.parseBoolean(input);
			myUser.setHasTattoos(userTatts);
			userQuestion = "That's cool, I like tattoos " + myUser.getUserName() + " do you have corrective lenses?";
		}
		else
		{
			boolean userLenses = Boolean.parseBoolean(input);
			myUser.setNeedsCorrectiveLenses(userLenses);
			userQuestion = "I love my glasses :D " + myUser.getUserName() + " What do you want to talk about??";
		}
		
		return userQuestion;
	}
		
	private String randomChatConversation(String input)
	{
		String conversation = "";
		
		int randomPosition = (int) (Math.random() * 6);
		if (randomPosition == 0)
		{
			if (stringLengthChecker(input))
			{
				conversation = "too long";
			}
			else
			{
				conversation = "short words";
			}
		}
		else if (randomPosition == 1)
		{
			if (contentChecker(input))
			{
				conversation = "That's really cool I love motorcycles";
			}
			else
			{
				conversation = "Try other words!";
			}
		}
		else if(randomPosition == 2)
		{
			if (memeChecker(input))
			{
				conversation = "Wow, " + input + " is a meme, wahoo!";
			}
			else
			{
				conversation = "not a meme, try again";
			}
		}
		else if(randomPosition == 3)
		{
			//Talk about the user here :D
		}
		else if(randomPosition == 4)
		{
			//add to our list
			userInputList.add(input);
			conversation = "Thank you for the comment";
		}
		else
		{
			if (userInputChecker(input))
			{
				conversation = "That  was nice  you removed it from the list";
			}
			else
			{
				conversation = "that wasn't in the conversation before";
			}
		}
		return conversation;
	}
	
	/**
	 * Provides output based on the ChatbotUser object. Uses a switch/case structure for testing.
	 * @param userInput 
	 * @return 
	 */
	public String userTopic(String userInput)
	{
		String userBasedResponse = "";
		
		int randomUserTopic = (int) (Math.random() * 6);
		
		switch(randomUserTopic)
		{
			case 1:
				userBasedResponse = myUser.hasTattoos() + " is the response to tattoos :D";
				break;
			case 0:
				userBasedResponse = myUser.getUserName() + " is a silly name :P";
				break;
			default:
				userBasedResponse = myUser.getAge() + " is reallllly reallllllly old";
				break;
		}
		
		return userBasedResponse;
	}
	
	private boolean userInputChecker(String userInput)
	{
		boolean matchesInput = false;
		
		for(int loopCount = 0; loopCount < userInputList.size(); loopCount++)
		{
			if(userInput.equalsIgnoreCase(userInputList.get(loopCount)))
			{
				matchesInput = true;
				userInputList.remove(loopCount);
				loopCount--;
				//You have to have a -- if you're removing a from a list.
			}
		}
		return matchesInput;
	}
	
	public String getContentMessages()
	{
		return contentMessages;
	}

	public void setContentMessages(String contentMessages)
	{
		this.contentMessages = contentMessages;
	}
	
}
