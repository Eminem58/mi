package com.mi.sys.vo;

import com.mi.sys.entity.WorkerNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * DB WorkerID Assigner for UID Generator视图实体类
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "WorkerNodeVO对象", description = "DB WorkerID Assigner for UID GeneratorVO对象")
public class WorkerNodeVO extends WorkerNode {
	private static final long serialVersionUID = 1L;

}
