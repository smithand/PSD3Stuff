public class StudentCourses {
	
	private String course;
	private String id;
	private String cw;
	private String exam;
	private String total;
	
	public StudentCourses(String course, String id, String cw, String exam, String total) {
		this.course = course;
		this.id = id;
		this.cw = cw;
		this.exam = exam;
		this.total = total;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCw() {
		return cw;
	}
	public void setCw(String cw) {
		this.cw = cw;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	public String toString() {
		return course + "," + id + "," + cw + "," + exam + "," + total;
	}
}