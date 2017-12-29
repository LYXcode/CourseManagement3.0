package xmu.crms.vo;

/**
 * User class
 * 用户
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class User {
	int id;
	Enum<UserEnum> type;
	String number;
	String name;
	String phone;
	String email;
	Enum<GenderEnum> gender;
	School school;
	String title;
	String password;
	String unionId;
	String avatar;
	String jwt;
	
	@Override
	public String toString()
	{
		return id+"\n"+type+"\n"+number+"\n"+name+"\n"
				+phone+"\n"+email+"\n"+gender+"\n"+school.toString()+"\n"+title+"\n"+password+"\n"+
				unionId+"\n"+avatar+"\n"+jwt;
	}
	
	/**
	 * @author 艾星
	 * @serialData 2017-12-22 19:13
	 */
	public User(){}
	
	/**
	 * @author 艾星
	 * @serialData 2017-12-22 19:09
	 * @param user
	 * @param school
	 */
	public User(xmu.crms.entity.User user){
		this.id=user.getId().intValue();
		this.type=user.getType().intValue()==1?UserEnum.teacher:UserEnum.student;
		this.number=user.getNumber();
		this.name=user.getName();
		this.phone=user.getPhone();
		this.email=user.getEmail();
		this.gender=user.getGender().intValue()==1?GenderEnum.female:GenderEnum.male;
		this.school=new xmu.crms.vo.School(user.getSchool());
		if(user.getTitle()!=null)
			this.title=user.getTitle().intValue()==1?"教授":"非教授";
		this.password=user.getPassword();
		this.unionId=user.getOpenid();
		this.avatar=user.getAvatar();
		//this.jwt
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Enum<UserEnum> getType() {
		return type;
	}
	public void setType(Enum<UserEnum> type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Enum<GenderEnum> getGender() {
		return gender;
	}
	public void setGender(Enum<GenderEnum> gender) {
		this.gender = gender;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
    public String getJwt() {
        return jwt;
    }
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
