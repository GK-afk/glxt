package com.wxbj.bjgl.service;

import com.wxbj.bjgl.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-12-19
 */
public interface IUserService  {
    User login(User user);
}
