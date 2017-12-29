package xmu.crms.vo;


/**
 * Course class
 * 课程
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class Course {
	int id;
	xmu.crms.vo.User teacher;
	String name;
	int numClass;
	int numStudent;
	String startTime;
	String endTime;
	String description;
	Proportions proportions;
	/**
	 * @author 艾星
	 * @serialData 2017-12-22 19:37
	 * @param course
	 * @param teacher
	 * @param school
	 * @param numClass
	 * @param numStudent
	 */
	public Course(xmu.crms.entity.Course course,int numClass,int numStudent){
		this.id=course.getId().intValue();
		this.teacher=new xmu.crms.vo.User(course.getTeacher());
		this.numClass=numClass;
		this.numStudent=numStudent;
		this.startTime=course.getStartDate().toString();
		this.endTime=course.getEndDate().toString();
		this.description=course.getDescription();
		this.proportions=new Proportions();
		this.proportions.setPresentation(course.getPresentationPercentage().intValue());
		this.proportions.setReport(course.getReportPercentage().intValue());
		this.proportions.seta(course.getFivePointPercentage().intValue());
		this.proportions.setb(course.getFourPointPercentage().intValue());
		this.proportions.setc(course.getThreePointPercentage().intValue());
	}
	public Course() {
        // TODO Auto-generated constructor stub
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getTeacher() {
		return teacher;
	}
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumClass() {
		return numClass;
	}
	public void setNumClass(int numClass) {
		this.numClass = numClass;
	}
	public int getNumStudent() {
		return numStudent;
	}
	public void setNumStudent(int numStudent) {
		this.numStudent = numStudent;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Proportions getProportions() {
		return proportions;
	}
	public void setProportions(Proportions proportions) {
		this.proportions = proportions;
	}
}
