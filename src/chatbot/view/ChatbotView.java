package chatbot.view;

import javax.swing.JOptionPane;
import chatbot.model.Chatbot;

/**
 * 
 * @author Kyler Jensen
 *@version 1.2
 */
public class ChatbotView
{
	/**
	 * Chatbot element for the checkers and advanced string processing.
	 */
	private Chatbot myChatbot;
	
	public ChatbotView()
	{
		myChatbot = new Chatbot();
	}
	
	
	public void showApp()
	{
		String answer = "Keep going";
		
		while(answer == null || !answer.equals("yes"))
		{
			JOptionPane.showMessageDialog(null, myChatbot.getRandomTopic());
			answer = getInput();
			useInput(answer);
//			JOptionPane.showMessageDialog(null, "Ok thats interesting you said " + answer);

		}
		myChatbot.topicConversation();
		
		
	}
	
	
	private String getInput()
	{
		String userInput = "";
		
		userInput = JOptionPane.showInputDialog("Do you want to talk?");
		
		return userInput;
	}
	
	private void useInput(String currentInput)
	{
		JOptionPane.showMessageDialog(null, "Seriously?");
		
		if(myChatbot.memeChecker(currentInput))
		{
			JOptionPane.showMessageDialog(null, "you like memes huh?");
		}
		
		if(myChatbot.cowboyChecker(currentInput))
		{
			JOptionPane.showMessageDialog(null, "you like westerns?");
		}
		
	}
	
}
