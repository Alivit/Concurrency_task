package logic;

import model.Data;
import server.Server;
import util.Generate;

import java.util.List;
import java.util.concurrent.Callable;

public class Request implements Callable<Integer> {

    private Data data;
    private List<Integer> list;

    public Request(List<Integer> list){
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        generateRequest();
        data = Server.processing(data);
        return data.getX();
    }

    private void generateRequest(){
        int index = Generate.generateIndex(list);
        data = new Data(list.get(index));
        list.remove(index);
    }
}
