package server;

import model.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Server {
    private static List<Integer> list = new ArrayList<>();

    public Data processing(Data data) {
        delay();
        list.add(data.getX());
        data.setX(list.size());

        return data;
    }

    private void delay(){
        try {
            TimeUnit.MILLISECONDS.sleep((long) (100 + Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
