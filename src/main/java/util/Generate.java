package util;

import java.util.ArrayList;
import java.util.List;

public class Generate {

    public static List<Integer> generateList(int size){
        List<Integer> list = new ArrayList<>();
        int i = 0;

        while (list.size() < size) list.add(++i);
        return list;
    }

    public static int generateIndex(List<Integer> list){
        return (int) (0 + Math.random() * (list.size() - 1));
    }


}
