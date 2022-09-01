package org.wangyl.pickup_master.mapper;

import org.wangyl.pickup_master.entity.Course;

import java.util.List;

public interface CourseMapper {

    List<Course> getOverAll();

    List<Course> getDetail(int id);
}
