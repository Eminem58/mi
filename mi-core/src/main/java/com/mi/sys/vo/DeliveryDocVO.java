package com.mi.sys.vo;

import com.mi.sys.entity.DeliveryDoc;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 发货单视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DeliveryDocVO对象", description = "发货单VO对象")
public class DeliveryDocVO extends DeliveryDoc {
	private static final long serialVersionUID = 1L;

}
