package xmu.crms.vo;

/**
 * PresentationGrade class
 * 展示得分
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class PresentationGrade {
	int topicId;
	int grade;
	public PresentationGrade(xmu.crms.entity.SeminarGroupTopic seminarGroupTopic){
		this.topicId=seminarGroupTopic.getTopic().getId().intValue();
		this.grade=seminarGroupTopic.getSeminarGroup().getFinalGrade().intValue();
	}
	public PresentationGrade() {
        // TODO Auto-generated constructor stub
    }
    public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
