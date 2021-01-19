package com.mi.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dict_data")
@ApiModel(value="DictData对象", description="")
public class DictData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "所属字典组")
    private String type;

    @ApiModelProperty(value = "字典项编码")
    private String code;

    @ApiModelProperty(value = "字典中文名称")
    private String cname;

    @ApiModelProperty(value = "字典英文名称")
    private String ename;

    @ApiModelProperty(value = "默认值")
    private Integer defaultValue;

    @ApiModelProperty(value = "是否有效")
    private Integer valid;

    private String parentId;

    @ApiModelProperty(value = "RESV1")
    @TableField("RESV1")
    private String resv1;

    @ApiModelProperty(value = "RESV2")
    @TableField("RESV2")
    private String resv2;

    @ApiModelProperty(value = "排序号")
    private Integer sortNo;


}
