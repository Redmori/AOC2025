package Day8;

import util.AOC;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day8/input.txt");
        AOC.printInput(input);

        ArrayList<Box> boxes = new ArrayList<>();
        ArrayList<BoxPair> pairs = new ArrayList<>();

        //Create Boxes
        for (int i = 0; i < input.length; i++) {
            Box newBox = new Box(input[i]);
            boxes.add(newBox);
            System.out.println(newBox);
        }

        //Create Pairs
        for (int i = 0; i < boxes.size(); i++) {
            for (int j = i + 1; j < boxes.size(); j++) {
                BoxPair newPair = new BoxPair(boxes.get(i), boxes.get(j));
                pairs.add(newPair);
            }
        }
        pairs.sort(Comparator.comparingLong(bp -> bp.distance));

        //Connect
        int amountConnected = 0;
        while(amountConnected < 1000 && !pairs.isEmpty()){
            pairs.getFirst().attemptConnect();
            amountConnected++;
            pairs.removeFirst();
        }

        //List the circuits
        ArrayList<ArrayList<Box>> circuits = new ArrayList<>();
        for(Box box : boxes){
            if(!circuits.contains(box.connected)){
                circuits.add(box.connected);
            }
        }

        circuits.sort(Comparator.comparingInt(ArrayList::size));
        Collections.reverse(circuits);

        System.out.println("Day 8 Part 1: " + (circuits.get(0).size() * circuits.get(1).size() * circuits.get(2).size()));

        //Connect
        long solution2 = 0;
        while(!pairs.isEmpty()){
            BoxPair pr = pairs.getFirst();
            boolean didConnect = pr.attemptConnect();
            if(didConnect){
                solution2 = pr.box1.x * pr.box2.x;
            }
            pairs.removeFirst();
        }

        System.out.println("Day 8 Part 2: " + solution2);

    }
}
