public class Course {
	
	private String firstName;
	private String surname;
	private String id;
	private String assignmentLab1;
	private String assignmentLab2;
	private String assignmentLab3;
	private String assignmentLab4;
	private String assignmentLab5;
	
	public Course(String firstName, String surname, String id, String assignmentLab1, String assignmentLab2, String assignmentLab3, String assignmentLab4, String assignmentLab5) {
		this.firstName = firstName;
		this.surname = surname;
		this.id = id;
		this.assignmentLab1 = assignmentLab1;
		this.assignmentLab2 = assignmentLab2;
		this.assignmentLab3 = assignmentLab3;
		this.assignmentLab4 = assignmentLab4;
		this.assignmentLab5 = assignmentLab5;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}

	public String getId() {
		return id;
	}

	public String getAssignmentLab1() {
		return assignmentLab1;
	}

	public String getAssignmentLab2() {
		return assignmentLab2;
	}

	public String getAssignmentLab3() {
		return assignmentLab3;
	}

	public String getAssignmentLab4() {
		return assignmentLab4;
	}

	public String getAssignmentLab5() {
		return assignmentLab5;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAssignmentLab1(String assignmentLab1) {
		this.assignmentLab1 = assignmentLab1;
	}

	public void setAssignmentLab2(String assignmentLab2) {
		this.assignmentLab2 = assignmentLab2;
	}

	public void setAssignmentLab3(String assignmentLab3) {
		this.assignmentLab3 = assignmentLab3;
	}

	public void setAssignmentLab4(String assignmentLab4) {
		this.assignmentLab4 = assignmentLab4;
	}

	public void setAssignmentLab5(String assignmentLab5) {
		this.assignmentLab5 = assignmentLab5;
	}
}
