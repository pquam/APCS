package fracCalc;

import java.util.ArrayList;
import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
		
		//string input declaration
    	String input = "5_3/4 + 6_5/8";
    	@SuppressWarnings("resource")
    	//start a new scanner called parser
		Scanner parser = new Scanner(input).useDelimiter(" ");
    	//start a new ArrayList to store strings
    	ArrayList<String>  list = new ArrayList<String>();
    	//as long as there are more sections, add them to the ArrayList
    	while (parser.hasNext() == true) {
    		
    		String eq = parser.next();
    		list.add(eq);
    	}
    	//close parser
    	parser.close();
		System.out.println("Your equation: " + list + " ");
//		
		//String declaration for operand
		String op = "";
		System.out.print("Your operand(s): ");
		//for each element of the array
		for (int i = 0; i < list.size(); i++) {
			//check for odd numbered elements
			if (i % 2 == 1) {
				//set op equal to the operand, and print it out
				op = list.get(i);
				System.out.print(op + "  ");
			}
		}
		//
		System.out.println("List size: " + list.size());
		//call add method if the operand is add
		if (op.equals("+")) {
			
			System.out.println("Addition");
			add(list);
		}
		//call subtract method if operand equals subtract
		if (op.equals("-")) {
			
			System.out.println("subtraction");
			sub(list);
		}
		
    	

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	
        return input;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
 
    //method for addition
    @SuppressWarnings("null")
	public static void add(ArrayList<String> list) {
    	
    	//References list for pieces of equation
    	String numbers = "";
    	//temporary denominator of each piece of equation
    	int d = 0;
    	//array for denominators
    	int[] ds = new int[list.size() + 1];
    	System.out.print("Your denominators: ");
    	//for each item in ArrayList list
    	for (int i = 0; i < list.size(); i++) {
			//check for even numbered elements (Should be numbers)
			if (i % 2 == 0) {
				//set numbers equal to each element, and set d equal to the last symbol
				numbers = list.get(i);
				d = Integer.parseInt(numbers.substring(numbers.length() - 1));
				//put d into element i of array ds
				ds[i] = d;
			}
			else {
				ds[i] = 0; 
			}
			
			
		}
    	//
    	for (int i = 0; i <= ds.length - 2; i++) {
    		System.out.print(ds[i] + " ");
    	}
    	System.out.println("");
    	//
    	
    	System.out.println("Whole number: " );
    }
    
    //method for subtraction
    public static void sub(ArrayList<String> list) {
    	
    	//References list for pieces of equation
    	String numbers = "";
    	//temporary denominator of each piece of equation
    	int d = 0;
    	//array for denominators
    	int[] ds = new int[list.size() + 1];
    	System.out.print("Your denominators: ");
    	//for each item in ArrayList list
    	for (int i = 0; i < list.size(); i++) {
			//check for even numbered elements (Should be numbers)
			if (i % 2 == 0) {
				//set numbers equal to each element, and set d equal to the last symbol
				numbers = list.get(i);
				d = Integer.parseInt(numbers.substring(numbers.length() - 1));
				//put d into element i of array ds
				ds[i] = d;
			}
			else {
				ds[i] = 0; 
			}
			
			
		}
    	//
    	for (int i = 0; i <= ds.length - 2; i++) {
    		System.out.print(ds[i] + " ");
    	}
    	System.out.println("");
    	
    	//
    	System.out.println("Whole number: " );
    }
    //
}
