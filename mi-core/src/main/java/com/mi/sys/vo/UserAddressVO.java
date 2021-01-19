package com.mi.sys.vo;

import com.mi.sys.entity.UserAddress;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 用户地址表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserAddressVO对象", description = "用户地址表VO对象")
public class UserAddressVO extends UserAddress {
	private static final long serialVersionUID = 1L;

}
