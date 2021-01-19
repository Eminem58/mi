package com.mi.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("sys_oauth2_client")
@ApiModel(value="Oauth2Client对象", description="")
public class Oauth2Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String clientName;

    private String clientId;

    private String clientSecret;

    private String logoutUrl;


}
