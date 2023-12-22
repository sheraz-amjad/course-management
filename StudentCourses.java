
public class StudentCourses {
	
	int studentId;
	String course1;
	String course2;
	String course3;
	String course4;
	String course5;
	String course6;
	
	public StudentCourses() {}

	public StudentCourses(int studentId, String course1, String course2, String course3, String course4, String course5,
			String course6) {
		
		this.studentId = studentId;
		this.course1 = course1;
		this.course2 = course2;
		this.course3 = course3;
		this.course4 = course4;
		this.course5 = course5;
		this.course6 = course6;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getCourse1() {
		return course1;
	}

	public void setCourse1(String course1) {
		this.course1 = course1;
	}

	public String getCourse2() {
		return course2;
	}

	public void setCourse2(String course2) {
		this.course2 = course2;
	}

	public String getCourse3() {
		return course3;
	}

	public void setCourse3(String course3) {
		this.course3 = course3;
	}

	public String getCourse4() {
		return course4;
	}

	public void setCourse4(String course4) {
		this.course4 = course4;
	}

	public String getCourse5() {
		return course5;
	}

	public void setCourse5(String course5) {
		this.course5 = course5;
	}

	public String getCourse6() {
		return course6;
	}

	public void setCourse6(String course6) {
		this.course6 = course6;
	}	
}