package entity;


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
    String startTime;
    String endTime;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String string) {
		this.startTime = string;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String string) {
		this.endTime = string;
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
