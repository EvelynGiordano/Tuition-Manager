package project2;
 
/**
 * Defines an object representing an international student.
 * Extends the implementation of the Student class.
 * Implements a version of the abstract method tuitionDue() in the Student class.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Evelyn Giordano
 */
public class International extends Student {
	private boolean exchange;						//exchange status
	private int intlCost = 945;						//cost per credit
	
	/**
	 * Initializes International object.
	 * Parameterized constructor.
	 * @param fname  first name of student
	 * @param lname  last name of student
	 * @param credit  number of credits
	 * @param exchange  exchange student status
	 */
	public International(String fname, String lname, int credit, boolean exchange) {
		super(fname, lname, credit);
		this.exchange = exchange;
	}
	
	/**
	 * Overrides the toString() method of the Student class.
	 * Adds exchange to the the Student class's toString() method.
	 * Formatted as: "fname lname credit exchange"
	 */
	@Override
	public String toString() {
		return super.toString() + ", Exchange status: " + this.exchange + ")";
	}
	
	/**
	 * Implements a version of tuitionDue() from the Student class.
	 * Exchange students only pay full-time fee plus international fee.
	 * Credits cannot exceed 15.
	 */
	public int tuitionDue() {
		if(this.credit >= minIntlCredits) {
			if(this.exchange) {
				return(fullTime + intlFee);
			}
			
			if(this.credit < 12) {
				return (intlCost * this.credit) + partTime + intlFee;
			}
	                
	        if(this.credit > 15)
	            return(intlCost * 15) + fullTime + intlFee;
			
			return (intlCost * this.credit) + fullTime + intlFee;
		}else {
			System.out.printf("Error in credit field. ");
			return -1;
		}
	}
	
	/**
	 * Testbed main for the International class.
	 * Tests the implementation of tuitionDue(), toString(), and the International parameterized constructor.
	 */
	 public static void main(String args[]) {
			//Test for toString() and parameterized constructor
			International n = new International("Kim", "Joe", 16, true);
			System.out.println(n.toString());												    	//expected output: "Kim Joe 16 true"
			
			//Tests for tuitionDue()
			System.out.println(n.tuitionDue());												    	//expected output: 1791
			System.out.println((new International("Bob", "Joe", 5, true)).tuitionDue());			//expected output: "Error in credit field. -1"
			System.out.println((new International("Jim", "Joe", 0, true)).tuitionDue());	    	//expected output: "Error in credit field. -1"
			System.out.println((new International("Jo", "Joe", 17, false)).tuitionDue());			//expected output: 15966
			System.out.println((new International("Holly", "Green" , 17, true)).tuitionDue());		//expected output: 1791
			System.out.println((new International("Jolly", "Jones", 65, true)).tuitionDue());		//expected output: 1791
	  }

}

