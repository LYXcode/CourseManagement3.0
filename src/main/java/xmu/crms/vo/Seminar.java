package xmu.crms.vo;


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
    public Seminar(xmu.crms.entity.Seminar sem){
    	this.id=sem.getId().intValue();
    	this.name=sem.getName();
    	this.description=sem.getDescription();
    	this.groupingMethod=sem.getFixed()==true?GroupingEnum.fixed:GroupingEnum.random;
    	this.startTime=sem.getStartTime().toString();
    	this.endTime=sem.getEndTime().toString();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Enum<GroupingEnum> getGroupingMethod() {
		return groupingMethod;
	}
	public void setGroupingMethod(Enum<GroupingEnum> groupingMethod) {
		this.groupingMethod = groupingMethod;
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
}
