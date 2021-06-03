package project2;

/**
 * An abstract class defining the properties of a student.
 * The abstract method tuitionDue() has implementations in 3 subclasses: Instate, Outstate, and International.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Evelyn Giordano
 */
public abstract class Student implements Comparable{
		private String fname;
		private String lname;
		protected int credit;
		protected int partTime = 846;					// use if credits < 12
		protected int fullTime = 1441;					// use if credits >= 12
		protected int discount = 200;					// tristate discount
		protected int intlFee = 350;
		protected int  minIntlCredits = 9;
		
		/**
		 * Initializes a Student object. 
		 * Parameterized constructor.
		 * @param fname  first name of student
		 * @param lname  last name of student
		 * @param credit  number of credits
		 */
		public Student(String fname, String lname, int credit) {
			this.fname = fname;
			this.lname = lname;
			this.credit = credit;
		}
		
		/**
		 * Compares the first and last names of two students and determines if they are equal.
		 * If the first names are equal, compare last names: If negative, return -1. If positive, return 1. Equal, return 0.
		 * Otherwise, compare first names. If negative, return -1. If positive return 1.
		 * Returns -2 if obj is not an instance of the Student class
		 */
		@Override
		public int compareTo(Object obj) {
			int notStudent = -2;
			if (obj instanceof Student) {
				int firstNames = this.fname.compareToIgnoreCase(((Student) obj).fname);
				int lastNames = this.lname.compareToIgnoreCase(((Student) obj).lname);
				if (firstNames == 0) {	
					if(lastNames < 0) {
						return -1;
					}
					else if(lastNames > 0){
						return 1;				//return result of lastNames
					}else {
						return 0;
					}
				}else {							//otherwise, return the result of firstNames (even if lastNames are greater)
					if(firstNames > 0) {
						return 1;				//either -1 or 1 (both -1, both 1, or one of each: so default to fname comparison?)??????
					}else {
						return -1;
					}
				}	
			}
			
			return notStudent;					//not a student instance
				
		}
		
	
		/**
		 * Returns a string formatted as: "fname lname credit"
		 * Overridden by the Instate, Outstate, and International classes.
		 */
		@Override
		public String toString() {
			return "(Name: " + this.fname + " " + this.lname + ", " + " Credits: " + this.credit;
		}
		//compute the tuition due; concrete implementation is required in the subclasses.
		public abstract int tuitionDue();
}
