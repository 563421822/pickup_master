package org.wangyl.pickup_master.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class User{
    private Integer id;

    private String username;

    private Byte gender;

    private String email;

    private String password;

    private String avatar;

    private Date birthday;

    private Date createTime;

    private Date updateTime;

    private Boolean status;
}