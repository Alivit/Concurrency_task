package client;

import logic.Request;
import util.Generate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;


public class Client {

    private List<Integer> list = new ArrayList<>();
    private int accumulator = 0;

    public void send() {
        ExecutorService executorService;

        Generate.generateList(list);
        executorService = Executors.newFixedThreadPool(list.size());

        while (!list.isEmpty()) calculation(executorService.submit(new Request(list)));

        executorService.shutdown();

        System.out.println("Size list: " + list.size());
        System.out.println("Total sum: "+ accumulator);
    }

    private void calculation(Future<Integer> future){
        ReentrantLock locker = new ReentrantLock();
        locker.lock();
        try {
            System.out.println(accumulator += future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        locker.unlock();
    }
}

