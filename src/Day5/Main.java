package Day5;

import util.AOC;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day5/input.txt");

        ArrayList<FreshRange> ranges = new ArrayList<>();
        int counter = 0;

        int i = 0;
        do {
            FreshRange newRange = new FreshRange(input[i]);
            ranges.add(newRange);
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
        ArrayList<FreshRange> mergedRanges = combineRanges(ranges);

        long volume = getVolume(mergedRanges);

        System.out.println("Day 5 Part 2: " + volume);

    }

    private static ArrayList<FreshRange> combineRanges(ArrayList<FreshRange> ranges) {
        ArrayList<FreshRange> mergedRanges = new ArrayList<>();

        for(FreshRange range : ranges){
            if(!mergedRanges.isEmpty() && mergedRanges.getLast().overlaps(range)){
                mergedRanges.getLast().merge(range);
            }else {
                mergedRanges.add(range);
            }
        }
        return mergedRanges;
    }

    private static long getVolume(ArrayList<FreshRange> ranges) {
        long volume = 0;
        for(FreshRange range : ranges){
            volume += range.countVolume();
        }
        return volume;
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
