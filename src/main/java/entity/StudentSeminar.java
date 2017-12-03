package entity;

import java.util.Date;

/**
 * StudentSeminar class
 * 学生显示的讨论课
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class StudentSeminar {
	int id;
	String name;
	Enum<GroupingEnum> groupingMethod;
	String courseName;
	Date startTime;
	Date endTime;
	int classCalling;
	boolean isLeader;
	boolean areTopicsSelected;
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
	public Enum<GroupingEnum> getGroupingMethod() {
		return groupingMethod;
	}
	public void setGroupingMethod(Enum<GroupingEnum> groupingMethod) {
		this.groupingMethod = groupingMethod;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getClassCalling() {
		return classCalling;
	}
	public void setClassCalling(int classCalling) {
		this.classCalling = classCalling;
	}
	public boolean isLeader() {
		return isLeader;
	}
	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}
	public boolean isAreTopicsSelected() {
		return areTopicsSelected;
	}
	public void setAreTopicsSelected(boolean areTopicsSelected) {
		this.areTopicsSelected = areTopicsSelected;
	}
}
