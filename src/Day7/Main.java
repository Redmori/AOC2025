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

        //Bruteforce
        //int counter2 = followParticle(map, 0, input[0].indexOf('S'));

        //System.out.println("Day 7 Part 2: " + counter2);

        long[][] intMap = new long[map.length][map[0].length];

        for (int j = 0; j < map[0].length; j++) {
            propegateUp(map, intMap, map.length - 1, j, 1);
        }

        for (int i = map.length - 2; i >= 0 ; i--) {
            for (int j = 0; j < map[0].length; j++) {
                if(intMap[i][j] > 0){
                    propegateUp(map, intMap, i - 1, j, intMap[i][j]);
                }
            }
        }

        int i = 1;
        while(map[i][input[0].indexOf('S')] != '^'){
            i++;
        }
        long solution2 = intMap[i][input[0].indexOf('S')];
        System.out.println("Day 7 Part 2: " + solution2);

    }

    private static void propegateUp(char[][] map, long[][] intMap, int i, int j, long n) {
        while((i - 1) >= 0 && map[i][j] != '^'){
            if((j - 1) >= 0 &&map[i][j-1] == '^'){
                intMap[i][j-1] += n;
            }
            if((j+1) < map[0].length && map[i][j+1] == '^'){
                intMap[i][j+1] += n;
            }
            i--;
        }
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

    //Bruteforce
    public static int followParticle(char[][] map, int i, int j){
        if(i + 1 > map.length)
            return 0;
        if(map[i][j] == '^'){
            int splits = 1;
            splits += followParticle(map, i + 1, j - 1);
            splits += followParticle(map, i + 1, j + 1);
            return splits;
        }else{
            return followParticle(map, i + 1, j);
        }
    }

}
