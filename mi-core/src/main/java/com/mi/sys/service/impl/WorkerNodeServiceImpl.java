package com.mi.sys.service.impl;

import com.mi.sys.entity.WorkerNode;
import com.mi.sys.mapper.WorkerNodeMapper;
import com.mi.sys.service.WorkerNodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * DB WorkerID Assigner for UID Generator 服务实现类
 * </p>
 *
 * @author 金彪
 * @since 2021-01-19
 */
@Service
public class WorkerNodeServiceImpl extends ServiceImpl<WorkerNodeMapper, WorkerNode> implements WorkerNodeService {

}
