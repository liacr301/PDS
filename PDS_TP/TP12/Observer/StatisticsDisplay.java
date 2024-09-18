package TP12.Observer;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay implements Observer {
    private List<Float> tempStatistics = new ArrayList<>();
    private List<Float> humidityStatistics = new ArrayList<>();

    @Override
    public void update(float temperature, float humidity) {
        tempStatistics.add(temperature);
        humidityStatistics.add(humidity);
        display();
    }

    public void display() {
        System.out.println("Statistics - Avg Temperature: " + average(tempStatistics) + "C, Avg Humidity: " + average(humidityStatistics) + "%");
    }

    private float average(List<Float> data) {
        float sum = 0;
        for (float d : data) {
            sum += d;
        }
        return sum / data.size();
    }
}
