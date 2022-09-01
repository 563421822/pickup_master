package org.wangyl.pickup_master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.wangyl.pickup_master.service.IUserService;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
}
