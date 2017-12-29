package xmu.crms.vo;

/**
 * Class class
 * 课堂
 * @author 艾星
 * @date 2017/12/02
 */
public class Class {
    Integer id;
    Integer courseId;
    String name;
    Integer numStudent;
    String time;
    String site;
    Integer calling;
    String roster;
    String courseName;
    String courseTeacher;
    Integer[] proportions;
    /**
     * @author 艾星
     * @serialData 2017-12-22 18:04
     * @param classInfo
     * @param course
     * @param user
     */
    public Class(xmu.crms.entity.ClassInfo classInfo){
    	this.id=new Integer(classInfo.getId().intValue());
    	this.courseId=new Integer(classInfo.getCourse().getId().intValue());
    	this.name=classInfo.getName();
    	//this.numStudent
    	this.site=classInfo.getSite();
    	//this.calling;
    	//this.roster;
    	this.courseName=classInfo.getCourse().getName();
    	this.courseTeacher=classInfo.getCourse().getTeacher().getName();
    	this.proportions=new Integer[5];
    	proportions[0]=classInfo.getReportPercentage();
    	proportions[1]=classInfo.getPresentationPercentage();
    	proportions[2]=classInfo.getFivePointPercentage();
    	proportions[3]=classInfo.getFourPointPercentage();
    	proportions[4]=classInfo.getThreePointPercentage();
    }
    
    public Class(){}
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getNumStudent() {
        return numStudent;
    }
    public void setNumStudent(Integer numStudent) {
        this.numStudent = numStudent;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        this.site = site;
    }
    public Integer getCalling() {
        return calling;
    }
    public void setCalling(Integer calling) {
        this.calling = calling;
    }
    public String getRoster() {
        return roster;
    }
    public void setRoster(String roster) {
        this.roster = roster;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseTeacher() {
        return courseTeacher;
    }
    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }
    public Integer[] getProportions() {
        return proportions;
    }
    public void setProportions(Integer[] proportions) {
        this.proportions = proportions;
    }

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
}
