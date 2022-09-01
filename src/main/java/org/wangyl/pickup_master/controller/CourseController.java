package org.wangyl.pickup_master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wangyl.pickup_master.entity.Course;
import org.wangyl.pickup_master.service.ICourseService;

import java.util.List;

@Controller
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    ICourseService courseService;

    @GetMapping(value = "/{id}")
    public String getDetail(@PathVariable int id, Model model) {
        List<Course> list = courseService.getDetail(id);
        model.addAttribute("detail", list);
        return "detail";
//        return "redirect:/" + detail;
    }
}
