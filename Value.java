public class Value {
	
	private String id;
	private String cw;
	private String exam;
	private String total;
	
	public Value(String cw, String exam, String total) {
		this.cw = cw;
		this.exam = exam;
		this.total = total;
	}
	
	public Value(String id, String cw, String exam, String total) {
		this.id = id;
		this.cw = cw;
		this.exam = exam;
		this.total = total;
	}

	public String getId() {
		return id;
	}

	public String getCw() {
		return cw;
	}

	public String getExam() {
		return exam;
	}

	public String getTotal() {
		return total;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCw(String cw) {
		this.cw = cw;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	public String toString() {
		return getId() + "," + getCw() + "," + getExam() + "," + getTotal();
	}
}