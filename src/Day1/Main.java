package Day1;

import util.AOC;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        String[] input = AOC.input("src/Day1/input.txt");
        //AOC.printInput(input);
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
        int new_counter = 0;
        for (int i = 0; i < size; i++) {
            int new_position = position + direction[i] * amount[i];
            int[] result = wrap(new_position, position);
            position = result[0];
            if(position == 0){
                counter ++;
            }
            new_counter += result[1];

            System.out.println(input[i] + " " + result[0] + " " +  new_counter);
        }

        System.out.println("Day 1 part 1: " + counter);
        System.out.println("Day 1 part 2: " + (new_counter + counter));

    }

    public static int[] wrap(int number, int old_number){
        int[] result = new int[2];
        int counter = 0;
        while(number < 0){
            number += 100;
            if(old_number != 0)
                counter++;
            else
                old_number = 1;
        }
        while(number > 99){
            number -= 100;
            if (number != 0 )
                counter++;
        }
        result[0] = number;
        result[1] = counter;
        return result;
    }
}