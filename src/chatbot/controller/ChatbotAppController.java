package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.view.ChatbotView;

public class ChatbotAppController
{
	private ChatbotView applicationView;
	
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
	}
	
	public void start()
	{
		String result = applicationView.showChatbot("Zac");
		
		if (result.equalsIgnoreCase("exit"))
		{
			quit();
		}
	}
	
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "Good bye cruel world");
		System.exit(0);
		
	}
	
}
