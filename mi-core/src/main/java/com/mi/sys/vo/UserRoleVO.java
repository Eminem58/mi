package com.mi.sys.vo;

import com.mi.sys.entity.UserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserRoleVO对象", description = "UserRoleVO对象")
public class UserRoleVO extends UserRole {
	private static final long serialVersionUID = 1L;

}
