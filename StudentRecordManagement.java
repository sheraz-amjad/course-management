
//Importing required classes

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Class
public class StudentRecordManagement extends Record {

	// Creating an empty LinkedList
	List<Record> list;
	
	LinkedList<StudentCourses> studentCoursesList;

	// Default Constructor
	public StudentRecordManagement() {
		list = new ArrayList<Record>();
		studentCoursesList = new LinkedList<>();
	}

	// Method 1
	// Adding Record
	// @param record
	public void add(Record record, StudentCourses studentCourses) {

		if (!find(record.getIdNumber())) {

			try {

				String sqlToAddStudentInfo = "INSERT INTO " + AccessConnectivity.studentInfoTable
						+ " (idNumber, name, contactNumber, semester, department) VALUES (?, ?, ?, ?, ?)";

				String sqlToAddStudentCourses = "INSERT INTO " + AccessConnectivity.studentCoursesTable
						+ " (studentId, course1, course2, course3, course4, course5, course6) VALUES (?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement preparedStatementForStudentInfo = AccessConnectivity.connection
						.prepareStatement(sqlToAddStudentInfo);
				// Setting values for Each Parameter
				preparedStatementForStudentInfo.setInt(1, record.getIdNumber());
				preparedStatementForStudentInfo.setString(2, record.getName());
				preparedStatementForStudentInfo.setString(3, record.getContactNumber());
				preparedStatementForStudentInfo.setInt(4, record.getSemester());
				preparedStatementForStudentInfo.setString(5, record.getDepartment());
				// Executing Query
				preparedStatementForStudentInfo.executeUpdate();

				PreparedStatement preparedStatementForStudentCourses = AccessConnectivity.connection
						.prepareStatement(sqlToAddStudentCourses);
				preparedStatementForStudentCourses.setInt(1, record.getIdNumber());
				preparedStatementForStudentCourses.setString(2, studentCourses.getCourse1());
				preparedStatementForStudentCourses.setString(3, studentCourses.getCourse2());
				preparedStatementForStudentCourses.setString(4, studentCourses.getCourse3());
				preparedStatementForStudentCourses.setString(5, studentCourses.getCourse4());
				preparedStatementForStudentCourses.setString(6, studentCourses.getCourse5());
				preparedStatementForStudentCourses.setString(7, studentCourses.getCourse6());

				preparedStatementForStudentCourses.executeUpdate();

				System.out.println("data inserted successfully");
			} catch (Exception e) {

				System.out.print(e.getLocalizedMessage());

			}
		} else {

			// Print statement
			System.out.println("\n\tRecord already exists in the Record list");
		}
	}

	// Method 2
	// Searching Record
	// @param idNimber
	// @return
	public boolean find(int idNimber) {

		// Iterating record list
		// using for each loop
		for (Record l : list) {

			// Checking record by id Number
			if (l.getIdNumber() == idNimber) {

				System.out.println(l);
				return true;
			}
		}
		return false;
	}

	// Method 3
	// Delete Record
	// @param recIdNumber
	public void delete(int recIdNumber) {

		String sqlToDeleteFromStudentInfo = "DELETE FROM " + AccessConnectivity.studentInfoTable + " WHERE idNumber = "
				+ recIdNumber;

		String sqlToDeleteFromStudentCourses = "DELETE FROM " + AccessConnectivity.studentCoursesTable
				+ " WHERE studentId = " + recIdNumber;

		try {
			PreparedStatement preparedStatementForStudentInfo = AccessConnectivity.connection
					.prepareStatement(sqlToDeleteFromStudentInfo);

			preparedStatementForStudentInfo.executeUpdate();

			PreparedStatement preparedStatementForStudentCourses = AccessConnectivity.connection
					.prepareStatement(sqlToDeleteFromStudentCourses);

			preparedStatementForStudentCourses.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	// Method 4
	// Finding Record
	// @param idNumber
	// @return
	public Record findRecord(int studentID) {

		Record record = new Record();

		try {
			String sqlToSearchFromStudentInfo = "SELECT * FROM " + AccessConnectivity.studentInfoTable
					+ " WHERE idNumber = " + studentID;

			PreparedStatement preparedStatementForStudentInfo = AccessConnectivity.connection
					.prepareStatement(sqlToSearchFromStudentInfo);

			ResultSet resultSet = preparedStatementForStudentInfo.executeQuery();

			while (resultSet.next()) {
				String idNumber = resultSet.getString("idNumber");
				String name = resultSet.getString("name");
				String contactNum = resultSet.getString("contactNumber");
				String semester = resultSet.getString("semester");
				String department = resultSet.getString("department");

				record.setContactNumber(contactNum);
				record.setDepartment(department);
				record.setIdNumber(Integer.parseInt(idNumber));
				record.setName(name);
				record.setSemester(Integer.parseInt(semester));

			}
		} catch (Exception e) {
			System.out.print(e.getLocalizedMessage());
		}

		return record;
	}

	// Method 5
	// Update Record
	// @param id
	// @param input
	public void update(int id, Scanner input) {

//		if (find(id)) {
			Record rec = findRecord(id);

			int option2 = 0;

			do {

				submenu();

				option2 = input.nextInt();

				// Switch case
				switch (option2) {

				case 1:

					input.nextLine();

					// Display message only
					System.out.print("\n\tWhat is the new name for student : ");
					String name = input.nextLine();
					rec.setName(name);
					System.out.println("\n\tRecord Updated Successfully");
					break;

				case 2:

					// Display message only
					System.out.print("\n\tWhat is the new contact number for student : ");
					String contactNumber = input.nextLine();
					rec.setContactNumber(contactNumber);
					System.out.println("\n\tRecord Updated Successfully");
					break;

				case 3:

					input.nextLine();

					// Display message only
					System.out.print("\n\tWhat is the new department for student : ");
					String department = input.nextLine();
					rec.setContactNumber(department);
					System.out.println("\n\tRecord Updated Successfully");
					break;

				case 4:
					System.out.println("\n\tExit Successfully");
					break;

				default:

					// Print statement
					System.out.println("\nInvalid Input\n");
					break;
				}
			} while (option2 != 4);

			try {
				String sqlToUpdateStudentInfo = "UPDATE " + AccessConnectivity.studentInfoTable + " SET" + " name = "
						+ "'"+ rec.getName() + "'" + " ,contactNumber = " + "'" + rec.getContactNumber() + "'" + " ,department = "
						+ "'" + rec.getDepartment() + "'" + " WHERE idNumber = " + rec.getIdNumber();
				
				System.out.print(sqlToUpdateStudentInfo);
				
				PreparedStatement preparedStatementForStudentInfo = AccessConnectivity.connection
						.prepareStatement(sqlToUpdateStudentInfo);
				
				preparedStatementForStudentInfo.executeUpdate();
			}
			catch(Exception e) {
				System.out.print(e.getLocalizedMessage());
			}

//		} else {
//
//			// Print statement
//			System.out.println("\n\tRecord Not Found in the Student list");
//		}
	}

	// Method 6
	// Display Records
	public void display() {

		if (AccessConnectivity.connected) {
			try {

				list.clear();
				studentCoursesList.clear();
				
				String sql = "select * from " + AccessConnectivity.studentInfoTable;

				PreparedStatement preparedStatement = AccessConnectivity.connection.prepareStatement(sql);
				// Creating Java ResultSet object
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					String idNumber = resultSet.getString("idNumber");
					String name = resultSet.getString("name");
					String contactNum = resultSet.getString("contactNumber");
					String semester = resultSet.getString("semester");
					String department = resultSet.getString("department");

					Record record = new Record();
					record.setContactNumber(contactNum);
					record.setDepartment(department);
					record.setIdNumber(Integer.parseInt(idNumber));
					record.setName(name);
					record.setSemester(Integer.parseInt(semester));
					
					String sqlForCourses = "Select * from StudentCourses where studentId = " + record.getIdNumber();
					
					PreparedStatement queryForCourses = AccessConnectivity.connection.prepareStatement(sqlForCourses);
					ResultSet resultforCourses = queryForCourses.executeQuery();
					
					while(resultforCourses.next()) {
						StudentCourses studentCourses = new StudentCourses();
						int studentId = resultforCourses.getInt("studentId");
						String course1 = resultforCourses.getString("course1");
						String course2 = resultforCourses.getString("course2");
						String course3 = resultforCourses.getString("course3");
						String course4 = resultforCourses.getString("course4");
						String course5 = resultforCourses.getString("course5");
						String course6 = resultforCourses.getString("course6");
						
						studentCourses.setStudentId(studentId);
						studentCourses.setCourse1(course1);
						studentCourses.setCourse2(course2);
						studentCourses.setCourse3(course3);
						studentCourses.setCourse4(course4);
						studentCourses.setCourse5(course5);
						studentCourses.setCourse6(course6);
						
						studentCoursesList.add(studentCourses);
					}
					

					list.add(record);
				}

			} catch (Exception e) {
				System.out.println("Error in connection" + e.getLocalizedMessage());

			}

			// If record list is empty then
			// print the message below
			if (list.isEmpty()) {

				// Print statement
				System.out.println("\n\tThe list has no records\n");
			}
			// Iterating Record list
			// using for each loop
			
			for(int i = 0 ; i < list.size() ; i++) {
				Record record = list.get(i);
				System.out.println(record.toString());
				
				StudentCourses studentCourses = studentCoursesList.get(i);
				System.out.print(studentCourses.getCourse1());
				System.out.print(studentCourses.getCourse2());
				System.out.print(studentCourses.getCourse3());
				System.out.print(studentCourses.getCourse4());
				System.out.print(studentCourses.getCourse5());
				System.out.println(studentCourses.getCourse6());
				
			}
			
//			for (Record record : list) {
//
//				// Printing the list
//				System.out.println(record.toString());
//				
//			
//			}
		} else {
			System.out.println("Database is not connected");
		}

	}

	public static void submenu() {

		// Printing statements displaying menu on console
		System.out.println("\n\t*****************************************************");
		System.out.println("\t=====================================================");
		System.out.println("\n\t\tWELCOME TO COURSE MANAGEMENT SYSTEM\n");
		System.out.println("\t=====================================================");
		System.out.println("\t*****************************************************\n");
		System.out.println("\t1: Update Student Name");
		System.out.println("\t2: Update Student Contact");
		System.out.println("\t3: Update Student Department");
		System.out.println("\t4: Exit");
		System.out.print("\n\tEnter your selection : ");
	}
}
