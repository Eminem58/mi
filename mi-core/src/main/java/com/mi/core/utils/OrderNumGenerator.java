package com.mi.core.utils;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 生成全局唯一ID
 */
@Component
public class OrderNumGenerator implements Runnable {
    private String time;

    private AtomicInteger value;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private Thread thread;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /**
     * 连接符
     */
    private String splitString = "";
    /**
     * 原子数长度
     */
    private int initial = 10;
    /**
     * 自增步长
     */
    private int rollingInterval = 1;
    /**
     * 两位随机数字
     */
    private String randomValue;

    public OrderNumGenerator() {
        time = LocalDateTime.now().format(FORMATTER);
        value = new AtomicInteger(initial);
        thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    public String nextId(String prefix) {
        lock.readLock().lock();
        int ends = ThreadLocalRandom.current().nextInt(99);
        //如果不足两位，前面补0
        DecimalFormat df = new DecimalFormat("00");
        randomValue = df.format(ends);
        StringBuffer sb = new StringBuffer(prefix).append(splitString).append(randomValue).append(time.substring(3)).append(splitString).append(value.getAndIncrement());
        lock.readLock().unlock();
        return sb.toString();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000 * rollingInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String now = LocalDateTime.now().format(FORMATTER);
            if (!now.equals(time)) {
                lock.writeLock().lock();
                time = now;
                value.set(initial);
                lock.writeLock().unlock();
            }
        }
    }
}
