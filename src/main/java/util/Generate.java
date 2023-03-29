package util;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class Generate {
    private static int size;

    public static void generateList(List<Integer> list){
        try {
            int i = 0;
            Map<String, Map<String,Object>> data = new Yaml().load(new FileReader("src/main/resources/application.yml"));
            size = (int) data.get("list").get("size");
            while (list.size() < size) list.add(++i);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int generateIndex(List<Integer> list){
        return (int) (0 + Math.random() * (list.size() - 1));
    }
}
