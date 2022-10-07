package org.wangyl.pickup_master;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.wangyl.pickup_master.mapper")
public class PickupMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickupMasterApplication.class, args);
    }

}
