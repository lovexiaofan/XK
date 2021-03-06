package com.XK.service;

import com.XK.dao.departmentDao;
import com.XK.model.courseModel;
import com.XK.model.departmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class departmentService {

    private departmentDao departmentDao;
    @Autowired
    public void setDepartmentDao(departmentDao departmentDao){
        this.departmentDao = departmentDao;
    }

    //查询学院编号
    public String getDepartmentNo(String departmentname){
        departmentModel departmentModel = new departmentModel();
        departmentModel.setDepartmentname(departmentname);
        return departmentDao.getDepartmentNo(departmentModel);
    }

    //查询学院名称
    public String getDepartmentName(String departmentno){
        departmentModel departmentModel = new departmentModel();
        departmentModel.setDepartmentno(departmentno);
        return departmentDao.getDepartmentName(departmentModel);
    }

    //根据课程号查询学院名称
    public List<departmentModel> getDepartmentNameFromCourse(String courseno){
        courseModel courseModel = new courseModel();
        courseModel.setCourseno(courseno);
        return departmentDao.getDepartmentNameFromCourse(courseModel);
    }

    //根据课程名查询学院名称
    public List<departmentModel> getDepartmentNameFromCourseName(String coursename){
        courseModel courseModel = new courseModel();
        courseModel.setCoursename(coursename);
        return departmentDao.getDepartmentNameFromCourseName(courseModel);
    }

}
