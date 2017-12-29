package xmu.crms.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import xmu.crms.entity.School;
import xmu.crms.mapper.MyBatisUtils;
import xmu.crms.mapper.SchoolMapper;
/**
 * SchoolDao class
 * 
 * @author 吕柏翰
 * @date 2017/12/19
 */
@Component
public interface SchoolDao {
	/**
	 * 按城市名称查学校.
	 * <p>根据城市名称，查询出在该城市的所有学校<br>
	 * @author 吕柏翰
	 * @param city 城市名称
	 * @return list 学校列表
	 */
	public static List<School> listSchoolByCity(String city){
		return SchoolMapper.listSchoolByCity(city);
	}
	
	/**
	 * 添加学校.
	 * <p>根据学校详细的信息，添加相应学校<br>
	 * @author 吕柏翰
	 * @param school 学校的信息
	 * @return true（添加学校成功）/false（添加学校未成功）
	 */
	public static Boolean insertSchool(School school){
		return SchoolMapper.insertSchool(school);
	}
	
	/**
	 * 获取学校信息.
	 * <p>根据学校id，获取该学校的所有信息<br>
	 * @author 吕柏翰
	 * @param SchoolId 学校id
	 * @return School 学校信息
	 */
	public static School getSchoolBySchoolId(School schoolId){
		return SchoolMapper.getSchoolBySchoolId(schoolId);
	}
}
