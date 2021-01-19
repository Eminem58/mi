package com.mi.sys.service.impl;

import com.mi.sys.entity.UserAddress;
import com.mi.sys.mapper.UserAddressMapper;
import com.mi.sys.service.UserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户地址表 服务实现类
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

}
