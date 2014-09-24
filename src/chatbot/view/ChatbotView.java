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
	
	public String showChatbot(String currentInput)
	{
		String result = "";
		
		JOptionPane.showMessageDialog(null, "Hello, " + currentInput);
		result = JOptionPane.showInputDialog(null, "Are you done?");
		
		return result;
	}
}
