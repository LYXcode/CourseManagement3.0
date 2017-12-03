package entity;

/**
 * Group class
 * 小组
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class Group {
	int id;
	String name;
	User leader;
	User[] members;
	Topic[] topics;
	String report;
	SeminarGrade[] grade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	public User[] getMembers() {
		return members;
	}
	public void setMembers(User[] members) {
		this.members = members;
	}
	public Topic[] getTopics() {
		return topics;
	}
	public void setTopics(Topic[] topics) {
		this.topics = topics;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public SeminarGrade[] getGrade() {
		return grade;
	}
	public void setGrade(SeminarGrade[] grade) {
		this.grade = grade;
	}
}
