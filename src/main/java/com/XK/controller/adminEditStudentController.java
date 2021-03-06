package com.XK.controller;

import com.XK.model.studentModel;
import com.XK.service.departmentService;
import com.XK.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class adminEditStudentController {

    private studentService studentService;
    @Autowired
    public void setStudentService(studentService studentService){
        this.studentService = studentService;
    }

    private departmentService departmentService;
    @Autowired
    public void setDepartmentService(departmentService departmentService){
        this.departmentService = departmentService;
    }

    @RequestMapping(path = "/adminEditStudent")
    public String toAdminEditStudent(Model model, HttpServletRequest request){
        List<studentModel> studentModels = studentService.getAllStudent();
        model.addAttribute("student", studentModels);
        if (request.getSession().getAttribute("message") != null){
            String message = request.getSession().getAttribute("message").toString();
            request.setAttribute("message", message);
            request.getSession().setAttribute("message","");
        }
        return "admin/editStudent";
    }

    @RequestMapping(path = "/adminEditStudentSave")
    public String editStudent(HttpServletRequest request){
        String sno = request.getParameter("no");
        String sex = request.getParameter("sex");
        String tel = request.getParameter("tel");
        String departmentname = request.getParameter("academy");
        String departmentno = departmentService.getDepartmentNo(departmentname);
        if (sex.equals("male")){
            sex = "男";
        }
        else {
            sex = "女";
        }
        try {
            studentService.updateStudentInfo(sno, sex, tel, departmentno);
            request.getSession().setAttribute("message", "更新成功");
        }catch (Exception e){
            request.getSession().setAttribute("message", "更新失败");
        }
        return "redirect: adminEditStudent";
    }

}
