package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.controller.ChatbotAppController;
/**
 * This is the View for Chatbot and has the basController contents.
 * @author zcon5199
 * 
 */
public class ChatbotView
{
	/**
	 * This will create the AppConroller and call is baseController.
	 */
	private ChatbotAppController baseController;
	
	/**
	 * This is the View that Chatbot uses.
	 * @param baseController Is the controller for the app.
	 */
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
		
		result = JOptionPane.showInputDialog(null, baseController.getMySillyChatbot().getName() + " says: " + currentInput);
		
		return result;
	}
	
	/**
	 * Shows a String from the Chatbot as a popup window.
	 * @param currentInput The string from the Chatbot.
	 */
	public void showChatbotMessage(String currentInput)
	{
		JOptionPane.showMessageDialog(null, baseController.getMySillyChatbot().getName() + " says: " + currentInput);
	}
	
}
