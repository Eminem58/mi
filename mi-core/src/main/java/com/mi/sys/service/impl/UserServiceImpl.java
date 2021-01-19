package com.mi.sys.service.impl;

import com.mi.sys.entity.User;
import com.mi.sys.mapper.UserMapper;
import com.mi.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统账户信息 服务实现类
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
