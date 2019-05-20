import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Quote {
	private String quote, credit;
	private int count;

	/*
	 * This is a default constructor
	 */
	public Quote(String q) {
		credit = q.substring(q.lastIndexOf("-") + 1).trim(); // save credit of quote in credit variable.
		quote = q.substring(0, q.indexOf("-")); // save rest of quote in quote variable.
	}

	/*
	 * this method print quote
	 */
	public void getQuote() {
		System.out.println("A random quote for you: \n" + quote);
		getWordCount(quote); // call to getWordCount method.
	}

	/*
	 * this method display credits of quote to user.
	 */
	public void getCredit() {

		System.out.println("\nAuthor credits: " + credit);
	}

	/*
	 * this method count the words of quote.
	 */
	public void getWordCount(String s) {

		boolean word = false;
		int endOfLine = s.length() - 1;

		for (int i = 0; i < s.length(); i++) {
			// if the char is a letter, word = true.
			if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
				word = true;
				// if char isn't a letter and there have been letters before,
				// counter goes up.
			} else if (!Character.isLetter(s.charAt(i)) && word) {
				count++;
				word = false;
				// last word of String; if it doesn't end with a non letter, it
				// wouldn't count without this.
			} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
				count++;
			}
		}
		System.out.println("\nNumber of words in this quote are: " + this.count); // Display number of words in quote.

	}

	/*
	 * this method Remove three words from the quote, randomly print them to the
	 * console and ask the user to put them in the correct places.
	 */
	public void tripleX() {

		String[] words = new String[3]; // array to save random missing words
		String[] tokens = quote.split(" "); // Get the tokens, using a space delimiter.

		// Create Arraylist with three random numbers
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Random randomGenerator = new Random(); // create random class object
		while (numbers.size() < 3) { // generates three random numbers in arraylist.

			int random = randomGenerator.nextInt(count);
			if (!numbers.contains(random)) {
				numbers.add(random);
			}

		}
		// This loop will erase 3 words from tokens based to random numbers
		for (int j = 0; j < numbers.size(); j++) {
			words[j] = tokens[numbers.get(j)];
			tokens[numbers.get(j)] = "__"+(j+1)+"__";
		}

		// Display tokens or new string
		for (int i = 0; i < 50; ++i) // to clear console
			System.out.println();
		for (int j = 0; j < tokens.length; j++) {
			System.out.print(tokens[j] + " ");

		}
		System.out.println();

		System.out.print("Missing words: ");
		// Show missiong words
		for (int j = 0; j < words.length; j++) {
			System.out.print("\n" + words[j]);

		}
		System.out.println();

		System.out.println("Guess the position of words: "); // ask user to guess the location of mission words
		Scanner keyboard = new Scanner(System.in);

		int[] userGuess = new int[3];
		for (int k = 0; k < userGuess.length; k++) {
			try {
				userGuess[k] = keyboard.nextInt() - 1; // minus one because array index starts from 0.
			} catch (Exception e) { // use of try catch blocks to catch error if user enter letter instead of
									// numeric value.
				System.out.println(e.getMessage());
				System.out.println("Please enter numeric value only!");
			}
		}

		// give user his correct answer
		int match = 0;
		for (int z = 0; z < userGuess.length; z++) {
			if (userGuess[z] == numbers.get(z)) {
				match++;
			}
		}

		// personalize out of game according to score.
		switch (match) {
		case 0:
			System.out.println("Sorry! your score is: 0.Try your luck again.");
			break;

		case 1:
			System.out.println("Your score is: 1.");
			break;
		case 2:
			System.out.println("Your score is: 2");
			break;
		case 3:
			System.out.println("ALL OF YOUR ANSWERS ARE CORRECT, CONGRATULATIONS!");
			break;
		default:
			break;
		}

		// put missing words back in place
		for (int j = 0; j < numbers.size(); j++) {
			tokens[numbers.get(j)] = words[j];
			words[j] = " ";
		}

		// show full string to user
		System.out.println("\nHere is your complete quote: ");
		for (int j = 0; j < tokens.length; j++) {
			System.out.print(tokens[j] + " ");

		}
		System.out.println();
	}
}
