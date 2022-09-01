package org.wangyl.pickup_master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.wangyl.pickup_master.entity.Course;
import org.wangyl.pickup_master.service.ICourseService;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    ICourseService courseService;

    @GetMapping(value = "/")
    public String getOverAll(ModelMap modelMap) {
        Map<String, List<Course>> map = courseService.getOverAll();
        modelMap.addAttribute("overall", map);
        return "index";
    }
}
