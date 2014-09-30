package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.controller.ChatbotAppController;

public class ChatbotView
{
	private ChatbotAppController baseController;
	
	public ChatbotView(ChatbotAppController baseController)
	{
		this.baseController = baseController;
	}
	/**
	 * Will show the user the message and add what ever input they put in the text box to the next GUI screen.
	 * @param currentInput This is what ever the user inputed.
	 * @return this will return a new GUI screen once the user has promted it.
	 */
	public String showChatbot(String currentInput)
	{
		String result = "";
		
		JOptionPane.showMessageDialog(null, "Hello, " + currentInput);
		result = JOptionPane.showInputDialog(null, "Are you done?");
		
		return result;
	}
}
