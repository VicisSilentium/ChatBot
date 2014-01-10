package chatbot.controller;

import java.util.ArrayList;
import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotView;

/**
 * 
 * @author Kyler Jensen
 * @version 1.3 10/31/13 Removed old GUI, reference to Chatbot.
 */
public class ChatbotController
{
	//Declaration Section
//	private ChatbotView myView;
	private Chatbot myChatbot;
	private ChatbotFrame appFrame;
	
	/**
	 * Constructor for the class.
	 */
	public ChatbotController()
	{
//		myView = new ChatbotView();
		myChatbot = new Chatbot();
	}
	
	/**
	 * Getter for chatbot.
	 * @return
	 */
	public Chatbot getMyChatbot()
	{
		return myChatbot;
	}
		/**
	 * starts the program.
	 */
	public void start()
	{
		appFrame = new ChatbotFrame(this);
	}
	
	private String conversationHelper(ArrayList<String> conversationList)
	{
		String currentConversationPeice = "";
		
		if(conversationList.size() > 0)
		{
			currentConversationPeice = conversationList.remove(0);
		}
		
		return currentConversationPeice;
	}
	
	public String processConversation()
	{
		String currentConversation = "";
		
		currentConversation = conversationHelper(myChatbot.topicConversation());
		
		return currentConversation;
	}
	
	public String processMeme(String currentInput)
	{
		String memeResponse = "you don't like memes?";
		
		if(myChatbot.memeChecker(currentInput))
		{
			memeResponse = currentInput + "is a cool meme";
		}
		
		return memeResponse;		
	}
}
