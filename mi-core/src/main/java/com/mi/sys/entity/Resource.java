package com.mi.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("sys_resource")
@ApiModel(value="Resource对象", description="")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "CODE")
    private String code;

    @ApiModelProperty(value = "父ID")
    private String parentId;

    @ApiModelProperty(value = "身份标识,0:通用,1:服务商,2:客户( 此为榕宇通平台定义，可根据实际修改字典）")
    private Integer identifying;

    @ApiModelProperty(value = "URL")
    private String url;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "功能类型0-菜单、1-按钮、2-默认权限（只要有父节点权限就会有该权限）")
    private Integer type;

    @ApiModelProperty(value = "排序号")
    private Integer sortNo;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人")
    private String updateUser;

    private LocalDateTime updateTime;


}
