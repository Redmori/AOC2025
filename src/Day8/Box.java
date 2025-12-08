package Day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Box {

    public long x;
    public long y;
    public long z;

    ArrayList<Box> connected = new ArrayList<>();

    TreeMap<Long, Box> map = new TreeMap<>();

    public Box(String location){
        String[] parsedLocation = location.split(",");
        x = Long.parseLong(parsedLocation[0]);
        y = Long.parseLong(parsedLocation[1]);
        z = Long.parseLong(parsedLocation[2]);
        connected.add(this);
    }

    public void Connect(Box newBox){
//        for(Box box : connected){
//            box.connected.add(newBox);
//        }
//        connected.add(newBox);
        connected.addAll(newBox.connected);
        for(Box otherBox : connected){
            otherBox.connected = connected;
        }
    }

    public boolean isConnected(Box otherBox){
        return connected.contains(otherBox);
    }

    public long distanceTo(Box box){
        return (x - box.x)*(x - box.x) + (y - box.y)*(y - box.y) + (z - box.z)*(z - box.z);
    }

    public void storeDistance(Box otherBox, long distance){
        map.put(distance, otherBox);
    }

    public void removeStoredDistance(Box otherBox){

    }

    @Override
    public String toString(){
        return "(" + x + "," + y + "," + z + ")";
    }
}
