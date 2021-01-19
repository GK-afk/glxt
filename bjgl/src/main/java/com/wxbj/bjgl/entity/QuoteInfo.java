package com.wxbj.bjgl.entity;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-12-19
 */
@Data
@TableName("test")
public class QuoteInfo {

    private static final long serialVersionUID = 1L;
    @TableId(value = "Id",type = IdType.AUTO)
    private Integer Id;

    private Integer userId;


    private String test;


    private String test1;


    private String test2;


    private String test3;


    private LocalDateTime inputDate;


    private String status;


}
