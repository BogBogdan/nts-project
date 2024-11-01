package org.example;

import java.util.Map;

public class Record {
    public long timestamp;
    public int priority;
    public double longitude;
    public double latitude;
    public int altitude;
    public int angle;
    public int satellites;
    public int speed;
    public Map<Integer, Object> ioElements;

    @Override
    public String toString() {
        return "Record{" +
                "timestamp=" + timestamp +
                ", priority=" + priority +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", altitude=" + altitude +
                ", angle=" + angle +
                ", satellites=" + satellites +
                ", speed=" + speed +
                ", ioElements=" + ioElements +
                '}';
    }
}

