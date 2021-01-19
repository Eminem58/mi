package com.mi.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品秒杀
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tp_kill_goods_price")
@ApiModel(value="KillGoodsPrice对象", description="商品秒杀")
public class KillGoodsPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品规格id")
    private Integer specGoodsId;

    @ApiModelProperty(value = "状态：1，有效;2，无效")
    private Integer status;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "库存数量")
    private Integer killCount;

    @ApiModelProperty(value = "开始时间")
    private LocalDateTime begainTime;

    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endTime;


}
