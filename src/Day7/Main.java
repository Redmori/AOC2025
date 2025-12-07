package Day7;

import util.AOC;

public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day7/input.txt");
        char[][] map = AOC.convertStringToChar(input);

        int counter1 = 0;
        for (int i = 0; i < map.length - 1; i++) {
            for (int j = 0; j < map[0].length; j++) {
                boolean didSplit = propagate(map, i, j);
                if(didSplit)
                    counter1++;
            }
        }

        AOC.printInput(map);

        System.out.println("Day 7 Part 1: " + counter1);
    }

    public static boolean propagate(char[][] map, int i, int j){
        if(map[i][j] == 'S' || map[i][j] == '|'){
            if (map[i + 1][j] == '^') {
                map[i + 1][j - 1] = '|';
                map[i + 1][j + 1] = '|';
                return true;
            } else {
                map[i + 1][j] = '|';
            }
        }
        return false;
    }

}
