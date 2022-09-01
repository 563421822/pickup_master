package org.wangyl.pickup_master.service;

import org.wangyl.pickup_master.entity.Course;

import java.util.List;
import java.util.Map;

public interface ICourseService {
    Map<String, List<Course>> getOverAll();

    List<Course> getDetail(int id);
}
