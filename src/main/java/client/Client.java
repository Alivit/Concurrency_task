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

    private List<Integer> requestList = new ArrayList<>();
    private int accumulator = 0;
    private int size;

    public Client(int size){
        this.size = size;
    }

    public Client(){
        size = 100;
    }

    public void send() {
        ExecutorService executorService;
        requestList = Generate.generateList(size);

        executorService = Executors.newFixedThreadPool(requestList.size());

        while (!requestList.isEmpty()) calculation(executorService.submit(new Request(requestList)));

        executorService.shutdown();

        System.out.println(accumulator);
    }

    private void calculation(Future<Integer> future){
        ReentrantLock locker = new ReentrantLock();
        locker.lock();
        try {
            accumulator += future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        locker.unlock();
    }

    public List<Integer> getRequestList() {
        return requestList;
    }

    public int getAccumulator() {
        return accumulator;
    }
}

