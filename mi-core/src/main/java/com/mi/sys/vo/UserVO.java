package com.mi.sys.vo;

import com.mi.sys.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 系统账户信息视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserVO对象", description = "系统账户信息VO对象")
public class UserVO extends User {
	private static final long serialVersionUID = 1L;

}
