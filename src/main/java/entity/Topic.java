package entity;

/**
 * Topic class
 * 讨论课题目
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class Topic {
	int id;
	String serial;
	String name;
	String description;
	int groupLimit;
	int groupMemberLimit;
	int groupLeft;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
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
	public int getGroupLimit() {
		return groupLimit;
	}
	public void setGroupLimit(int groupLimit) {
		this.groupLimit = groupLimit;
	}
	public int getGroupMemberLimit() {
		return groupMemberLimit;
	}
	public void setGroupMemberLimit(int groupMemberLimit) {
		this.groupMemberLimit = groupMemberLimit;
	}
	public int getGroupLeft() {
		return groupLeft;
	}
	public void setGroupLeft(int groupLeft) {
		this.groupLeft = groupLeft;
	}
}
