package basics_of_java;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Loop statements:
 * 1. for
 * 2. for-each
 * 3. while
 * 4. do...while
 * 
 * Loop control statements:
 * 1. break
 * 2. continue
 * 
 * Decision control statements
 * 1. if
 * 2. if...else
 * 3. if...else if...else
 * 4. nested if...else
 * 5. conditional operator ?
 * 6. switch
 */
public class LoopsAndDecisionMaking {

	/**
	 * A method that prints a star pattern based on number of lines
	 *  
	 * @param number  integer - represents number of lines of star patterns
	 */
	static void starPatterByLoops(int number) {
		
		 // ___*___   spaces - 3, stars - 1
		 // __***__   spaces - 2, stars - 3
		 // _*****_   spaces - 1, stars - 5
		 // *******   spaces - 0, stars - 7
		 
		int spaces = number;
		int stars = 1;
		
		// for loop
		for(int i = 0; i < number; i++) {
			
			int spaceLoop = 0;
			int starLoop = 0;
			
			// while loop
			while(spaceLoop != spaces) {
				System.out.print(" ");
				spaceLoop++;
			}
			
			// do...while loop
			do {
				System.out.print("*");
				starLoop++;
			} while(starLoop != stars);
			
			spaceLoop = 0;
			while(spaceLoop != spaces){
				System.out.print(" ");
				spaceLoop++;
			} 
			
			System.out.println();
			
			stars += 2;
			spaces--;
		}
	}
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(3, 4, 5);

	    for(Integer number : numbers) {
	    	System.out.print("\n\nStar pattern with " + number + " lines:\n");
	    	LoopsAndDecisionMaking.starPatterByLoops(number);
	    }
		
	    // multiplication table of 5, 
	    // with skipping 5 times 0 using continue statement,
	    // and breaking at 5 times 11
	    System.out.println();
	    for(int i = 0; i <= 11; i++ ) {
	    	if(i == 0) {
	    		continue;
	    	}
	    	if(i == 11) {
	    		break;
	    	}
	    	System.out.println(5 + " * " + i + " = " + (5*i));
	    }
	    
	    int num1 = 5;
	    int num2 = 10;
	    int num3 = 15;
	    
	    System.out.println();
	    // if...else statement
	    if(num1 > num2) {
	    	System.out.println(num1 + " is greater than " + num2);
	    }
	    else {
	    	System.out.println(num2 + " is greater than " + num1);
	    }
	    
	    System.out.println();
	    // conditional operator
	    String result = (num1 > num2)? num1 + " is greater than " + num2: num2 + " is greater than " + num1;
	    System.out.println(result);
	    
	    System.out.println();
	    // if...else if...else
	    if (num1 >= num2 && num1 >= num3) {
            System.out.println(num1 + " is the greatest.");
        }
        else if (num2 >= num1 && num2 >= num3) {
            System.out.println(num2 + " is the greatest.");
        }
        else {
            System.out.println(num3 + " is the greatest.");
        }
	    
	    System.out.println();
	    // nested if...else
	    if (num1 >= num2) {
            if (num1 >= num3) {
                System.out.println(num1 + " is the greatest.");
            } 
            else {
                System.out.println(num3 + " is the greatest.");
            }
        } else {
            if (num2 >= num3) {
                System.out.println(num2 + " is the greatest.");
            } 
            else {
               System.out.println(num3 + " is the greatest.");   
            }
        }
	    
	    System.out.println();
	    Random rand = new Random();
	    int number = rand.nextInt(1, 7);
	    switch(number) {
		    case 1: {
	    		System.out.println("Random number generated is 1");
	    		break;
	    	}
		    case 2: {
	    		System.out.println("Random number generated is 2");
	    		break;
	    	}
		    case 3: {
	    		System.out.println("Random number generated is 3");
	    		break;
	    	}
		    case 4: {
	    		System.out.println("Random number generated is 4");
	    		break;
	    	}
		    case 5: {
	    		System.out.println("Random number generated is 5");
	    		break;
	    	}
		    default: {
	    		System.out.println("Random number generated is greater than 5");
	    		break;
	    	}
	    }
	    
	}

}
