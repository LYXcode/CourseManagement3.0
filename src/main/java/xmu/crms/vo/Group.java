package xmu.crms.vo;

import java.util.List;

import xmu.crms.entity.SeminarGroupMember;

/**
 * Group class
 * 小组
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class Group {
	int id;
	String name;
	xmu.crms.vo.User leader;
	User[] members;
	xmu.crms.vo.Topic[] topics;
	String report;
	xmu.crms.vo.SeminarGrade grade;
	
	public Group(xmu.crms.entity.SeminarGroup group,List<xmu.crms.entity.User> users){
		this.id=group.getId().intValue();
		//this.name//所有小组都没名字
		this.leader=new xmu.crms.vo.User(group.getLeader());
		this.members=new xmu.crms.vo.User[users.size()];
		for(int i=0;i<users.size();++i)
			this.members[i]=new xmu.crms.vo.User(users.get(i));
		this.report=group.getReport();
		this.grade=new xmu.crms.vo.SeminarGrade();
		if(group.getPresentationGrade()!=null)
		{
			this.grade.setPreGrade(group.getPresentationGrade().intValue());
		}
		if(group.getReportGrade()!=null)
		{
			this.grade.setReportGrade(group.getReportGrade().intValue());
		}
		//this.grade.setPresentation()//我觉得没必要把每个人对这个组的打分记下来
	}
	
	public Group() {
        // TODO Auto-generated constructor stub
    }

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
	public SeminarGrade getGrade() {
		return grade;
	}
	public void setGrade(SeminarGrade grade) {
		this.grade = grade;
	}
}
