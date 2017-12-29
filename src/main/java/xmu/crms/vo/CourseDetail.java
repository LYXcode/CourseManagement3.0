package xmu.crms.vo;

/**
 * CourseDetail class
 * 课程信息
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class CourseDetail {
	int id;
	String name;
	String description;
	String teacherName;
	String teacherEmail;
	
	public CourseDetail(xmu.crms.entity.Course course,xmu.crms.entity.User teacher){
		this.id=course.getId().intValue();
		this.name=course.getName();
		this.description=course.getDescription();
		this.teacherEmail=teacher.getEmail();
		this.teacherName=teacher.getName();
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
}
