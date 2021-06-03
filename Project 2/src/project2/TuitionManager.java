package project2;
import java.util.Scanner;

/**
 * This is the user interface class and handles input and output to the console.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Christopher DeFranza
 */
public class TuitionManager{
   Scanner stdin = new Scanner(System.in);
   StudentList cs213 = new StudentList();
   
   /**
    * Establishes a loop to take commands from the user via standard input until Q is entered.
    * The program can add, remove, print, and quit.
    */
   public void run(){
       boolean done = false;
       while(!done)
       {
            String input = stdin.nextLine();						//Get the first line 
            String[] splitInput = input.split(" ");					//Put each argument into an array
            String command = "";

            command = splitInput[0];
            int credits, funding = 0;
            String fname, lname = "";
            Student temp;
            boolean status;

           switch(command)
           {
               case "I":  
                   if(splitInput.length == 5){
                	   	fname = splitInput[1];
                	   	lname = splitInput[2];
	                   
	                    try {
	                    	funding = Integer.parseInt(splitInput[4]);
                                credits = Integer.parseInt(splitInput[3]);
	                    } catch(NumberFormatException e) {
	                    	System.out.println("Input error: funding and credits must be a number.");
	                    	break;
	                    }
                    	
	                    if(funding < 0){
	                    	System.out.println("Input error: Instate specific field.");
	                    	break;
	                    }
	                    
                        if(credits > 0){
                            add(temp = new Instate(fname, lname, credits, funding));
                            break;
                        }
                        else {
                            System.out.println("Invalid credit amount.");
                            break;
                        }
                   }
                   else {
                       System.out.println("Input error: invalid amount of arguments");
                       break;
                   }
                     
               case "O":
                   if(splitInput.length == 5) {	
                	   fname = splitInput[1];
                	   lname = splitInput[2];
                       try{
                           credits = Integer.parseInt(splitInput[3]);
                       }catch(NumberFormatException e){
                           System.out.println("Input error: credits must be a number.");
                           break;
                       }
                       
                       
                       if(splitInput[4].equalsIgnoreCase("t"))
                           status = true;
                       else {
                           if(splitInput[4].equalsIgnoreCase("f"))
                               status = false;
                           else {
                               System.out.println("Input error: Out-of-state specific field.");
                               break;
                           }
                       }
                       
                       if(credits > 0) {
	                       add(temp = new Outstate(fname, lname, credits, status));
	                       break;
                       }else {
                    	   System.out.println("Input error: invalid amount of credits.");
                    	   break;
                       }
                   }else{
                       System.out.println("Input error: invalid amount of arguments.");
                       break;
                   }
               case "N":
                   if(splitInput.length == 5) {
                	   fname = splitInput[1];
                	   lname = splitInput[2];
                           
                           try{
                                credits = Integer.parseInt(splitInput[3]);
                           }catch(NumberFormatException e){
                               System.out.println("Input error: credits must be a number.");
                               break;
                           }
                       if(splitInput[4].equalsIgnoreCase("t"))
                           status = true;
                       else {
                           if(splitInput[4].equalsIgnoreCase("f"))
                               status = false;
                           else {
                               System.out.println("Input error: International specific field.");
                               break;
                           }
                       }
                       if(credits >= 9){
                           add(temp = new International(fname, lname, credits, status));
                           break;
                       } else {
                           System.out.println("Input error : International students must have more than 9 credits.");
                           break;
                       }
                    }
                   else {
                        System.out.println("Input error: invalid amount of arguments.");
                        break;
                    }
               case "R":
                   if(splitInput.length == 3){
                	   fname = splitInput[1];
                	   lname = splitInput[2];
                       temp = new Instate(fname, lname, 0, 0);
                       remove(temp);
                       break;
                   }
                   else {
                       System.out.println("Input error: invalid amount of arguments.");
                       break;
                   }
               case "P":
                   cs213.print();
                   break;
                   
               case "Q":
                   done = true;
                   System.out.println("Program terminated.");
                   break;
                   
               default:
                   System.out.println("Invalid command argument.");
                   break;
           }
        
        
       }
   }

   /**
    * Determines if a student already exists in the list, and adds them if not.
    * @param s  student to be added
    */
   private void add(Student s){
        if(!cs213.contains(s)) {
                cs213.add(s);
                System.out.println(s.toString() + " has been added to the student list");
            }
            else
            	System.out.println(s.toString() + " is already in student list.");
   }
   
  /**
   * Attempts to remove a team member from a team.
   * Checks to make sure no duplicate members will be added.
   * Checks to make sure date is valid.
   * @param s team member to be removed
   */
   private void remove(Student s){
      
          boolean result =  cs213.remove(s);
          if(result){
              System.out.println(s.toString() + " has left the student list.");
          }
          else{
              System.out.println( s.toString() + " is not a student in the list.");   
          }
          
      
       
   }
   
	/**
	 * Runs the program by calling the run() method.
	 */
   public static void main(String args[]) {
	   TuitionManager t = new TuitionManager();
           System.out.println("Program is now running.");
	   t.run();
   }
}