package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotView;
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
	 * 
	 */
	private String contentMessages;
	/**
	 * Reference to the GUI JFrame object for the appliacation
	 */
	private ChatbotFrame appFrame;
	
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		appFrame = new ChatbotFrame(this);
		mySillyChatbot = new Chatbot("Derf");
		startMessage = "Welcome to the " + mySillyChatbot.getName() + " chatbot. What is your name?";
		quitMessage = "goodbye cruel user :(";
		contentMessages = "That's really cool I love riding motorcycles too!";
	}
	
	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}
	
	/**
	 * This will loop the quitChecker over and over until the "Correct" input is used.
	 */
	public void start()
	{
		String result = applicationView.showChatbot(startMessage);
			
//		while(!mySillyChatbot.quitChecker(result))
//		{
//			result = mySillyChatbot.processText(result);
//			result = applicationView.showChatbot(result);
//		}
//		quit();
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
