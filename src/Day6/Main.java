package Day6;

import util.AOC;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day6/input.txt");
        AOC.printInput(input);

        ArrayList<Problem> problems = getProblems(input);

        long solution1 = getSolution1(problems);

        System.out.println("Day 6 Part 1: " + solution1);


        char[][] map = AOC.convertStringToChar(input);
        long solution2 = getSolution2(map);

        System.out.println("Day 6 Part 2 " + solution2);

    }

    private static ArrayList<Problem> getProblems(String[] input) {
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
        }
        return problems;
    }

    private static long getSolution1(ArrayList<Problem> problems) {
        long solution1 = 0;
        for(Problem problem : problems){
            solution1 += problem.solve();
        }
        return solution1;
    }

    private static long getSolution2(char[][] map) {
        int vs = map.length;

        int hs = 0;
        for (int i = 0; i < vs; i++) {
            hs = Math.max(hs, map[i].length);
        }

        long solution2 = 0;
        ArrayList<Integer> values = new ArrayList<>();
        for (int j = hs - 1; j >= 0; j--) {
            StringBuilder number = new StringBuilder();
            for (int i = 0; i < vs - 1; i++) {
                if(map[i][j] != ' '){
                    number.append(map[i][j]);
                }
            }
            String string = number.toString();
            if (!string.equals("")) {
                int value = Integer.parseInt(string);
                values.add(value);
                if(map[vs - 1][j] == '*'){
                    solution2 += multiply(values);
                    values.clear();
                } else if (map[vs - 1][j] == '+') {
                    solution2 += sum(values);
                    values.clear();
                }
            }
        }
        return solution2;
    }

    private static long sum(ArrayList<Integer> values) {
        long solution = 0;
        for (int i = 0; i < values.size(); i++) {
            solution += values.get(i);
        }
        return solution;
    }

    private static long multiply(ArrayList<Integer> values) {
        long solution = 0;
        solution = values.getFirst();
        for (int i = 1; i < values.size(); i++) {
            solution *= values.get(i);
        }
        return solution;
    }
}
