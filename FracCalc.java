package fracCalc;

import java.util.ArrayList;
import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
      
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
    	System.out.println("What is your equation?");
    	String input = console.nextLine();
    	produceAnswer(input);
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    
    public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input
    	  // TODO: Read the input from the user and call produceAnswer with an equation
		
    			//string input declaration
    	    	
    	    			
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
    			
    			System.out.println("List size: " + list.size());
    			
    			//call method for whole numbers
    	    	int[] wns = new int[list.size() + 1];
    			WholeNumbers(list, wns);
    			
    			//call method for numerator
    	    	int[] ns = new int[list.size() + 1];
    			numerator(list, ns);
    					
    			//call method to find denominator
    			int[] ds = new int[list.size() + 1];
    			denominator(list, ds);
    			
    			String answer = "";
    			//call add method if the operand is add
    			if (op.equals("+")) {
    				
    				System.out.println("Addition");
    				answer = add(list, wns, ns, ds);
    				System.out.println("Answer: " + answer);
    			}
    			
    			//call subtract method if operand equals subtract
    			if (op.equals("-")) {
    				
    				System.out.println("subtraction");
    				sub(list);
    			}
    			
    	    	return list.get(3);
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
 
    //method for finding whole numbers
    public static void WholeNumbers(ArrayList<String> list, int[] wns) {
    	
    	System.out.println("");
		//
			//References list for pieces of equation
	    	String numbers = "";
	    	//temporary denominator of each piece of equation
	    	String wn = "";
	    	int number = 0;
	    	System.out.print("Your Whole Number(s): ");
	    	//for each item in ArrayList list
	    	for (int i = 0; i < list.size(); i++) {
	    		
				//check for even numbered elements (Should be numbers)
				if (i % 2 == 0) {
					
					//set numbers equal to each element, and set wn equal to the first int
					numbers = list.get(i);
					wn = String.valueOf(numbers.charAt(0));
					number = Integer.parseInt(wn);
					//put wn into element i of array wns
					wns[i] = number;
				}
				else {
					
					wns[i] = 0; 
				}
	    	}
	    	//
	    	for (int i = 0; i <= wns.length - 2; i++) {
	    		
	    		System.out.print(wns[i] + " ");
	    	}
	    	
    }
    
    //method for finding numerator
    public static void numerator(ArrayList<String> list, int[] ns) {
    	
    	System.out.println("");
		//
    	
			//References list for pieces of equation
	    	String numbers = "";
	    	//scanner for finding number before /
	    	@SuppressWarnings("resource")
			Scanner parser = new Scanner(numbers).useDelimiter("/");
	    	int in = 0;
	    	//temporary denominator of each piece of equation
	    	int n = 0;
	    	System.out.print("Your numerator(s): ");
	    	//for each item in ArrayList list
	    	for (int i = 0; i < list.size(); i++) {
	    		
				//check for even numbered elements (Should be numbers)
				if (i % 2 == 0) {
					
					//set numbers equal to each element, and set d equal to the last symbol
					numbers = list.get(i);
					n = Integer.parseInt(String.valueOf(numbers.charAt(numbers.indexOf("/") - 1)));
					//put n into element i of array ns
					ns[i] = n;
				}
				else {
					
					ns[i] = 0; 
				}
	    	}
	    	
	    	//
	    	for (int i = 0; i <= ns.length - 2; i++) {
	    		
	    		System.out.print(ns[i] + " ");
	    	}
    }
    
    // method for finding denominator
    public static void denominator(ArrayList<String> list, int[] ds) {
    	
		System.out.println("");
		//
			//References list for pieces of equation
	    	String numbers = "";
	    	//temporary denominator of each piece of equation
	    	int d = 0;
	    	//array for denominators
	    	
	    	System.out.print("Your denominator(s): ");
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
	    	return;
    }
    
    //method for greatest common denominator
    public static int gcd(int a, int b) {

    	int b2 = 0;
    	while (b != 0) {
    		
    		a = a % b;
    		b2 = b;
    		b = a;
    		a = b2;
    	}
    	System.out.print("A: " + a + " ");
    	return Math.abs(a);
    	
    	
    }
    
    //method for addition
	public static String add(ArrayList<String> list, int[] wns, int[] ns, int[] ds) {
    	
		System.out.print("ds: " + ds[1] + "" + ds[3]);
		int a = ds[1];
		int b = ds[3];
		System.out.print("D: " + gcd(a, b) + " ");
		//int for common denominator
		int D = 1;
		//check to see if denominators match
		if (ds[1] != ds[3]) {
			
			//call method for greatest common denominator
			
			
			//multiply smaller fraction by cd
			if (ds[1] < ds[3]) {
				
				ns[1] = ns[1] * D;
				ds[1] = ds[1] * D;
			}
		}
		
		//actually add the things
		
		int WN = 0;
		int N = 0;
		for (int i = 0; i <= list.size(); i++) {
			
			WN = WN + wns[i];
			N = N + ns[i];
		}
		
		int WN2 = 0;
		if (N >= D) {
			WN2 = N / D;
			N = N % D;
			WN += WN2;
		}

		String answer = "" + D;
		return answer;
    }
    
    //method for subtraction
    public static void sub(ArrayList<String> list) {
    	
    	
    }
}
