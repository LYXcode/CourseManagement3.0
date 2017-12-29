package xmu.crms.vo;

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
	String startTime;
	String endTime;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
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
