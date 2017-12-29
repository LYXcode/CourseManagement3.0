package xmu.crms.service;

import java.math.BigInteger;
import java.util.List;

import xmu.crms.entity.School;
import xmu.crms.dao.SchoolDao;

/**
 * SchoolServiceImp class
 * SchoolService的实现
 * @author 吕柏翰
 * @date 2017/12/21
 */
public class SchoolServiceImp implements SchoolService{

	/**
	 * 按城市名称查学校.
	 * <p>根据城市名称，查询出在该城市的所有学校<br>
	 * @author 吕柏翰
	 * @param city 城市名称
	 * @return list 学校列表
	 */
	@Override
	public List<School> listSchoolByCity(String city) {
		return SchoolDao.listSchoolByCity(city);
	}

	/**
	 * 添加学校.
	 * <p>根据学校详细的信息，添加相应学校<br>
	 * @author 吕柏翰
	 * @param school 学校的信息
	 * @return true（添加学校成功）/false（添加学校未成功）
	 */
	@Override
	public Boolean insertSchool(School school) {
		return SchoolDao.insertSchool(school);
	}

	/**
	 * 获取省份列表.
	 * <p>获取所有省份的名称<br>
	 * @author LiuAiqi
	 * @return list 省份名称列表
	 */
	@Override
	 public List<String> listProvince(){
		 return null;
	 }
	
	/**
	 * 获取城市列表.
	 * <p>根据省份名称，获取该省份所有城市名称，返回城市名称列表<br>
	 * @author LiuAiqi
	 * @param province 省份名称
	 * @return list 城市名称列表
	 */
	@Override
	 public List<String> listCity(String province){
		 return null;
	 }
	 
	/**
	 * 获取学校信息.
	 * <p>根据学校id，获取该学校的所有信息<br>
	 * @author 吕柏翰
	 * @param SchoolId 学校id
	 * @return School 学校信息
	 */
	@Override
	public School getSchoolBySchoolId(BigInteger SchoolId) {
		School temp=new School();
		temp.setId(SchoolId);
		return SchoolDao.getSchoolBySchoolId((temp));
	}

}
