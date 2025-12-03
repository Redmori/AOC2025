package Day3;

import util.AOC;

public class Main {
    public static void main(String[] args) {
        String[] input  = AOC.input("src/Day3/input.txt");
        char[][] banks = AOC.convertStringToChar(input);
        int part1 = getJoltageSum(banks);
        System.out.println("Day 3 Part 1: " + part1);
    }


    public static int getJoltageSum(char[][] banks){
        int sum = 0;
        for (int i = 0; i < banks.length; i++) {
            sum += getJoltage(banks[i]);
        }
        return sum;
    }

    public static int getJoltage(char[] bank){
        int potential = 0;
        int n = 2; //amount of digits to go
        int index = bank.length;
        int previousIndex = bank.length;
        int joltage = 0;
        while(n > 0){
            int i = bank.length-n;
            while(!(i  == previousIndex) && i >= 0) {
                    int battery = Character.getNumericValue(bank[i]);
                    if (battery >= potential) {
                        potential = battery;
                        index = i;
                    }
                i--;
            }
            n--;
            joltage += (int) (Math.pow(10,n) * potential);
            potential = 0;
            previousIndex = index;
        }
        return joltage;
    }
}
