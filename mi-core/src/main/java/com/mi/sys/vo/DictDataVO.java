package com.mi.sys.vo;

import com.mi.sys.entity.DictData;
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
@ApiModel(value = "DictDataVO对象", description = "DictDataVO对象")
public class DictDataVO extends DictData {
	private static final long serialVersionUID = 1L;

}
