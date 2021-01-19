package com.mi.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mi.sys.dao.UserDao;
import com.mi.sys.entity.User;
import com.mi.sys.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 系统账户信息(User)表服务实现类
 *
 * @author makejava
 * @since 2021-01-19 19:33:19
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}