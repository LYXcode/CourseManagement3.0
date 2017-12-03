package entity;

/**
 * SeminarGrade class
 * 讨论课成绩
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class SeminarGrade {
	PresentationGrade[] presentationGrade;
	int reportGrade;
	int grade;
	public PresentationGrade[] getPresentationGrade() {
		return presentationGrade;
	}
	public void setPresentationGrade(PresentationGrade[] presentationGrade) {
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
}
