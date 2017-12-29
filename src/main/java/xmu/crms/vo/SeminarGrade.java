package xmu.crms.vo;

/**
 * SeminarGrade class
 * 讨论课成绩
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class SeminarGrade {
	PresentationGrade presentationGrade;
	int preGrade;
	int reportGrade;
	int grade;
	public SeminarGrade(xmu.crms.entity.SeminarGroup sg){
		this.grade=sg.getFinalGrade().intValue();
		this.reportGrade=sg.getReportGrade().intValue();
		this.preGrade=sg.getPresentationGrade().intValue();
	}
	public SeminarGrade() {
		// TODO Auto-generated constructor stub
	}
	public PresentationGrade getPresentationGrade() {
		return presentationGrade;
	}
	public void setPresentationGrade(PresentationGrade presentationGrade) {
		this.presentationGrade = presentationGrade;
	}
	public int getReportGrade() {
		return reportGrade;
	}
	public void setReportGrade(int reportGrade) {
		this.reportGrade = reportGrade;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getPreGrade() {
		return preGrade;
	}
	public void setPreGrade(int preGrade) {
		this.preGrade = preGrade;
	}
}
