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
 * 系统账户信息
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
@ApiModel(value="User对象", description="系统账户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "账号名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    private String passwordRand;

    @ApiModelProperty(value = "中文名")
    private String realName;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    private String email;

    private String orgCode;

    @ApiModelProperty(value = "账户身份代码(0是企业，1是普通用户)")
    private String identityCode;

    @ApiModelProperty(value = "为1表示后台用户，不传为前台用户")
    private String sysCode;

    @ApiModelProperty(value = "状态(0:已删除,1:正常;2:已冻结;3:待验证)")
    private Integer status;

    @ApiModelProperty(value = "如为vip体验账号，值为VIP_TY_ACCOUNT")
    private String validateCode;

    private LocalDateTime activatedTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    private String createUser;

    private LocalDateTime updateTime;

    @ApiModelProperty(value = "修改人")
    private String updateUser;

    @ApiModelProperty(value = "生日")
    private String birthday;

    @ApiModelProperty(value = "登录验证码")
    private String captcha;

    @ApiModelProperty(value = "发送验证码时间")
    private LocalDateTime captchaTime;

    private String qq;

    private String wx;

    private String icon;

    private String positionLevel;


}
