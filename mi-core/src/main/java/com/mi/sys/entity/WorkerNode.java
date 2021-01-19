package com.mi.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * DB WorkerID Assigner for UID Generator
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="WorkerNode对象", description="DB WorkerID Assigner for UID Generator")
public class WorkerNode implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "auto increment id")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "host name")
    @TableField("HOST_NAME")
    private String hostName;

    @ApiModelProperty(value = "port")
    @TableField("PORT")
    private String port;

    @ApiModelProperty(value = "node type: ACTUAL or CONTAINER")
    @TableField("TYPE")
    private Integer type;

    @ApiModelProperty(value = "launch date")
    @TableField("LAUNCH_DATE")
    private LocalDate launchDate;

    @ApiModelProperty(value = "modified time")
    @TableField("MODIFIED")
    private LocalDateTime modified;

    @ApiModelProperty(value = "created time")
    @TableField("CREATED")
    private LocalDateTime created;


}
