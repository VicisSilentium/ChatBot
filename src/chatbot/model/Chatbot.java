package chatbot.model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Explanation of the class: Chatbot model to test String manipulation and use.
 * @author Kyler Jensen
 * @version 1.5	10/30/13
 * 
 * 
 */
public class Chatbot
{
	//Declaration Section
	/**
	 * An ArrayList of Strings that holds the memes for the program.
	 */
	private ArrayList<String> myMemes;
	/**
	 * An ArrayList of Strings that holds the cowboy phrases for the program.
	 */
	private ArrayList<String> myCowboy;
	/**
	 * An ArrayList of Strings to hold random topics.
	 */
	private ArrayList<String> randomList;
	
	private ArrayList<String> conversationList;
	
	/**
	 *  Constructor for the class.
	 */
	public Chatbot()
	{
		myMemes = new ArrayList<String>();
		myCowboy = new ArrayList<String>();
		randomList = new ArrayList<String>();
		conversationList = new ArrayList<String>();

		fillTheMemeList();
		fillTheCowboyList();
		fillTheRandomList();
		topicConversation();
		fillTheConversationList();
	}

	/**
	 * getter for the memeList.
	 * @return
	 */
	public ArrayList<String> getMyMemes()

	{
		return myMemes;
	}
	/**
	 * getter for the cowboyList.
	 * @return
	 */
	public ArrayList<String> getMyCowboy()

	{
		return myCowboy;
	}
	/**
	 * getter for the randomList
	 * @return
	 */
	public ArrayList<String> getRandomList()
	{
		return randomList;
	}
	
	
	public ArrayList<String> getConversationList()
	{
		return conversationList;
	}

	/**
	 * A list of items for the Chatbot to check.
	 */
	private void fillTheMemeList()
	{
		myMemes.add("nicolas cage");
		myMemes.add("arrow to the knee");
		myMemes.add("one does not simply");
		myMemes.add("y u no");
	}
	
	/**
	 * A list of items for the Chatbot to check.
	 */
	private void fillTheCowboyList()
	{
		myCowboy.add("howdy");
		myCowboy.add("woody");
		myCowboy.add("theres a snake in my boot");
		myCowboy.add("reach for the sky");
		myCowboy.add("sherriff");
		myCowboy.add("gettie up");
		myCowboy.add("lasso");
		myCowboy.add("saddle");
		myCowboy.add("stampede");
		myCowboy.add("cowboy");
		myCowboy.add("cowgirl");
		myCowboy.add("yehaw");
		myCowboy.add("leather boots");
	}
	
	/**
	 * Fills the randomList with various Strings for the chatbot.
	 */
	private void fillTheRandomList()
	{
		randomList.add("I like cheese.");
		randomList.add("I hate essays.");
		randomList.add("I like cereal.");
		randomList.add("Hello, Mr.Anderson.");
		randomList.add("I like typing.");
	}
	
	/**
	 * This method chooses a random item from the randomList.
	 * @return A random element from the random List.
	 */
	
	private void fillTheConversationList()
	{
		conversationList.add(" Nugget in a buscuit");
		conversationList.add(" Happy Birthday");
		conversationList.add(" I will consume your soul!!");
	}
	
	/**
	 * Uses the conversationList object to talk about a specified topic.
	 * @return
	 */
	public ArrayList<String> topicConversation()
	{
		return conversationList;
	}
	
	
	public String getRandomTopic()
	{
		String randomTopic = ("");
		
		double myRandom = Math.random();
		int myRandomListPosition = (int) (myRandom * randomList.size());
		randomTopic = randomList.get(myRandomListPosition);
		
		return randomTopic;
	}
	
	/**
	 * 
	 * @param currentInput Explanation of the variable. The current phrase typed by the user.
	 * @return What is returned by the method. In this case the method returns whether or not the input is a cowboy phrase from the cowboyList.
	 */
	public boolean cowboyChecker(String currentInput)
	{
		boolean hasCowboy = false;
		
		if(currentInput != null)
		{	
			for(String currentPhrase : myCowboy)
			{
				if(currentPhrase.equalsIgnoreCase(currentInput))
				{
					hasCowboy = true;
				}
			}
		}
		return hasCowboy;
	}
	
	/**
	 * One to two sentence explanation of the method. Full sentences with punctuation. Checks the currentInput from the user to see if it is a member of the memeList.
	 * It returns true if the input is a member of the memeList.
	 * @param currentInput Explanation of the variable. The current phrase typed by the user.
	 * @return What is returned by the method. In this case the method returns whether or not the input is a meme from the memeList.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		//loop over all the items in the list, if the input matches a meme,
		//change hasMeme to true.
		
		if(currentInput != null)
		{	
			for(String currentPhrase : myMemes)
			{
				if(currentPhrase.equalsIgnoreCase(currentInput))
				{
					hasMeme = true;
				}
			}
		}
		return hasMeme;
	}
	

	/**
	 * A method which checks the alphabetical order of names.
	 * @param first The first name.
	 * @param middle The second name.
	 * @param last The last name.
	 * @return
	 */
	public String alphabatizeYourName(String first, String middle, String last)
	{
		String nameInOrder = "";
		
		if(first.compareTo(middle) < 0)
		{
			if(first.compareTo(last) < 0)
			{
				if(middle.compareTo(last)< 0)
				{
				nameInOrder = first + ", " + middle + ", " + last;
				}
				else
				{
					nameInOrder = first + ", " + last + ", " + middle;
				}
			}
			else
			{
				nameInOrder = last + ", " + first + ", " + middle;
			}
		}
		else
		{
			if(middle.compareTo(last) < 0)
			{
				if(first.compareTo(last) < 0)
				{
					nameInOrder = middle + ", " + first + ", " + last;
				}
				else
				{
					nameInOrder = middle + ", " + last + ", " + first;
				}
			}
			else
			{
				nameInOrder = last + ", " + middle + ", " + first;
			}
		}
		
		return nameInOrder;
	}
	
	/**
	 * Three questions posed to the user using pop-up windows.
	 */
//	public void topicConversation()
//	{
//		//Must have at least three JOptionPane.showInputDialog statements about a single topic of your choice.
//		JOptionPane.showInputDialog("What, is your name?");
//		JOptionPane.showInputDialog("What, is your quest?");
//		JOptionPane.showInputDialog("What, is the capitol of Westeria?`");
//	}
	
}
