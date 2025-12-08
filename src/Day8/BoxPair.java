package Day8;

import java.util.Comparator;

public class BoxPair{

    public Box box1;
    public Box box2;
    public long distance;

    public BoxPair(Box b1, Box b2){
        box1 = b1;
        box2 = b2;
        distance = box1.distanceTo(box2);
    }

    public boolean attemptConnect(){
        if(box1.isConnected(box2))
            return false;
        else {
            box1.Connect(box2);
            return true;
        }
    }

    @Override
    public String toString(){
        return box1.toString() + " - " + box2.toString() + " - " + distance;
    }
}
