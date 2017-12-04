package entity;

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
    Enum<GroupingEnum> groupingMethod;
    String startTime;
    String endTime;
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
	public Class[] getClasses() {
		return classes;
	}
	public void setClasses(Class[] classes) {
		this.classes = classes;
	}
    public Enum<GroupingEnum> getGroupingMethod() {
        return groupingMethod;
    }
    public void setGroupingMethod(Enum<GroupingEnum> groupingMethod) {
        this.groupingMethod = groupingMethod;
    }
}
