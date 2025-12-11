package Day11;

import java.util.ArrayList;
import java.util.Arrays;

public class Device {

    public String name;
    public Device[] outputs;

    public int pathsToOut;

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
