package chatbot.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotAppController;


public class ChatbotPanel extends JPanel
{
	/**
	 * This will call the ChatbotAppController and names it "baseController"
	 */
	private ChatbotAppController baseController;
	/**
	 * This will create a button called "firstButton"
	 */
	private JButton firstButton;
	/**
	 * this will Create a TextField called "firstTextField"
	 */
	private JTextField firstTextField;
	/**
	 * This will call the SpringLayout method and names it "baseLayout"
	 */
	private SpringLayout baseLayout;
	
	public ChatbotPanel(ChatbotAppController baseController) 
	{
		this.baseController = baseController;
		
		firstButton = new JButton("click the button... it is so clicky :D");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setBackground(Color.MAGENTA);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 157, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 153, SpringLayout.WEST, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -39, SpringLayout.SOUTH, this);
		
	}
	
	private void setupListeners()
	{
		
	}
	
}
