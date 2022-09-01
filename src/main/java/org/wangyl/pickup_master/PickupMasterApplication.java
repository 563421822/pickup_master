package org.wangyl.pickup_master;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.wangyl.pickup_master.mapper.CourseMapper;
import org.wangyl.pickup_master.mapper.UserMapper;

@SpringBootApplication
@MapperScan(basePackageClasses = {UserMapper.class, CourseMapper.class})
public class PickupMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupMasterApplication.class, args);
    }

}
