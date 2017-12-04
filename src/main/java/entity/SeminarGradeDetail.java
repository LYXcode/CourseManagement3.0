package entity;

/**
 * SeminarGradeDetail class
 * 讨论课成绩信息
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class SeminarGradeDetail {
    String seminarName;
	String groupName;
	String leaderName;
	int presentationGrade;
	int reportGrade;
	int grade;
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public int getPresentationGrade() {
		return presentationGrade;
	}
	public void setPresentationGrade(int presentationGrade) {
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
    public String getSeminarName() {
        return seminarName;
    }
    public void setSeminarName(String seminarName) {
        this.seminarName = seminarName;
    }
}
