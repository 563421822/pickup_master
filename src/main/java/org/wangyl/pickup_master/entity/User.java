package org.wangyl.pickup_master.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {
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

    @Serial
    private static final long serialVersionUID = 1L;
}