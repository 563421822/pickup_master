package org.wangyl.pickup_master.mapper;

import org.wangyl.pickup_master.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User selectByEmail(String email);
    void updateByPrimaryKeySelective(User user);
}