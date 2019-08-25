package com.XK.dao;

import com.XK.model.studentModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface studentDao {

    //学生登录
    @Select("select spass from student where sno = #{sno}")
    public String getStudentPass(studentModel studentModel);

    //加入学生信息
    @Insert("insert into student values (#{sno}, #{spass}, #{sname}, #{sex}, #{tel}, #{departmentno})")
    public void insertStudent(studentModel studentModel);

    //获取最大学生编号
    @Select("select max(sno) from student")
    public String getMaxStudentSno();

    //删除学生信息
    @Delete("delete from student where sno = #{sno} and sname = #{sname}")
    public void deleteStudent(studentModel studentModel);

    //查询学生信息
    @Select("select * from student where sno = #{sno}")
    public List<studentModel> getStudentInfo(studentModel studentModel);

    //查询全部学生信息
    @Select("select * from student")
    public List<studentModel> getAllStudent();

}
