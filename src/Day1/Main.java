package Day1;

import util.AOC;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        String[] input = AOC.input("src/Day1/input.txt");
        AOC.printInput(input);
        int size = input.length;

        int[] direction = new int[size];
        int[] amount = new int[size];

        for (int i = 0; i < size; i++) {
            char dir = input[i].charAt(0);
            direction[i] = dir == 'R' ? 1 : -1;

            String n = input[i].substring(1);
            amount[i] = Integer.parseInt(n);
        }

        int position = 50;
        int counter = 0;
        for (int i = 0; i < size; i++) {
            position += direction[i] * amount[i];
            position = wrap(position);
            if(position == 0){
                counter ++;
            }
        }

        System.out.println("Day 1 part 1: " + counter);

    }

    public static int wrap(int number){
        while(number < 0){
            number += 100;
        }
        while(number > 99){
            number -= 100;
        }
        return number;
    }
}