package com.mi.sys.vo;

import com.mi.sys.entity.Oauth2Client;
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
@ApiModel(value = "Oauth2ClientVO对象", description = "Oauth2ClientVO对象")
public class Oauth2ClientVO extends Oauth2Client {
	private static final long serialVersionUID = 1L;

}
