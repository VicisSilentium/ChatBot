package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatbotController;

/**
 * creates the frame for the chatbot.
 * @author Kyler Jensen
 * @version 1.2 10/30/13
 *
 */
public class ChatbotFrame extends JFrame
{
//	Declaration section
	private ChatbotController baseController;
	private ChatbotPanel basePanel;
	
	/**
	 * Adds to the reference.
	 * @param baseController
	 */
	public ChatbotFrame(ChatbotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatbotPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * Sets the frame size and visibility.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
}
