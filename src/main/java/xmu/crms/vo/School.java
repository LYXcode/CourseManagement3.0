package xmu.crms.vo;

/**
 * School class
 * 学校
 * @author 吕柏翰
 * @date 2017/12/03
 */
public class School {
	int id;
	String name;
	String province;
	String city;
	public School(xmu.crms.entity.School school){
	    if(school!=null)
	    {
		this.id=school.getId().intValue();
	    this.name=school.getName();
	    this.province=school.getProvince();
	    this.city=school.getCity();
	    }
	}
	
	@Override
	public String toString(){
		return id+"\n"+name+"\n"+province+"\n"+city;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
