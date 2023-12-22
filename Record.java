

//Class
public class Record {

 // Instance variables
 private String name;
 private int idNumber;
 private String contactNumber;
 private int semester;
 private String department;


 // Default Constructor
 public Record() {}

 // Parameterized Constructor
 // @param name
 // @param idNumber
 // @param contactNumber
 // @param Department
 // @param Semester
 public Record(String name, int idNumber,
		 String contactNumber,String department, int semester)
 {

     // this keyword refers to current instance itself
     this.name = name;
     this.idNumber = idNumber;
     this.contactNumber = contactNumber;
     this.department = department;
     this.semester = semester;
 }

 // Getting the value of contactNumber
 // @return the value of contactNumber
 public String getContactNumber() { return contactNumber; }

 // Set the value of contactNumber
 // @param contactNumber new value of contactNumber
 public void setContactNumber(String contactNumber)
 {

     this.contactNumber = contactNumber;
 }
//Getting the value of contactNumber
// @return the value of contactNumber
public String getDepartment() { return department; }

// Set the value of contactNumber
// @param contactNumber new value of contactNumber
public void setDepartment(String department)
{

   this.department = department;
}

 // Getting the value of idNumber
 // @return the value of idNumber
 public int getIdNumber() { return idNumber; }

 // Setting the value of idNumber
 // @param idNumber new value of idNumber
 public void setIdNumber(int idNumber)
 {
     this.idNumber = idNumber;
 }

 // Getting the value of name
 // @return the value of name
 public String getName() { return name; }

 // Setting the value of name
 // @param name new value of name
 public void setName(String name) { this.name = name; }
 
 public int getSemester() { return semester; }

 // Setting the value of name
 // @param name new value of name
 public void setSemester(int semester) { this.semester = semester ; }
 


 // toString() Method
 // @return
 @Override public String toString()
 {
	 return "\n\tName= " + name + "\n\tIdNumber= " + idNumber + "\n\tContactNumber= "
 + contactNumber + "\n\tDepartment=" + department + "\n\tSemester=" + semester;

	 

 }
}