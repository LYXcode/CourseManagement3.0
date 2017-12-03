package entity;

import java.util.Date;

public class Course {
    String name;
    String id;
    Date startTime;
    Date endTime;
    int classNum;
    int stuNum;
    Proportions pro;
    String description;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date beginTime) {
        this.startTime = beginTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public int getClassNum() {
        return classNum;
    }
    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }
    public int getStuNum() {
        return stuNum;
    }
    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }
    public Proportions getPro() {
        return pro;
    }
    public void setPro(Proportions pro) {
        this.pro = pro;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
