public class CPUCoreArray {
    public static int[] getCoreStats(cpuInfo cpu, int seconds, int core){
        cpu.read(seconds);
        //move to be initialize variable later
        int cores = cpu.coresPerSocket();
        int[] coreTimes = new int[cores];

        coreTimes[0] = cpu.getIdleTime(core);
        coreTimes[1] = cpu.getUserTime(core);
        coreTimes[2] = cpu.getSystemTime(core);

        return coreTimes;
    }
}
