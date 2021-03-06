package com.XK.service;

import com.XK.dao.courseDao;
import com.XK.model.courseModel;
import com.XK.model.scoreModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class courseService {

    private courseDao courseDao;
    @Autowired
    public void setCourseDao(courseDao courseDao){
        this.courseDao = courseDao;
    }

    //开课
    public void insertOpenCourse(String courseno, String cno, String coursename, String credit, String departmentno){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        courseModel.setCno(cno);
        courseModel.setCoursename(coursename);
        courseModel.setCredit(credit);
        courseModel.setDepartmentno(departmentno);
        courseDao.insertOpenCourse(courseModel);
    }

    //关课
    public void deleteCloseCourse(String courseno, String coursename){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        courseModel.setCoursename(coursename);
        courseDao.deleteCloseCourse(courseModel);
    }

    //查询最大课程号
    public String getMaxCourseno(){
        return courseDao.getMaxCourseno();
    }

    //查询开课教师号码
    public String getCourseCno(String courseno){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        return courseDao.getCourseCno(courseModel);
    }

    //查询课程名
    public String getCourseCoursename(String courseno){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        return courseDao.getCourseCoursename(courseModel);
    }

    //查询课程上课信息
    public List<courseModel> getCourseInfo(String courseno){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        return courseDao.getCourseInfo(courseModel);
    }

    //更新课程教室
    public void updateCourseAddress(String courseno, String weekday, String worktime, String courseaddress){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        courseModel.setWeekday(weekday);
        courseModel.setWorktime(worktime);
        courseModel.setCourseaddress(courseaddress);
        courseDao.updateCourseAddress(courseModel);
    }

    //查看教师课表
    public List<courseModel> getTeacherCourseInfo(String cno){
        courseModel courseModel = new courseModel();
        courseModel.setCno(cno);
        return courseDao.getTeacherCourseInfo(courseModel);
    }

    //根据课程号模糊查询
    public List<courseModel> getAllCourseInfo(String courseno){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        return courseDao.getAllCourseInfo(courseModel);
    }

    //根据课程名模糊查询
    public List<courseModel> getAllCourse(String coursename){
        courseModel courseModel = new courseModel();
        courseModel.setCoursename(coursename);
        return courseDao.getAllCourse(courseModel);
    }

    //查看学生课表
    public List<courseModel> getStudentCourse(String sno){
        scoreModel scoreModel = new scoreModel();
        scoreModel.setSno(sno);
        return courseDao.getStudentCourse(scoreModel);
    }

    //根据成绩课程号获取课程名
    public List<courseModel> getStudentScoreCourseName(String sno){
        scoreModel scoreModel = new scoreModel();
        scoreModel.setSno(sno);
        return courseDao.getStudentScoreCourseName(scoreModel);
    }

    //根据成绩课程号获取学分
    public List<courseModel> getStudentCreditCourseName(String sno){
        scoreModel scoreModel = new scoreModel();
        scoreModel.setSno(sno);
        return courseDao.getStudentCreditCourseName(scoreModel);
    }

    //根据成绩课程号教师号获取课程名
    public List<courseModel> getTeacherScoreCourseName(String cno){
        courseModel courseModel = new courseModel();
        courseModel.setCno(cno);
        return courseDao.getTeacherScoreCourseName(courseModel);
    }

}
