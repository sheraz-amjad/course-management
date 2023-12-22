
//Importing required classes
import java.util.Scanner;

//Class
public class StudentRecordLinkedList {

	// Main driver method
	public static void main(String[] args) {
		
		AccessConnectivity.connectToDatabase();

		// Creating HumanResourceOffice Object.
		StudentRecordManagement sr = new StudentRecordManagement();

		Record record = new Record();

		// Creating Scanner Object to read input
		Scanner input = new Scanner(System.in);

		// Creating option integer variable
		int option = 0;

		// Do - While loop
		do {
			mainmenu();
			option = input.nextInt();

			// Switch case
			switch (option) {

			// Case 1
			case 1:

				input.nextLine();

				// Display message
				System.out.print("\tWhat is the Student Name : ");

				String name = input.nextLine();

				// Display message
				System.out.print("\tWhat is the Student Id Number : ");

				int idNumber = input.nextInt();

				input.nextLine();

				// Display message
				System.out.print("\tWhat is the Department Name : ");

				String department = input.nextLine();

				// Display message
				System.out.print("\tWhat is the Student contact Number : ");

				String contactNumber = input.nextLine();

				System.out.print("\tWhat is the Semester No : ");

				int semester = input.nextInt();
				// Semester 1
				String course1 = "\n\t P.O.F";
				String course2 = "\n\t English";
				String course3 = "\n\t Pakistan Studies";
				String course4 = "\n\t Islamic Studies";
				String course5 = "\n\t Applied Physics";
				String course6 = "\n\t I.C.T";
				// Semester 2
				String course7 = "\n\t Object Oriented Programming";
				String course8 = "\n\t Communication and Presentation Skills";
				String course9 = "\n\t Intro to Psychology";
				String course10 = "\n\t Calculus and Analytical Geometry";
				String course11 = "\n\t Discrete Structures";
				String course12 = "\n\t Social Service";
				// Semester 3
				String course13 = "\n\t Data Structures and Algorithms";
				String course14 = "\n\t Digital Logic Design";
				String course15 = "\n\t Linear Algebra";
				String course16 = "\n\t Professional Pratices";
				String course17 = "\n\t CS Supporting - I, Multi Variable Calculus";
				
				StudentCourses studentCourses = new StudentCourses();
				
				switch (semester) {

				case 1:

					System.out.println("Name= " + name);
					System.out.println("Id Number= " + idNumber);
					System.out.println("Department= " + department);
					System.out.println("Contact No= " + contactNumber);
					System.out.println("Semester= " + semester);
					System.out.println("Course= " + course1 + course2 + course3 + course4 + course5 + course6);
					
					studentCourses.setCourse1(course1);
					studentCourses.setCourse2(course2);
					studentCourses.setCourse3(course3);
					studentCourses.setCourse4(course4);
					studentCourses.setCourse5(course5);
					studentCourses.setCourse6(course6);
					
					break;

				case 2:

					System.out.println("Enter number of P.O.F");

					int number = input.nextInt();

					if (number <= 50) {
						System.out.println("Do your want repeat P.O.F \n 1 for YES \n 0 for NO");
						int i = input.nextInt();

						if (i == 1) {

							System.out.println(
									"\tCourse= " + course1 + course8 + course9 + course10 + course11 + course12);
							
							
							studentCourses.setCourse1(course1);
							studentCourses.setCourse2(course8);
							studentCourses.setCourse3(course9);
							studentCourses.setCourse4(course10);
							studentCourses.setCourse5(course11);
							studentCourses.setCourse6(course12);
							
						} else {

							System.out.println("\tCourse= " + course8 + course9 + course10 + course11 + course12);
							
							studentCourses.setCourse1(course8);
							studentCourses.setCourse2(course9);
							studentCourses.setCourse3(course10);
							studentCourses.setCourse4(course11);
							studentCourses.setCourse5(course12);
						
						}
					} else {
						System.out.println("\tCourse= " + course7 + course8 + course9 + course10 + course11 + course12);
						
						studentCourses.setCourse1(course7);
						studentCourses.setCourse2(course8);
						studentCourses.setCourse3(course9);
						studentCourses.setCourse4(course10);
						studentCourses.setCourse5(course11);
						studentCourses.setCourse6(course12);
					}
					break;

				case 3:

					System.out.println("Enter number of O.O.P");

					int number2 = input.nextInt();

					if (number2 <= 50) {
						System.out.println("Do your want repeat O.O.P \n 1 for YES \n 0 for NO");
						int i = input.nextInt();

						if (i == 1) {

							System.out.println("\tCourse= " + course7 + course14 + course15 + course16 + course17);
							
							studentCourses.setCourse1(course7);
							studentCourses.setCourse2(course14);
							studentCourses.setCourse3(course15);
							studentCourses.setCourse4(course16);
							studentCourses.setCourse5(course17);
						
							
						} else {

							System.out.println("\tCourse= " + course14 + course15 + course16 + course17);
							
							studentCourses.setCourse1(course14);
							studentCourses.setCourse2(course15);
							studentCourses.setCourse3(course16);
							studentCourses.setCourse4(course17);
						
						}
					} else {
						System.out.println("\tCourse= " + course13 + course14 + course15 + course16 + course17);
						
						studentCourses.setCourse1(course13);
						studentCourses.setCourse2(course14);
						studentCourses.setCourse3(course15);
						studentCourses.setCourse4(course16);
						studentCourses.setCourse5(course17);
					
					}
					break;

				}

				// Create record object
				// parameters.
				record = new Record(name, idNumber, contactNumber, department, semester);
				// Call add() record
				
				
				sr.add(record,studentCourses);
				
				System.out.println("\n*******************************************");
				System.out.println("===========================================");
				System.out.println("\n\tStudent Added Successfully\n");
				System.out.println("===========================================");
				System.out.println("*******************************************\n");

				// Break statement used to terminate program
				// from here only once it entered this case
				break;

			// Case 2
			case 2:

				// Display message
				System.out.print("\n\tWhat is the Student id number ? ");
				int rId = input.nextInt();

				// Invoke remove/delete record
				sr.delete(rId);

				break;

			// Case 3
			case 3:

				// Display message
				System.out.print("\n\tWhat is the Student id number? ");

				int rIdNo = input.nextInt();
				sr.update(rIdNo, input);

				break;

			// Case 4
			case 4:

				// Display message
				System.out.print("\n\tWhat is the Student id ? ");
				int bookId = input.nextInt();
				
				Record foundRecord = sr.findRecord(bookId);
				if(foundRecord.getIdNumber() == 0) {
					System.out.println("No record found");
				}
				else {
					System.out.println(foundRecord.toString());
				}
				

//				if (!sr.findRecord(bookId)) {
//					System.out.println("\n\tStudent id does not exist\n");
//				}

				break;

			// Case 5
			case 5:
				sr.display();
				break;

			// Case 6
			case 6:

				// Display message
				System.out.println("\n\t*****************************************************");
				System.out.println("\t=====================================================");
				System.out.println("\n\t\tThank you for using the program.\n");
				System.out.println("\t=====================================================");
				System.out.println("\t*****************************************************");
				System.out.println("\t SUBMITTED BY \t\t   PHONE NO \t\t   DATE");
				System.out.println("\n\t Fahad khan \t\t 0333-1472575 \t\t 4-June-2022");
				System.out.println("\n\t Waleed Azam\t\t 0335-4724306 \t\t 4-June-2022");
				System.out.println("\n\t Faheel Butt\t\t 0320-8519058 \t\t 4-June-2022");
				System.out.println("\n\t Fardeen Asif\t\t 0316-0143982 \t\t 4-June-2022");
				System.exit(0);

				break;

			// Case 7: Default case
			// If none above case executes
			default:

				// Print statement
				System.out.println("\nInvalid input\n");
				break;
			}
		}

		// Checking condition
		while (option != 6);
	}


	// Method 2
	// Menu - Static menu for displaying options
	public static void mainmenu() {

		// Printing statements displaying menu on console
		System.out.println("\n\t*****************************************************");
		System.out.println("\t=====================================================");
		System.out.println("\n\t\tWELCOME TO COURSE MANAGEMENT SYSTEM\n");
		System.out.println("\t=====================================================");
		System.out.println("\t*****************************************************\n");
		System.out.println("\t1: Add Student Data");
		System.out.println("\t2: Delete Student Data");
		System.out.println("\t3: Update Student Data");
		System.out.println("\t4: Search Student Data");
		System.out.println("\t5: Display Students Data");
		System.out.println("\t6: Exit program");
		System.out.print("\n\tEnter your selection : ");
	}
}
