package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
	 * This will create a button called "secondButton"
	 */
	private JButton secondButton;
	/**
	 * This will create a button called "sendButton"
	 */
	private JButton sendButton;
	/**
	 * This will create a button called "submitButton"
	 */
	private JButton submitButton;
	/**
	 * This will create a button called "saveButton"
	 */
	private JButton saveButton;
	/**
	 * This will create a button called "loadButton"
	 */
	private JButton loadButton;
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
	/**
	 * This is the ScrollPane for the chatArea to allow the user to scroll.
	 */
	private JScrollPane chatPane;
	
	/**
	 * This will create the Panel for the text to go into
	 * @param baseController The controller is for the panel.
	 */
	public ChatbotPanel(ChatbotAppController baseController) 
	{
		this.baseController = baseController;
		

		secondButton = new JButton("Click here to talk about something");
		sendButton = new JButton("Send");
		submitButton = new JButton("Submit Text");
		saveButton = new JButton("Save Text");
		loadButton = new JButton("Load Text");
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
	
	/**
	 * This will setup the pane for the ChatArea.
	 */
	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true); //ask about what this means "setWrapStyleWord"
		chatArea.setEditable(false);
	}

	/**
	 * This will setup the Panel that everything sits inside (not the JFrame)
	 */
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(secondButton);
		this.add(sendButton);
		this.add(submitButton);
		this.add(loadButton);
		this.add(saveButton);
		this.add(firstTextField);
		this.add(chatPane);
	}
	
	/**
	 * This is the layout for the entire app, and where everything is located.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, secondButton, 0, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, secondButton, 0, SpringLayout.WEST, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 6, SpringLayout.SOUTH, secondButton);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 6, SpringLayout.EAST, submitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 6, SpringLayout.SOUTH, secondButton);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sendButton, 1, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, sendButton, 6, SpringLayout.EAST, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 0, SpringLayout.WEST, submitButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 6, SpringLayout.EAST, loadButton);
	}
	
	/**
	 * This will make listeners (buttons) for the user to click on and to interact with the App.
	 */
	private void setupListeners()
	{
		
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
				firstTextField.requestFocus();
			}
			
			
		});
		
		sendButton.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
				String userTypedText = firstTextField.getText();
				String chatbotResponse = baseController.sendTextToChatBot(userTypedText);
				displayTextToUser(userTypedText);
				displayTextToUser(chatbotResponse);
				firstTextField.setText("");
				firstTextField.requestFocus();
			}

			public void keyTyped(KeyEvent e)
			{
				
			}

			public void keyPressed(KeyEvent e)
			{
				
			}
		});
		
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent click)
			{
				String chat = chatArea.getText();
				baseController.saveText(chat, true);
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String savedChat = baseController.readTextFromFile();
				{
					if(savedChat.length()<1)
					{
						chatArea.setText("no text in file");
					}
					else
					{
						chatArea.setText(savedChat);
					}
				}
			}
		});
		
	}
	
	/**
	 * This will display the text to the user inside the area.
	 * @param input The input of chatbot to the user.
	 */
	public void displayTextToUser(String input)
	{
		chatArea.append("\n" + input);
	}
	
}
