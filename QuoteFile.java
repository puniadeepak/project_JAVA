import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
// load the classes that you need. 

public class QuoteFile {
	// Declare variables.
	private Scanner reader;
	private File file2;
	private FileWriter write;
	private int lineCounter = 0;

	/*
	 * This is a Constructor.
	 */
	QuoteFile(String file_name) throws IOException {
		File file = new File(file_name); // create object of File class to open file.
		FileWriter fwriter = new FileWriter(file_name, true); // create object of FileWriter class to write in file.
		Scanner s = new Scanner(file); // create scanner object to read from file.
		// Set values of Scanner, File and FileWriter objects to be used by class
		// methods.
		reader = s;
		file2 = file;
		write = fwriter;

	}

	/*
	 * This method count number of quotes from file.
	 */
	public void countQuotes() throws IOException {

		while (reader.hasNextLine()) {
			String line = reader.nextLine(); // read next line form file till end.
			if (line.trim().isEmpty()) // increase lineCounter when next line is a blank line.
			{
				lineCounter++;
			}
		}
		lineCounter++; //increment counter for last quote entry.
	}

	/*
	 * method to get value of lineCounter.
	 */
	public int getcountQuotes() {
		return lineCounter;
	}

	/*
	 * This method will add entry in text file.
	 */
	public void addEntry() throws IOException {
		String quote, author;
		Scanner keyboard = new Scanner(System.in); // create scanner object to take input.
		System.out.println("Enter you quote: "); // ask user to enter quote.
		quote = keyboard.nextLine();
		System.out.println("Enter name of author of this quote: "); // ask user to enter name of author of quote
		author = keyboard.nextLine();

		// append data in the end of file
		PrintWriter outputFile = new PrintWriter(write);
		outputFile.println("\n");
		outputFile.println(quote);
		outputFile.print("-- " + author);
		

		// close scanner and printwriter objects
		outputFile.close();

		// tell user that entry has been made to file.
		System.out.println("Your quote has been added to file.");

	}

	/*
	 * This method receive a number and get that quote from file.
	 */
	public String retrieveQuote(int num) throws IOException {

		int quoteNumber = 0;
		String quote = "", line2;
		Scanner s = new Scanner(file2); // create scanner class object to take input.

		while (s.hasNextLine() && quoteNumber < num) { // loop read lines till file is parsed completely or it get
														// desired number of quote.
			if (num == 1) { // for 1st quote it starts reading file from start.
				do {
					line2 = s.nextLine();
					line2 = line2.trim(); // remove extra spaces.
					quote = quote + " " + line2;
				} while (!(line2.trim().isEmpty())); // stop reading file when there is a empty line.

				break;
			}

			String line = s.nextLine(); // read next line form file till end
			if (line.trim().isEmpty()) // increase quoteNumber when next line is a blank line
			{
				quoteNumber++;
				if ((num - quoteNumber) == 1) { // if reach at desired quote number, save quote to variable quote.
					do {
						line2 = s.nextLine();
						line2 = line2.trim();
						quote = quote + " " + line2;
					} while (!(line2.trim().isEmpty())); // read from files till reach empty line.
					break;
				}
			}
		}
		return quote; // returns retrieved quote.
	}
}
