package entity;

import java.util.Date;

/**
 * Course class
 * 课程
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class Course {
	int id;
	User teacher;
	String name;
	int numClass;
	int numStudent;
	Date startTime;
	Date endTime;
	String description;
	Proportions proportions;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getTeacher() {
		return teacher;
	}
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumClass() {
		return numClass;
	}
	public void setNumClass(int numClass) {
		this.numClass = numClass;
	}
	public int getNumStudent() {
		return numStudent;
	}
	public void setNumStudent(int numStudent) {
		this.numStudent = numStudent;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Proportions getProportions() {
		return proportions;
	}
	public void setProportions(Proportions proportions) {
		this.proportions = proportions;
	}
}
