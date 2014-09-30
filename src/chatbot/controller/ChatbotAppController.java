package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

public class ChatbotAppController
{
	private ChatbotView applicationView;
	private Chatbot mySillyChatbot;
	
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		mySillyChatbot = new Chatbot("Derf");
	}
	/**
	 * This will loop the quitChecker over and over until the "Correct" input is used.
	 */
	public void start()
	{
		String result = applicationView.showChatbot("Zac");
			
		while(!mySillyChatbot.quitChecker(result))
		{
			result = applicationView.showChatbot(result);
		}
		
		quit();
	}
	/**
	 * If the "Correct" input is used, this will show the message and quit the application.
	 */
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "Goodbye cruel world");
		System.exit(0);
		
	}
	
}
