package com.heima;

import com.heima.service.Service;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;


public class ServiceApplication {
    public static void main(String[] args) throws Exception {
        //
        ServerSocket ss = new ServerSocket(10086);

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(200,
                500,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(500),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        while (true) {
            Socket socket = ss.accept();
            poolExecutor.submit(new Service(socket));
        }
    }
}
