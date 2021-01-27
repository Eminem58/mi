package com.mi.sys.service.impl;

import com.mi.sys.service.IKillByQueueService;
import com.mi.sys.service.IKillService;
import com.mi.sys.vo.KiilBeanVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 金彪
 * @date 2021-01-27
 */
@Service
@Slf4j
public class KillByQueueService implements IKillByQueueService {

    private Queue<KiilBeanVO> killQueue = new ConcurrentLinkedQueue<>();
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
    @Autowired
    private IKillService killService;

    @Override
    public void addQueue(KiilBeanVO kiilBeanVO) {
        killQueue.offer(kiilBeanVO);
    }

    public KillByQueueService() {
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            KiilBeanVO kiilBeanVO = killQueue.poll();
            if (kiilBeanVO != null) {
                killService.killByLua(kiilBeanVO.getKillId(), kiilBeanVO.getUserId());
            }
        }, 0, 1, TimeUnit.MILLISECONDS);
    }
}
