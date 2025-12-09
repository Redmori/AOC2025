package Day9;

import util.AOC;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day9/input.txt");

        ArrayList<Tile> redTiles = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            Tile newTile = new Tile(input[i]);
            redTiles.add(newTile);
            System.out.println(newTile);
        }

        long maxSize = 0;

        for (int i = 0; i < redTiles.size(); i++) {
            for (int j = i + 1; j < redTiles.size(); j++) {
                long size = redTiles.get(i).squareSize(redTiles.get(j));
                maxSize = Math.max(size, maxSize);
            }
        }

        System.out.println("Day 9 Part 1: " + maxSize);
    }
}
