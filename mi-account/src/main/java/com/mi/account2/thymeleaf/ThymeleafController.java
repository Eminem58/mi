package com.mi.account2.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * 3种方式返回页面
 * @author 金彪
 * @date 2021-02-01
 */
@Controller
public class ThymeleafController {

    @GetMapping("/getStudents")
    public ModelAndView getStudent() {
        List<Student> students = new LinkedList<>();
        Student student = new Student();
        student.setId(1);
        student.setName("学习笔记");
        student.setAge(21);
        Student student1 = new Student();
        student1.setId(2);
        student1.setName("张三");
        student1.setAge(22);
        students.add(student);
        students.add(student1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("students");
        return modelAndView;
    }

    @RequestMapping("/getString")
    public String getString(HttpServletRequest request) {
        String name = "学习笔记";
        request.setAttribute("name", name);
        return "index.html";
    }

    @RequestMapping("/getModel")
    public String getModel(Model model) {
        model.addAttribute("key", "这是一个键");
        //去掉末尾的.html也可以，因为我们在配置文件里面设置了文件的格式为HTML文件。return的字符串都是对应的HTML文件的名称
        return "index.html";
    }
}
