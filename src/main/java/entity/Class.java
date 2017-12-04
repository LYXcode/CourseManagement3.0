package entity;

/**
 * Class class
 * 课堂
 * @author 艾星
 * @date 2017/12/02
 */
public class Class {
    Integer id;
    String name;
    Integer numStudent;
    String time;
    String site;
    Integer calling;
    String roster;
    String courseName;
    String courseTeacher;
    Integer[] proportions;
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
}
