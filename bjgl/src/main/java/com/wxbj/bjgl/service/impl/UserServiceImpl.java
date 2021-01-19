package com.wxbj.bjgl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wxbj.bjgl.entity.User;
import com.wxbj.bjgl.mapper.UserMapper;
import com.wxbj.bjgl.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-12-19
 */
@Service
public class UserServiceImpl  implements IUserService {

    @Resource
    private UserMapper UserMapper;

    public User login(User user){
        QueryWrapper<User> query = Wrappers.query();
        query.like("name_Cam",user.getNameCam()).like("password_Cam",user.getPasswordCam());
        return UserMapper.selectOne(query);
    }
}
