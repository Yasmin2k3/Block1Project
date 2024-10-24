package com;

import java.util.ArrayList;
import java.util.List;

public class CPUChart {
    //gets an arraylist of values every second for cpu busy percentage
    public static void buildBusyLineChart(int busyPercent){

        //temporary timer
        int count=0;

        //will be replaced with whatever the getBusyInfo will return
        int temp = 0;


        //list that will display CPU Busy percent as a line chart
        List<Integer> cpuBusyPercent = new ArrayList<Integer>(5);

        //will constantly update linechart

        while(count < 10){
            temp = (int)(Math.random()*100 + 1);
            System.out.println(cpuBusyPercent);
            if (cpuBusyPercent.size() == 5){
                cpuBusyPercent.removeFirst();
            }
            cpuBusyPercent.add(temp);
            count++;
        }

    }

    public static void main(String[] args) {
        //buildBusyLineChart(1);

    }

}
