package entity;

import java.util.Date;

/**
 * SeminarClasses class
 * 讨论课课堂关系
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class SeminarClasses {
	int id;
	String name;
	String courseName;
	Date startTime;
	Date endTime;
	Class[] classes;
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
	public Class[] getClasses() {
		return classes;
	}
	public void setClasses(Class[] classes) {
		this.classes = classes;
	}
}
