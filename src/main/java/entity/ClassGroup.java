package entity;

/**
 * ClassGroup class
 * 课堂小组
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class ClassGroup {
	User leader;
	User[] members;
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	public User[] getMembers() {
		return members;
	}
	public void setMembers(User[] members) {
		this.members = members;
	}
}
