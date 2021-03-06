package xmu.crms.vo;

import java.util.Date;

/**
 * SeminarDetail class
 * 讨论课信息
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class SeminarDetail {
	int id;
	String name;
	String site;
	String startTime;
	String endTime;
	String teacherName;
	String teacherEmail;
	public SeminarDetail(xmu.crms.entity.Seminar sem,xmu.crms.entity.ClassInfo classInfo){
		this.id=sem.getId().intValue();
		this.name=sem.getName();
		this.site=classInfo.getSite();
		this.startTime=sem.getStartTime().toString();
		this.endTime=sem.getEndTime().toString();
		this.teacherName=classInfo.getCourse().getTeacher().getName();
		this.teacherEmail=classInfo.getCourse().getTeacher().getEmail();		
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
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
}
