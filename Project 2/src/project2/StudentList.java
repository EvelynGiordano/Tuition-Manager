package project2;

/**
 * A class defining the properties of a StudentList object.
 * Contains an array, studentList, that holds a variable number of Student instances.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Christopher DeFranza
 */
public class StudentList {
	   
	  private final int NOT_FOUND = -1;
	  private final int GROW_SIZE = 4; 					//initial and grow size
	  private Student [] studentList;
	  private int numStudents;
	  
	  /**
	   * Initializes a StudentList object.
	   * Default constructor.
	   */
	  public StudentList(){
		 studentList = null;
		 numStudents = 0;
	  }
	  
	  /**
	   * Finds the location of a student in the studentList array.
	   * @param s	the student being searched for
	   * @return index of student in the array
	   */
	  public int find(Student s){
		  int i = 0;
	      while(i < numStudents) {
	    	  if(studentList[i].compareTo(s) == 0) {
	    		  return i;
	    	  }
	    	  i++;
	      }
	      
	      return NOT_FOUND;
	  }
	  
	  
	  /**
	   * Allocates more elements for the studentList array.
	   * Creates a new array of the studentLists' current size plus 4.
	   * Copies the students from the old to the new array.
	   */
	  public void grow(){
		  Student[] currentList = studentList;
		  int i = 0;
	      studentList = new Student[numStudents + GROW_SIZE];
	      while(i < numStudents) {
	    	  studentList[i] = currentList[i];
	    	  i++;
	      }
	  }
	  
	  
	  
	  /**
	   * Returns the amount of students in the array
	   * @return numStudents  number of students in list;
	   */
	  public int length(){
	      return numStudents;
	  }
	  
	  /**
	   * Determines if there are 0 members in the studentList.
	   * @return true if empty, false if not empty
	   */
	  public boolean isEmpty(){
	      return (numStudents == 0);
	  }
	  
	  /**
	   * Appends an item to the end of the array.
	   * Searches the team array for the first empty element (last position).
	   * If it is found, add the team member there.
	   * Otherwise, all slots are full. Call the grow function.
	   * Add the student to the first empty element.
	   * @param s 	student to be added
	   */
	  public void add(Student s){     
		  int i = 0;
	      while(i < numStudents) {
	    	  if(studentList[i].equals(null)) {
	    		  studentList[i] = s;
	    		  numStudents++;
	    		  return;
	    	  }
	    	  i++;
	      }
	      
	      grow();
	      studentList[i] = s;
	      numStudents++;
	  }
	  
	    /**
	   * Removes a team member from the team array.
	   * If it is found, set the item to be removed equal to the last item in the array.
	   * Clear the last element in the array.
	   * @param s 	team member to be removed
	   * @return true if found, false if not found
	   */
	  public boolean remove(Student s){
	      int found = find(s);
	      
	      if(found != -1) {
	    	  studentList[found] = studentList[numStudents - 1];
	    	  studentList[numStudents - 1] = null;
	    	  numStudents--;
	    	  return true;
	      }
	      
	      return false;
	  } 
	  
	    /**
	   * Determines if the studentList array contains a specific student.
	   * compareTo() is utilized here.
	   * @param s 	student being searched for
	   * @return	true if the studentList contains the student, false otherwise
	   */
	  public boolean contains(Student s){
		 int i = 0;
	     while(i < numStudents) {
	    	 if(studentList[i].compareTo(s) == 0) {
	    		 return true;
	    	 }
	    	 i++;
	     }
	     
	     return false;
	  }
	   /**
	   * Prints the names of all students on separate lines.
	   * Formatted as: "actualType.toString() + " tuition due = $" + actualType.tuitionDue()"
	   */
	  public void print(){
		  int i;
		  if(numStudents == 0) {
			  System.out.println("There are no students in the list.");
			  return;
		  }
		  for(i = 0; i < numStudents; i++) {
			  if(studentList[i].tuitionDue() > 0) {
				  System.out.printf(studentList[i].toString() + " tuition due = $");
				  System.out.printf("%,d\n", studentList[i].tuitionDue());
			  }
		  }
		  
		  return;
	  } 
}

