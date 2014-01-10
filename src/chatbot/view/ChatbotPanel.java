package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotController;
import chatbot.model.Chatbot;

/**
 * Creates the panel.
 * @author Kyler Jensen
 * @version 1.4 10/30/13
 *
 */
public class ChatbotPanel extends JPanel
{
//	Declaration Section
	private ChatbotController baseController;
	private JButton submitButton;
	private JTextField userInputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	private JScrollPane textPane;
	private Chatbot appBot;
	protected String currentInput;
	private int clickCount;

	
	
	/**
	 * Adds to the reference.
	 * @param baseController
	 */
	public ChatbotPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		this.appBot = baseController.getMyChatbot();
		
		
		submitButton = new JButton("Submit this to the Chatbot!");
		userInputField = new JTextField(30);
		chatArea = new JTextArea(10,35);
		textPane = new JScrollPane(chatArea);
		baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
		startChat();
	}
	/**
	 * puts a line from RandomTopic on  chatArea.
	 */
	private void startChat()
	{
		chatArea.setText(appBot.getRandomTopic());
	}
	/**
	 * sets up the panel.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.CYAN);
		this.add(submitButton);
		this.add(userInputField);
		this.add(textPane);
		
		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
	}
	/**
	 * sets the positioning of the objects on the panel.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 14, SpringLayout.SOUTH, textPane);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 83, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, userInputField, 17, SpringLayout.SOUTH, textPane);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 17, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 82, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 17, SpringLayout.SOUTH, userInputField);
		baseLayout.putConstraint(SpringLayout.WEST, userInputField, 102, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 143, SpringLayout.WEST, this);
		

	}
	/**
	 * listens for the user to click.
	 */
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{

			/**
			 * This is what happens when I click the button.
			 */
			public void actionPerformed(ActionEvent click)
			{
				clickCount ++;
				
				if(clickCount % 7 ==0)
				{
					String currentConversation = baseController.processConversation();
					if(currentConversation.length() != 0)
					{

						chatArea.append(currentConversation);
						clickCount--;
					}
				}
				else if(clickCount % 11 == 0)
				{
					chatArea.append(baseController.processMeme(currentInput));
				}
				else
				{
					String currentInput = userInputField.getText();
					chatArea.append("\n" + currentInput);
					chatArea.append("\n" + appBot.getRandomTopic());
					
				}
			}

		});
	}
}
