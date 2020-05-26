import java.io.*;
	
public class Occurances {

	static public void main (String args[ ]) throws IOException {

		String numString;
		double number; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please type a number");

		while(true) {
		    try {
			numString = br.readLine();
			number = (Double.parseDouble(numString)); 
			break;
		    }
		    catch (NumberFormatException e) {
			System.out.println("Non-numeric input, try again");
			System.out.println(e.getMessage());
		    }
		}

	System.out.print("Your number squared is ");
	System.out.println(number*number);

	    }//end main method
	}/* end NumInput2 class*/