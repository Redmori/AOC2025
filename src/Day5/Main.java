package Day5;

import util.AOC;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day5/input.txt");

        ArrayList<FreshRange> ranges = new ArrayList<>();
        int counter = 0;

        int i = 0;
        do {
            FreshRange newRange = new FreshRange(input[i]);
            ranges.add(newRange);
            System.out.println(newRange);
            i++;
        }while (!input[i].equals(""));
        i++;

        do{
            long value = Long.parseLong(input[i]);
            if(isFresh(ranges, value)){
                counter++;
            }
            i++;
        }while(i <= input.length - 1);

        System.out.println("Day 5 Part 1: " + counter);
    }


    public static boolean isFresh(ArrayList<FreshRange> ranges, long value){
        for(FreshRange range : ranges){
            if(range.isFresh(value)){
                return true;
            }
        }
        return false;
    }
}
