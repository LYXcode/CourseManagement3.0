package xmu.crms.mapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import xmu.crms.entity.School;
import xmu.crms.entity.User;
/**
 * SchoolMapper class
 * 
 * @author 吕柏翰
 * @date 2017/12/21
 */
public class SchoolMapper {
	/**
	 * 按城市名称查学校.
	 * <p>根据城市名称，查询出在该城市的所有学校<br>
	 * @author 吕柏翰
	 * @param city 城市名称
	 * @return list 学校列表
	 */
	public static List<School> listSchoolByCity(String city){
		List<School> result=new ArrayList<School>();
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
        	result = (List) session.selectList("xmu.crms.mapper.SchoolMapper.listSchoolByCity", city);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        return result;
	}
	
	/**
	 * 添加学校.
	 * <p>根据学校详细的信息，添加相应学校<br>
	 * @author 吕柏翰
	 * @param school 学校的信息
	 * @return true（添加学校成功）/false（添加学校未成功）
	 */
	public static Boolean insertSchool(School school){
		SqlSession session = MyBatisUtils.getSqlSession();
        try {
            session.insert("xmu.crms.mapper.SchoolMapper.insertSchool", school);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
        return true;
	}
	
	/**
	 * 获取学校信息.
	 * <p>根据学校id，获取该学校的所有信息<br>
	 * @author 吕柏翰
	 * @param SchoolId 学校id
	 * @return School 学校信息
	 */
	public static School getSchoolBySchoolId(School schoolId){
        School result=null;
        SqlSession session = MyBatisUtils.getSqlSession();
        try {
            result = (School) session.selectOne("xmu.crms.mapper.SchoolMapper.getSchoolBySchoolId", schoolId);
            MyBatisUtils.closeSession(session);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        return result;
	}
}
