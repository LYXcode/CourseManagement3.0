package entity;

import java.util.Date;

public class Seminar {
    int id;
    String name;
    String description;
    String groupingMethod;
    Date startTime;
    Date endTime;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getGroupingMethod() {
        return groupingMethod;
    }
    public void setGroupingMethod(String groupingMethod) {
        this.groupingMethod = groupingMethod;
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
}
