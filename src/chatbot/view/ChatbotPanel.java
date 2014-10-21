package chatbot.view;

import javax.swing.JPanel;

import chatbot.controller.ChatbotAppController;

public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;
	public ChatbotPanel(ChatbotAppController baseController) 
	{
		this.baseController = baseController;
	}

}
