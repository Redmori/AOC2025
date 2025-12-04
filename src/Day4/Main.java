package Day4;

import util.AOC;

public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day4/input.txt");
        char [][] charMap = AOC.convertStringToChar(input);
        boolean[][] map = AOC.convertCharToBoolean(charMap, '@');
        AOC.printBoolMap(map);


        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(isPaper(map, i, j)) {
                    int amount = checkNeighbours(map, i, j);
                    if(amount < 4){
                        count++;
                    }
                }
            }
        }
        System.out.println("Day 4 Part 1: " + count);
    }

    private static int checkNeighbours(boolean[][] map, int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(isPaper(map,x + i, y + j)){
                    count++;
                }
            }
        }
        return count - 1;
    }

    public static boolean isPaper(boolean[][] map, int x, int y){
        if(x < 0 || y < 0)
            return false;
        if(x > map.length - 1 || y > map[0].length - 1)
            return false;
        return map[x][y];
    }
}
