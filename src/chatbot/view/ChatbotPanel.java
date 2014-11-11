package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotAppController;
import javax.swing.*;
import chatbot.model.Chatbot;

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
	
	private JButton secondButton;
	
	private JButton sendButton;
	
	/**
	 * this will Create a TextField called "firstTextField"
	 */
	private JTextField firstTextField;
	/**
	 * This will call the SpringLayout method and names it "baseLayout"
	 */
	private SpringLayout baseLayout;
	/**
	 * This will make the ChatbotPanel and adds the parameters 
	 * @param baseController
	 */
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	public ChatbotPanel(ChatbotAppController baseController) 
	{
		this.baseController = baseController;
		
		firstButton = new JButton("click the button to add a -:D");
		secondButton = new JButton("Click here to talk about something");
		sendButton = new JButton("Send");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(15, 30);
		chatArea.setEditable(false);
		chatPane = new JScrollPane(chatArea);
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true); //ask about what this means "setWrapStyleWord"
	}

	private void setupPanel()
	{
		this.setBackground(Color.ORANGE);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(secondButton);
		this.add(sendButton);
		this.add(firstTextField);
		this.add(chatPane);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -39, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sendButton, 1, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, sendButton, 6, SpringLayout.EAST, firstTextField);
		baseLayout.putConstraint(SpringLayout.SOUTH, secondButton, -6, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -10, SpringLayout.EAST, firstTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, secondButton, 0, SpringLayout.WEST, chatPane);
	}
	
	private void setupListeners()
	{

		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				chatArea.setText(chatArea.getText()+ " -:D");
			}
		});
		
		secondButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				chatArea.setText("What do you think about Motorcycles?"); //Eventually make it so it grabs the answer from a random list.
			}
		});
		
		sendButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userTypedText = firstTextField.getText();
				String chatbotResponse = baseController.sendTextToChatBot(userTypedText);
				displayTextToUser(userTypedText);
				displayTextToUser(chatbotResponse);
				firstTextField.setText("");
			}
		});
		
	}
	public void displayTextToUser(String input)
	{
		chatArea.append("\n" + input);
	}
	
}
