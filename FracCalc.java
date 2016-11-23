package fracCalc;

import java.util.ArrayList;
import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
      
		String input = "";
		Scanner console = new Scanner(System.in);
		System.out.println("What is your equation?");
    	input = console.nextLine();
		while (! input.equals("quit")) {
	    	String answer = produceAnswer(input);
	    	System.out.println("Your reduced answer is: " + answer + "\nWhat is your equation?");
	    	input = console.nextLine();
		}
		System.out.println("Thanks for using my fraction calculator!");
		console.close();
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
//    			
    			//String declaration for operand
    			String op = "";
    			//for each element of the array
    			for (int i = 0; i < list.size(); i++) {
    				
    				//check for odd numbered elements
    				if (i % 2 == 1) {
    					
    					//set op equal to the operand, and print it out
    					op = list.get(i);
    				}
    			}
    			
    			String answer = "";
    			
    			if (list.size() > 2) {
    				
	    			//call method for whole numbers
	    	    	int[] wns = new int[list.size() + 1];
	    			WholeNumbers(list, wns);

	    			
	    			//call method for numerator
	    	    	int[] ns = new int[list.size() + 1];
	    			numerator(list, ns, wns);
	    			
	    			//call method to find denominator
	    			int[] ds = new int[list.size() + 1];
	    			denominator(list, ds);

	    			//call add method if the operand is add
	    			if (op.equals("+")) {
	    				
	    				answer = add(list, wns, ns, ds);
	    			}
	    			
	    			//call subtract method if operand equals subtract
	    			if (op.equals("-")) {
	    				
	    				answer = sub(list, wns, ns, ds);
	    			}
	    			
	    			//call multiply method if operand equals multiply
	    			if (op.equals("*")) {
	    				
	    				answer = multiply(list, wns, ns, ds);
	    			}
	    			
	    			//call divide method if operand equals multiply
	    			if (op.equals("/")) {
	    				
	    				answer = devide(list, wns, ns, ds);
	    			}
    			}
    			else {
    				
    				answer = list.get(0);
    			}
    	    	return answer;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
 
    //method for finding whole numbers
    public static void WholeNumbers(ArrayList<String> list, int[] wns) {
    	
			//References list for pieces of equation
	    	String numbers = "";
	    	//temporary denominator of each piece of equation
	    	int number = 0;
	    	//for each item in ArrayList list
	    	for (int i = 0; i < list.size(); i++) {
	    		
				//check for even numbered elements (Should be numbers)
				if (i % 2 == 0) {
					
					numbers = list.get(i);
					if (numbers.indexOf("_") == -1) {
						
						if (numbers.indexOf("/") == -1) {
							
							number = Integer.parseInt(numbers);
						}
						else {
							
							number = 0;
						}
					}
					else {
						
						number = Integer.parseInt(String.valueOf(numbers.substring(0, numbers.indexOf("_"))));
					}
					
					wns[i] = number;
				}
				else {
					
					//put wn into element i of array wns
					wns[i] = 0; 
				}
	    	}
    }
    
    //method for finding numerator
    public static void numerator(ArrayList<String> list, int[] ns, int[] wns) {
    	
			//References list for pieces of equation
	    	String numbers = "";
	    	//temporary denominator of each piece of equation
	    	int n = 0;
	    	//for each item in ArrayList list
	    	for (int i = 0; i < list.size(); i++) {
	    		
				//check for even numbered elements (Should be numbers)
				if (i % 2 == 0) {
					
					//set numbers equal to each element, and set d equal to the last symbol
					numbers = list.get(i);
					try {
						//if there is an underscore and a slash
						n = Integer.parseInt(String.valueOf(numbers.substring(numbers.indexOf("_") + 1, numbers.indexOf("/"))));
					}
					catch (StringIndexOutOfBoundsException nu) {
						
						try {
							//if there is a slash but no underscore
							n = Integer.parseInt(String.valueOf(numbers.substring(0, numbers.indexOf("/"))));
						}
						catch (StringIndexOutOfBoundsException nu2) {
							//if there is no slash and no underscore
							n = 0;
						}
					}
					//put n into element i of array ns
					if (wns[i] < 0) {n = n * -1;}
					ns[i] = n;

				}
				else {
					
					ns[i] = 0; 
				}
	    	}
    }
    
    // method for finding denominator
    public static void denominator(ArrayList<String> list, int[] ds) {
    	
			//References list for pieces of equation
	    	String numbers = "";
	    	int x = 0;
	    	//temporary denominator of each piece of equation
	    	int d = 0;
	    	//array for denominators
	
	    	//for each item in ArrayList list
	    	for (int i = 0; i < list.size(); i++) {
	    		
				//check for even numbered elements (Should be numbers)
				if (i % 2 == 0) {
					
					//set numbers equal to each element, and set d equal to the last symbol
					numbers = list.get(i);
					try {
						if (numbers.indexOf("/") != -1) {
							
							x = numbers.indexOf("/");
							d = Integer.parseInt(numbers.substring(x + 1, numbers.length()));
						}
						else {d = 1;}
					}
					catch (StringIndexOutOfBoundsException du) {
						
						d = 1;
					}
					//put d into element i of array ds
					ds[i] = d;
				}
				else {
					
					ds[i] = 0; 
				}
	    	}
    }
    
    //method for addition
	public static String add(ArrayList<String> list, int[] wns, int[] ns, int[] ds) {
    	
		
		//declare variables
		int numerator = 0;
		int wholenumber = 0;
		String answer = "";
		//find GCD
		int a = ds[0];
		int b = ds[2];
		int denominator = gcd(a, b);
		//
		if (denominator == 1) {
			
			denominator = a * b;
			ns[0] = ns[0] * b;
			ns[2] = ns[2] * a;
		}
		if (a % b == 0) {
			
			denominator = a;
			ns[2] = ns[2] * (a/b);
		} 
		else if (b % a == 0) {
			
			denominator = b;
			ns[0] = ns[0] * (b/a);
		}
		if (a == b) {
			denominator = a;
		}
		
		for (int i = 0; i <= wns.length - 1; i++) {
			
			wns[i] = wns[i] * denominator;
		}
		for (int i = 0; i <= wns.length - 1; i++) {
			
			numerator += wns[i];
		}
		for (int i = 0; i <= ns.length - 1; i++) {
			
			numerator += ns[i];
		}
		wholenumber = numerator / denominator;
		numerator = Math.abs(numerator % denominator);
		if (numerator == 0) {
			answer = wholenumber + "";
		}
		else if (wholenumber == 0) { answer = numerator + "/" + denominator;}
		else {
			answer = wholenumber + "_" + numerator + "/" + denominator;
		}
		return answer;
    }
    
    //method for subtraction
    public static String sub(ArrayList<String> list, int[] wns, int[] ns, int[] ds) {
    	
    	//declare variables
    			int numerator = 0;
    			int wholenumber = 0;
    			String answer = "";
    			//find GCD
    			int a = ds[0];
    			int b = ds[2];
    			int denominator = gcd(a, b);
    			//
    			if (denominator == 1) {
    				
    				denominator = a * b;
    				ns[0] = ns[0] * b;
    				ns[2] = ns[2] * a;
    			}
    			if (a % b == 0) {
    				
    				denominator = a;
    				ns[2] = ns[2] * (a/b);
    			} 
    			else if (b % a == 0) {
    				
    				denominator = b;
    				ns[0] = ns[0] * (b/a);
    			}
    			if (a == b) {
    				denominator = a;
    			}
    			//
    			for (int i = 0; i <= ns.length - 1; i++) {
    				
    				numerator -= ns[i];
    			}
    			for (int i = 0; i <= wns.length - 1; i++) {
    				
    				wns[i] = wns[i] * denominator;
    			}
    			for (int i = 0; i <= wns.length - 1; i++) {
    				
    				numerator += wns[i];
    			}
    			
    			wholenumber = numerator / denominator;
    			numerator = numerator % denominator;
    			if (numerator == 0) {
    				answer = wholenumber + "";
    			}
    			else if (wholenumber == 0) { answer = numerator + "/" + denominator;}
    			else {
    				answer = wholenumber + "_" + numerator + "/" + denominator;
    			}
    			return answer;
    }
    
    public static String multiply(ArrayList<String> list, int[] wns, int[] ns, int[] ds) {
    	
    	String answer = "";    	
    	int numerator = ns[0];
    	int denominator = ds[0];
    	int wholenumber = 0;
    	int wholenumber1 = wns[0];
    	
    	for (int i = 2; i <= ns.length - 1; i++) {
    		
    		if (i % 2 == 0) {
    			
    			numerator = numerator * ns[i];
    		}
    	}
    	for (int i = 2; i <= ds.length - 1; i++) {
    		
    		if (i % 2 == 0) {
    			
    			denominator = denominator * ds[i];
    		}
    	}
    	for (int i = 2; i <= wns.length - 1; i++) {
    		
    		if (i % 2 == 0){
    			
    			wholenumber1 = wholenumber1 * wns[i];
    		}
    	}
    	numerator += (wholenumber1 * denominator);
    	
    	wholenumber = numerator / denominator;
		numerator = numerator % denominator;
		if (numerator == 0) {
			answer = wholenumber + "";
		}
		else if (wholenumber == 0) { answer = numerator + "/" + denominator;}
		else {
			answer = wholenumber + "_" + numerator + "/" + denominator;
		}
		return answer;
	}
    
 public static String devide(ArrayList<String> list, int[] wns, int[] ns, int[] ds) {
    	
	 	int b1 = ns[2];
	 	ns[2] = ds[2];
	 	ds[2] = b1;
    	String answer = "";    	
    	int numerator = ns[0];
    	int denominator = ds[0];
    	int wholenumber = 0;
    	for (int i = 2; i <= ns.length - 1; i++) {
    		
    		if (i % 2 == 0) {
    			
    			numerator = numerator * ns[i];
    		}
    	}
    	for (int i = 2; i <= ds.length - 1; i++) {
    		
    		if (i % 2 == 0) {
    			
    			denominator = denominator * ds[i];
    		}
    	}
    	try {
    		wholenumber = numerator / denominator;
			numerator = numerator % denominator;
    	}
    	catch (ArithmeticException d0) {
    		denominator = 1;
    	}
		if (numerator == 0) {
			answer = wholenumber + "";
		}
		else if (wholenumber == 0) { answer = numerator + "/" + denominator;}
		else {
			answer = wholenumber + "_" + numerator + "/" + denominator;
		}
		return answer;
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
    	
    	return b2;
    }
}
