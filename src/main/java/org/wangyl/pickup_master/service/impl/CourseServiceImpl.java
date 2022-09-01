package org.wangyl.pickup_master.service.impl;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.wangyl.pickup_master.entity.Course;
import org.wangyl.pickup_master.mapper.CourseMapper;
import org.wangyl.pickup_master.service.ICourseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
public class CourseServiceImpl implements ICourseService {
    final CourseMapper courseMapper;
    final TemplateEngine templateEngine;

    public CourseServiceImpl(CourseMapper courseMapper, TemplateEngine templateEngine) {
        this.courseMapper = courseMapper;
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        templateEngine.setTemplateResolver(resolver);
        this.templateEngine = templateEngine;
    }

    @Override
    public Map<String, List<Course>> getOverAll() {
        List<Course> list = courseMapper.getOverAll();
        Set<String> set = new HashSet<>();
        list.forEach(x -> set.add(x.getName()));
        Map<String, List<Course>> finalMap = new HashMap<>();
        set.forEach(s -> {
            List<Course> temp = new ArrayList<>();
            list.forEach(map -> {
                if (map.getName().equals(s)) {
                    temp.add(map);
                }
            });
            finalMap.put(s, temp);
        });
        return finalMap;
    }

    @SneakyThrows
    @Override
    public List<Course> getDetail(int id) {
/*        String name = id + ".html";
        String path = Objects.requireNonNull(this.getClass().getResource("/static")).getPath() + File.separator + name;
        if (new File(path).exists()) return name;
        Context context = new Context();*/
        return courseMapper.getDetail(id);
/*        context.setVariable("detail", list);
        PrintWriter writer = new PrintWriter(path);
        templateEngine.process("detail", context, writer);
        return name;*/
    }
}
