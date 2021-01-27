package com.mi.sys.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 秒杀信息VO对象
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@ApiModel(value = "KiilBeanVO对象", description = "秒杀信息VO对象")
public class KiilBeanVO {
    private static final long serialVersionUID = 1L;
    private Integer killId;
    private String userId;
}
