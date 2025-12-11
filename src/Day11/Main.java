package Day11;

import util.AOC;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static ArrayList<Device> devices = new ArrayList<>();

    public static void main(String[] args) {
        String[] input = AOC.input("src/Day11/testinput2.txt");
        AOC.printInput(input);

        for (int i = 0; i < input.length; i++) {
            String[] splitName = input[i].split(": ");
            String name = splitName[0];
            String[] outputs = splitName[1].split(" ");
            createDevice(name,outputs);
        }

        Device youDevice = null;
        Device svrDevice = null;
        for (Device device : devices){
            System.out.println(device);
            if(device.name.equals("you")){
                youDevice = device;
            } else if (device.name.equals("svr")) {
                svrDevice = device;
            }
        }

        if(youDevice != null) {
            int result1 = youDevice.calculatePathsToOut();

            System.out.println("Day 11 Part 1: " + result1);
        }


        if(svrDevice != null) {
            long[] result2 = svrDevice.calculatePathsToOut2(false, false);

            System.out.println("Day 12 Part 2: " + result2[0]);
        }


    }

    public static void createDevice(String name, String[] outputs){
        System.out.println(name +  " -> " + Arrays.toString(outputs));
        Device[] out = new Device[outputs.length];
        for (int i = 0; i < outputs.length; i++) {
            out[i] = retrieveExistingDevice(outputs[i]);
        }

        Device newDevice = retrieveExistingDevice(name);
        newDevice.setOutputs(out);
    }

    public static Device retrieveExistingDevice(String name){
        for(Device device : devices){
            if(device.name.equals(name))
                return device;
        }
        Device newDevice = new Device(name);
        devices.add(newDevice);
        return newDevice;
    }
}
