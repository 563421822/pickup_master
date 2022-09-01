package org.wangyl.pickup_master;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.wangyl.pickup_master.entity.User;
import org.wangyl.pickup_master.mapper.UserMapper;
import org.wangyl.pickup_master.service.IUserService;

@SpringBootTest
class PickupMasterApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.selectByEmail("563421822@qq.com");
        System.out.println(user.getPassword());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(user.getPassword());
        System.out.println("encode = " + encode);
        user.setPassword(encode);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
