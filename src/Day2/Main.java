package Day2;

import util.AOC;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day2/input.txt");

        ArrayList<Id> ids = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            String[] sections = input[i].split(",");
            for (int j = 0; j < sections.length; j++) {
                String[] numbers = sections[j].split("-");
                Id newId = new Id(numbers[0],numbers[1]);
                ids.add(newId);
            }
        }

        long sum = 0;
        for(Id id : ids ){
            sum += id.getSum2();
        }

        System.out.println("Day 2 part 1: " + sum);

        long sum2 = 0;
        for(Id id : ids ){
            sum2 += id.getSumN();
        }

        System.out.println("Day 2 part 2: " + sum2);



    }
}
