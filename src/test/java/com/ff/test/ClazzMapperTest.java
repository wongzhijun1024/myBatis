package com.ff.test;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.ff.mapper.ClazzMapper;
import com.ff.po.ClazzStu;
import com.ff.util.DBUtil;

public class ClazzMapperTest {

	public void selectAllClassAndStuTest() {
		SqlSession session =  DBUtil.getSqlSessionFactory().openSession(); 
		ClazzMapper mapper = session.getMapper(ClazzMapper.class);
		List<ClazzStu> list = mapper.selectAllClassAndStu();
		for (ClazzStu clazzStu : list) {
			System.out.println(clazzStu);
		}
	}
	
	public static void main(String[] args) {
		ClazzMapperTest test = new ClazzMapperTest();
		test.selectAllClassAndStuTest();
	}
}









