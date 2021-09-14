package com.example.myapplication.service;

import com.example.myapplication.R;
import com.example.myapplication.conf.Configuration;
import com.example.myapplication.entity.ResponseEntity;
import com.example.myapplication.utils.HttpUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class HttpThread {

    public static AtomicReference<Runnable> netWorkTask = new AtomicReference<>();

    private static final AtomicReference<ResponseEntity> response = new AtomicReference<>();

    // 必须新建线程，不然报错
    public static ResponseEntity testConnect() {
        netWorkTask.set(() -> {
            try {
                response.set(HttpUtils.sendGet(Configuration.domain + "/welcome"));
            } catch (Exception e) {
                response.set(new ResponseEntity(e.getMessage()));
            }
        });
        Thread thread = new Thread(netWorkTask.get());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            response.set(new ResponseEntity(e.getMessage()));
        }
        return response.get();
    }


    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }
}

