package com.mi.sys.vo;

import com.mi.sys.entity.DepartmentInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 部门信息表视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DepartmentInfoVO对象", description = "部门信息表VO对象")
public class DepartmentInfoVO extends DepartmentInfo {
	private static final long serialVersionUID = 1L;

}
