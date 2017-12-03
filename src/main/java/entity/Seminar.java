package entity;

import java.util.Date;

/**
 * Seminar class
 * 讨论课
 * @author 艾星
 * @date 2017/12/02
 */
public class Seminar {
    int id;
    String name;
    String description;
    Enum<GroupingEnum> groupingMethod;
    Date startTime;
    Date endTime;
    Topic[] topics;
    Proportions proportions;
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
	public Topic[] getTopics() {
		return topics;
	}
	public void setTopics(Topic[] topics) {
		this.topics = topics;
	}
	public Proportions getProportions() {
		return proportions;
	}
	public void setProportions(Proportions proportions) {
		this.proportions = proportions;
	}
	public Enum<GroupingEnum> getGroupingMethod() {
		return groupingMethod;
	}
	public void setGroupingMethod(Enum<GroupingEnum> groupingMethod) {
		this.groupingMethod = groupingMethod;
	}
}
