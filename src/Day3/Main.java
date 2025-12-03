package Day3;

import util.AOC;

public class Main {
    public static void main(String[] args) {
        String[] input  = AOC.input("src/Day3/input.txt");
        char[][] banks = AOC.convertStringToChar(input);
        long part1 = getJoltageSum(banks, 2);
        System.out.println("Day 3 Part 1: " + part1);

        long part2 = getJoltageSum(banks, 12);
        System.out.println("Day 3 Part 2: " + part2);
    }


    public static long getJoltageSum(char[][] banks, int nBattery){
        long sum = 0;
        for (int i = 0; i < banks.length; i++) {
            sum += getJoltage(banks[i], nBattery);
        }
        return sum;
    }

    public static long getJoltage(char[] bank, int nBattery){
        int potential = 0;
        int n = nBattery; //amount of digits to go
        int index = bank.length;
        int previousIndex = bank.length;
        long joltage = 0;
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
            joltage += (long) (Math.pow(10,n) * potential);
            potential = 0;
            previousIndex = index;
        }
        return joltage;
    }
}
