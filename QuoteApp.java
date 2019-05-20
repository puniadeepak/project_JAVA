/*
 * Deepak punia C0739472
 * Deepak punia C0739472
 * Deepak punia C0739472
 */

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuoteApp extends JFrame {
	private JPanel panel; // To reference a panel
	private JLabel messageLabel; // To reference a label
	private final int WINDOW_WIDTH = 400; // Window width
	private final int WINDOW_HEIGHT = 300; // Window height

	public QuoteApp() {
		// Set the window title.
		setTitle("CREDITS");

		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify what happens when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panel and add it to the frame.
		buildPanel();

		// Add the panel to the frame's content pane.
		add(panel);

		// Display the window.
		setVisible(true);
	}

	/**
	 * The buildPanel method adds credits to window.
	 */
	private void buildPanel() {

		// Create a JPanel object and let the panel
		// field reference it.
		panel = new JPanel();

		//creating labels for panel.
		JLabel label1 = new JLabel();
		label1.setText("This program is created by: ");
		label1.setBounds(0, 0, 200, 50);
		JLabel label2 = new JLabel();
		label2.setText("<html><h2>Deepak Punia		  C0739472</h2></html>");
		label2.setBounds(0, 50, 500, 50);
		JLabel label3 = new JLabel();
		label3.setText("<html><h2>Ashima Bhati		  C0739472</h2></html>");
		label3.setBounds(0, 100, 500, 50);
		JLabel label4 = new JLabel();
		label4.setText("<html><h2>Palwinder Kaur	  C0739472</h2></html>");
		label4.setBounds(0, 150, 500, 50);

		//add labels to panel
		add(label1);
		add(label2);
		add(label3);
		add(label4);
	}

	public static void main(String[] args) throws IOException {
		// Create all objects and call all methods that you
		// need here. You have freedom as to how you want to
		// interact with the user.

		// declaration of variables.
		int quoteNumber, random;
		String filename = "quotes.txt", checker, quote, myQuote;
		QuoteFile myQuoteFile = new QuoteFile(filename); // send file name to constructor and create object of
															// class QuoteFile.

		myQuoteFile.countQuotes(); // call countQuotes method to count no. of quotes.
		int no = myQuoteFile.getcountQuotes(); // get no. of quotes in variable no.

		System.out.println("Total number of Quotes in file is : " + no); // print total number of quotes in file.

		System.out.println("\nDo you want to add quote to file: (Y/N) ");
		Scanner keyboard2 = new Scanner(System.in);
		String userInput = keyboard2.nextLine();
		if (userInput.equals("Y") || userInput.equals("y")) {
			myQuoteFile.addEntry(); // user can add entry to quote file.
		}

		// retriving quote from file.
		do {

			System.out.println("Enter number of the quote you want to see: ");
			quoteNumber = keyboard2.nextInt(); // read the next input.

			if (quoteNumber > no) // check if input quote number is within range if not ask again.
			{
				System.out.println("We have only " + no + " quotes. Enter number again.");
				quoteNumber = keyboard2.nextInt();

			}
			quote = myQuoteFile.retrieveQuote(quoteNumber); // get quote from file.
			quote = quote.trim(); // removes extra spaces from quote.
			System.out.println(quote); // Display quote to user.
			System.out.println("\nDo you want to see more quotes? Y/N: "); // ask if user want to see more quotes.
			checker = keyboard2.nextLine(); // eat empty space.
			checker = keyboard2.nextLine(); // take input from user.
			checker = checker.toUpperCase(); // convert input to uppercase.
		} while (checker.equals("Y"));

		Random rand = new Random();
		random = rand.nextInt(no - 1 + 1) - 1; // choose random number from min. 1 to max. number of quotes in file.
		myQuote = myQuoteFile.retrieveQuote(random); // get quote from file.
		myQuote = myQuote.trim();
		// System.out.println("A random quote for you: \n" + myQuote);// Display quote
		// to user.
		Quote quoteObj = new Quote(myQuote); // create object of Quote class.
		quoteObj.getQuote(); // get quote.
		quoteObj.getCredit(); // get quote credits.

		/*
		 * This is a game code. Remove three words from the quote, randomly print them
		 * to the console and ask the user to put them in the correct places.
		 */

		System.out.println("\nDo you want to play word guessing game? Y/N");
		userInput = keyboard2.nextLine();
		while (userInput.equals("Y") || userInput.equals("y")) {
			quoteObj.tripleX(); // let user play guessing game.
			System.out.println("\nDo you want to try again? Y/N"); // ask user to play again.
			userInput = keyboard2.nextLine();
		}
		System.out.println("Thanks for playing.Have a good day.");
		new QuoteApp(); //to show credits in the end of program.
	}

	// Write your aux methods here:
}