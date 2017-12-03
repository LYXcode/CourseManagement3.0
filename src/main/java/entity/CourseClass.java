package entity;

/**
 * CourseClass class
 * 课程班级关联
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class CourseClass {
	int id;
	String name;
	int numStudent;
	String time;
	String site;
	String courseName;
	User courseTeacher;
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
	public int getNumStudent() {
		return numStudent;
	}
	public void setNumStudent(int numStudent) {
		this.numStudent = numStudent;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public User getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(User courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
}
