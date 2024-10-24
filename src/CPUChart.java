import java.util.ArrayList;
import java.util.List;

public class CPUChart {
    public static void lineChartValues(cpuInfo cpu){
        //temporary timer
        int count = 0;
        int idle;

        List<Integer> chartValues = new ArrayList<Integer>();

        while (count <10){
            int[] vals = CPUCoreArray.getCoreStats(cpu, 1, 0);
            idle = vals[0];


            System.out.println(chartValues);
            if(chartValues.size() == 5){
                chartValues.removeFirst();
            }
            chartValues.add(idle);
            count++;
        }
    }
}
