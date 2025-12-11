package Day11;

import java.util.ArrayList;
import java.util.Arrays;

public class Device {

    public String name;
    public Device[] outputs;

    public int pathsToOut;

    public long[] pathsToOut2;
    boolean saved = false;
    boolean visitedDacAfter = false;
    boolean visitedFftAfter = false;

    public Device(String nm){
        name = nm;
    }

    public void setOutputs(Device[] devices){
        outputs = devices;
    }

    public int calculatePathsToOut(){
        if(name.equals("out")) return 1;
        if(pathsToOut != 0) return pathsToOut;
        int sum = 0;
        for (int i = 0; i < outputs.length; i++) {
            sum += outputs[i].calculatePathsToOut();
        }
        pathsToOut = sum;
        return sum;
    }

    public long[] calculatePathsToOut2(boolean visitedDac, boolean visitedFft){
        if(name.equals("out")) {
            if(visitedDac && visitedFft){
                return new long[]{1,0,0,0};
            }
            else{
                return new long[]{0,0,0,0};
            }
        }

        boolean visitedFft2 = visitedFft;
        boolean visitedDac2 = visitedDac;
        if(name.equals("fft")) {
            visitedFft2 = true;
        }
        if(name.equals("dac")) {
            visitedDac2 = true;
        }
//        if(pathsToOut2 > 0 && (visitedDac || visitedDacAfter) && (visitedFft || visitedFftAfter)) {
//            System.out.println("skpping");
//            return pathsToOut2;
//        }

        if(saved){
            return pathsToOut2;
        }

        long[] sum = new long[4];
        for (int i = 0; i < outputs.length; i++) {
            sum[0] += outputs[i].calculatePathsToOut2(visitedDac2, visitedFft2)[0];
        }
        if(name.equals("fft")) {
            sum[1] = sum[0];
        }
        else if(name.equals("dac")) {
            sum[2] = sum[0];
        }

        pathsToOut2 = sum;
        saved = true;
//        pathsToOut2 = sum;
//        if(sum > 0){
//            if(!visitedDac2) {
//                System.out.println("assigned dac after");
//                visitedDacAfter = true;
//            }
//            if(!visitedFft2) {
//                System.out.println("assigned fft after");
//                visitedFftAfter = true;
//            }
//        }
        return sum;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(outputs != null) {
            for (int i = 0; i < outputs.length; i++) {
                sb.append(outputs[i].name);
                sb.append(" ");
            }
        }
        return name + ": " + sb;
    }
}
