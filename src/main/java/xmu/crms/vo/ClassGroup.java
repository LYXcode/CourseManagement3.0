package xmu.crms.vo;

import java.util.List;

/**
 * ClassGroup class
 * 课堂小组
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class ClassGroup {
	int id;
	xmu.crms.vo.User leader;
	xmu.crms.vo.User[] members;
	
	public ClassGroup(xmu.crms.entity.FixGroup fixGroup,List<xmu.crms.entity.User> members){
		this.id=fixGroup.getId().intValue();
		this.leader=new xmu.crms.vo.User(fixGroup.getLeader());
		this.members=new xmu.crms.vo.User[members.size()];
		for(int i=0;i<members.size();++i)
			this.members[i]=new xmu.crms.vo.User(members.get(i));
	}
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
