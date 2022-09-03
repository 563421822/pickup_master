package org.wangyl.pickup_master.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class Course{
    private Integer id;

    private Integer course;

    private String poster;

    private BigDecimal price;

    private BigDecimal originalPrice;

    private String catalogue;

    private String type;

    private String version;

    private Date createTime;

    private Date updateTime;

    private Byte status;

    transient private String name;

    transient private String engName;

    transient private String title;

    transient private String avatar;

    transient private String description;
}