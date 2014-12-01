package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotView;
import chatbot.view.ChatbotPanel;
/**
 * Runs the Chatbot Project. Owns the model and associated views
 * @author Zac Conder
 * @version 1.2 10/2/14 - cleaned the quit method.
 */
public class ChatbotAppController
{
	/**
	 * 
	 */
	private ChatbotView applicationView;
	/**
	 * The instance of the chatbot, the Model of this application
	 */
	private Chatbot mySillyChatbot;
	/**
	 * The message used when starting the application
	 */
	private String startMessage;
	/**
	 * The message proved when the user quits the application
	 */
	private String quitMessage;
	/**
	 * This is the String that has the contentMessages.
	 */
	private String contentMessages;
	/**
	 * Reference to the GUI JFrame object for the application.
	 */
	private ChatbotFrame baseFrame;
	/**
	 * This is the controller for Chatbot and will build everything.
	 */
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		baseFrame = new ChatbotFrame(this);
		mySillyChatbot = new Chatbot("Derf");
		startMessage = "Welcome to the " + mySillyChatbot.getName() + " chatbot. What is your name?";
		quitMessage = "goodbye cruel user :(";
		contentMessages = "That's really cool I love riding motorcycles too!";
	}
	
	/**
	 * This will the Chatbot.
	 * @return will Return the chatbot.
	 */
	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}
	
	/**
	 * This will loop the quitChecker over and over until the "Correct" input is used.
	 */
	public void start()
	{
		ChatbotPanel myAppPanel = (ChatbotPanel) baseFrame.getContentPane();
		myAppPanel.displayTextToUser(startMessage);
		
		
//		String result = applicationView.showChatbot(startMessage);
			
//		while(!mySillyChatbot.quitChecker(result))
//		{
//			result = mySillyChatbot.processText(result);
//			result = applicationView.showChatbot(result);
//		}
//		quit();
	}
	
	/**
	 * Transmits information from the View package to the Chatbot.
	 * @param userInput The user supplied text.
	 * @return The chatbot processed text.
	 */
	public String sendTextToChatBot(String userInput)
	{
		String respondText = "";
		
		respondText = mySillyChatbot.processText(userInput);
		
		return respondText;
	}
	/**
	 * If the "Correct" input is used, this will show the message and quit the application.
	 */
	private void quit()
	{
		applicationView.showChatbotMessage(quitMessage);
		System.exit(0);
		
	}
	
}
