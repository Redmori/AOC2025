package Day5;

import util.AOC;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day5/testinput.txt");

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

        Collections.sort(ranges);

        System.out.println("=====");
        for(FreshRange range : ranges){
            System.out.println(range);
        }
        System.out.println("=====");

        long maxValue = ranges.getLast().end;

        long currentValue = 0;
        ArrayList<FreshRange> invertedRanges = new ArrayList<>();
        for(FreshRange range : ranges){
            if(range.start > currentValue){
                FreshRange newInvertedRange = new FreshRange(currentValue, range.start);
                invertedRanges.add(newInvertedRange);
                currentValue = range.end;
            } else if (range.start <= invertedRanges.getLast().end && range.end > invertedRanges.getLast().end) {
                //invertedRanges.getLast().end = range.start;
                currentValue = range.end;
            }
        }

        for(FreshRange range : invertedRanges){
            System.out.println(range);
        }

        long volume = 0;
        for(FreshRange range : invertedRanges){
            volume += range.countVolume();
        }



        System.out.println("Day 5 Part 2: " + (maxValue - volume + 1));

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
