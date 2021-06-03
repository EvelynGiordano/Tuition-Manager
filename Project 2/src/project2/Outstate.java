package project2;

/**
 * Defines an object representing an out-of-state student.
 * Extends the implementation of the Student class.
 * Implements a version of the abstract method tuitionDue() in the Student class.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Evelyn Giordano
 */
public class Outstate extends Student {
	private boolean tristate;									//tristate status
	private int outStateCost = 756;								//cost per credit
	
	
	/**
	 * Initializes Outstate object.
	 * Parameterized constructor
	 * @param fname  first name of student
	 * @param lname  last name of student
	 * @param credit  number of credits
	 * @param tristate  tristate area status
	 */
	public Outstate(String fname, String lname, int credit, boolean tristate) {
		super(fname, lname, credit);
		this.tristate = tristate;
	}
	
	/**
	 * Overrides the toString() method of the Student class.
	 * Adds tristate to the the Student class's toString() method.
	 * Formatted as: "fname lname credit tristate"
	 */
	@Override
	public String toString() {
		return super.toString() + ", Tri-state status: " + this.tristate + ")";
	}
	
	/**
	 * Implements a version of tuitionDue() from the Student class.
	 * If student is full-time and from the tristate area, discount $200/credit.
	 * Credits cannot exceed 15.
	 */
	public int tuitionDue() {
		if(this.credit > 0){
			if(this.credit < 12) {
				return (outStateCost * this.credit) + partTime;
			}
			if(this.tristate && this.credit > 15){
	            return((outStateCost - discount) * 15) + fullTime ;
	        }else {
	           if(this.credit > 15)
	               return(outStateCost * 15 + fullTime);
	        }
			if(this.tristate) {
				return ((outStateCost - discount) * this.credit) + fullTime;
			}
			
			return (outStateCost * this.credit) + fullTime;
		}else {
			System.out.printf("Error in credit field. ");
			return -1;

		}
	}
	
	/**
	 * Testbed main for the Outstate class.
	 * Tests the implementation of tuitionDue(), toString(), and the Outstate parameterized constructor.
	 */
	 public static void main(String args[]) {
			//Test for toString() and parameterized constructor
			Outstate o = new Outstate("Joe", "Lee", 16, true);
			System.out.println(o.toString());												//expected output: "Joe Lee 16 true"
			
			//Tests for tuitionDue()
			System.out.println(o.tuitionDue());												//expected output: 9781 (credits > 15, tristate)
			System.out.println((new Outstate("Joey", "Lee", 16, false)).tuitionDue());		//expected output: 12781
			System.out.println((new Outstate("Jack", "Lee", 45, false)).tuitionDue());		//expected output: 12781
			System.out.println((new Outstate("Tim", "Lee", 5, true)).tuitionDue());			//expected output: 4626 (part time, tristate)
			System.out.println((new Outstate("Jim", "Lee", 0, true)).tuitionDue());			//expected output: "Error in credit field. -1"
			System.out.println((new Outstate("Jo", "Lee", 8, true)).tuitionDue());			//expected output: 6894
			
	  }

}

