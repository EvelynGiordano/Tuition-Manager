package project2;

/**
 * Defines an object representing an in-state student.
 * Extends the implementation of the Student class.
 * Implements a version of the abstract method tuitionDue() in the Student class.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Evelyn Giordano
 */
public class Instate extends Student{
	private int funds;											//reward funding (+)
	private int inStateCost = 433;								//cost per credit
	
	/**
	 * Initializes an Instate object.
	 * Parameterized constructor.
	 * @param fname  first name of student
	 * @param lname  last name of student
	 * @param credit  number of credits
	 * @param funds  amount rewarded to student
	 */
	public Instate(String fname, String lname, int credit, int funds) {
		super(fname, lname, credit);
		this.funds = funds;
	}
	
	/**
	 * Overrides the toString() method of the Student class.
	 * Adds funding to the the Student class's toString() method.
	 * Formatted as: "fname lname credit funds"
	 */
	@Override
	public String toString() {
		return super.toString() + ", Funds: $" + funds + ")";
	}
	
	/**
	 * Implements a version of tuitionDue() from the Student class.
	 * Funding is only offered to full-time in-state students.
	 * Credits cannot exceed 15.
	 */
	public int tuitionDue() {
          
		if((this.credit > 0) && (this.funds >= 0)) {
			if(this.credit < 12) {
				return (inStateCost * this.credit) + partTime;
			}
	                
	        if(this.credit > 15){
	            return (inStateCost * 15) + fullTime - this.funds;
	        }
			
			return (inStateCost * this.credit) + fullTime - this.funds;
		}else {
			System.out.printf("Error in credit or funding fields. ");
			return -1;
		}
	}
	
	/**
	 * Testbed main for the Instate class.
	 * Tests the implementation of tuitionDue(), toString(), and the Instate parameterized constructor.
	 */
	public static void main(String args[]) {
		//Test for toString() and parameterized constructor
		Instate i = new Instate("John", "Deer", 16, 1000);
		System.out.println(i.toString());								//expected output: "John Deer 16 1000"
		
		//Tests for tuitionDue()
			System.out.println(i.tuitionDue());												//expected output: 6936 (credits > 15)
			System.out.println((new Instate("Jane", "Deer", 5, 1000)).tuitionDue());		//expected output: 3011 (part time, positive funding)
			System.out.println((new Instate("Jim", "Deer", 0, 1000)).tuitionDue());			//expected output: "Error in credit or funding fields. -1"
			System.out.println((new Instate("Jo", " Deer", -1, 0)).tuitionDue());			//expected output: "Error in credit or funding fields. -1"
			System.out.println((new Instate("Bob", "Deer", 12, -1)).tuitionDue());			//expected output: "Error in credit or funding fields. -1"
			System.out.println((new Instate("Jill", "Deer", 14, 3000)).tuitionDue());		//expected output: 4503
	}
}
