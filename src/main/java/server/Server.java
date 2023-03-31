package server;

import model.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Server {
    private static List<Integer> responseList = new ArrayList<>();

    public static Data processing(Data data) {
        delay();
        responseList.add(data.getX());
        data.setX(responseList.size());

        return data;
    }

    private static void delay(){
        try {
            TimeUnit.MILLISECONDS.sleep((long) (100 + Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> getResponseList() {
        return responseList;
    }
}
