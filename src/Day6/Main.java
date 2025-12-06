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


        char[][] map = AOC.convertStringToChar(input);
        AOC.printInput(map);
        int vs = map.length;

        int hs = 0;
        for (int i = 0; i < vs; i++) {
            hs = Math.max(hs, map[i].length);
        }

        System.out.println(vs);
        System.out.println(hs);

        System.out.println("=========");


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
                System.out.println(value);

                if(map[vs - 1][j] == '*'){
                    solution2 += multiply(values);
                    values.clear();
                } else if (map[vs - 1][j] == '+') {
                    solution2 += sum(values);
                    values.clear();
                }
            }
        }

        System.out.println("Day 6 Part 2 " + solution2);

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
