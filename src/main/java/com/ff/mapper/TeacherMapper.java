package com.ff.mapper;

import java.util.List;

import com.ff.po.Teacher;

public interface TeacherMapper {
	//返回值表示成功插入了多少条
	public int insertTeacher(Teacher teacher);
	//查询出所有的老师
	public List<Teacher> selectAllTeacher();
}
