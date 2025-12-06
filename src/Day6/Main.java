package Day6;

import util.AOC;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day6/input.txt");
        AOC.printInput(input);

        int vSize = input.length;

        String[][] seperated = new String[vSize][];
        for (int i = 0; i < vSize; i++) {
            seperated[i] = input[i].trim().split("\\s+");
        }

        int hSize = seperated[0].length;

        ArrayList<Problem> problems = new ArrayList<>();

        for (int i = 0; i < hSize; i++) {
            ArrayList<String> intList = new ArrayList<>();
            for (int j = 0; j < vSize; j++) {
                intList.add(seperated[j][i]);
            }
            Problem newProblem = new Problem(intList);
            problems.add(newProblem);
            System.out.println(newProblem);
        }

        long solution = 0;
        for(Problem problem : problems){
            solution += problem.solve();
        }

        System.out.println("Day 6 Part 1: " + solution);

    }
}
