package model;

import java.io.Serializable;

public class Data implements Serializable {
    private int x;

    public Data(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Data{" +
                "x=" + x +
                '}';
    }
}
