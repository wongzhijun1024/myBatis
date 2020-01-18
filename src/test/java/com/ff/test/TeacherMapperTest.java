package com.ff.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ff.mapper.TeacherMapper;
import com.ff.po.Teacher;
import com.ff.util.DBUtil;

public class TeacherMapperTest {
	
	
	public void insertTeacherTest1() {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession(); 
		Teacher teacher = new Teacher("明明", "男", 23, "123");
		session.insert("com.ff.mapper.TeacherMapper.insertTeacher", teacher);
		session.commit();//提交
		session.close();
	}
	public void insertTeacherTest2() {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession(); 
		Teacher teacher = new Teacher("老子", "男", 23, "123");
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		teacherMapper.insertTeacher(teacher);
		session.commit();//提交
		session.close();
	}
	//事务处理
	public void insertTeacherTest3() {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession(); 
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		try {
			teacherMapper.insertTeacher(new Teacher("妻子","女",20, "123"));
			teacherMapper.insertTeacher(new Teacher("老公", "男", 23, "123"));
			session.commit();//提交
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();//回滚
		}finally {
			session.close();//关闭
		}
	}
	
	
	public void selectAllTeacherTest() {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession(); 
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		System.out.println(">"+teacherMapper);
		System.out.println(session.getMapper(TeacherMapper.class));
		System.out.println(session.getMapper(TeacherMapper.class));
        List<Teacher> list = teacherMapper.selectAllTeacher();
		session.commit();//提交
		session.close();
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
	}
	
	public static void main(String[] args) {
		TeacherMapperTest test = new TeacherMapperTest();
		test.insertTeacherTest1();
		test.insertTeacherTest2();
		test.selectAllTeacherTest();
	}
}







