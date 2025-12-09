package Day9;

import util.AOC;

import java.util.ArrayList;
import java.util.BitSet;

public class Main {
    public static void main(String[] args) {
        String[] input = AOC.input("src/Day9/input.txt");

        ArrayList<Tile> redTiles = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            Tile newTile = new Tile(input[i]);
            redTiles.add(newTile);
        }

        long maxSize = 0;

        for (int i = 0; i < redTiles.size(); i++) {
            for (int j = i + 1; j < redTiles.size(); j++) {
                long size = redTiles.get(i).squareSize(redTiles.get(j));
                maxSize = Math.max(size, maxSize);
            }
        }

        System.out.println("Day 9 Part 1: " + maxSize);


        ArrayList<Line> lines = new ArrayList<>();
        Tile lastTile = redTiles.getLast();
        for(Tile tile : redTiles){
            Line newLine;
            if(tile.x == lastTile.x){
                newLine = new Line(tile.x, Math.min(tile.y, lastTile.y) , Math.max(tile.y, lastTile.y), false);
            }else{
                newLine = new Line(tile.y, Math.min(tile.x, lastTile.x) , Math.max(tile.x, lastTile.x), true);
            }
            lines.add(newLine);
            lastTile = tile;
        }

        long maxSize2 = 0;

        for (int i = 0; i < redTiles.size(); i++) {
            tilings:
            for (int j = i + 1; j < redTiles.size(); j++) {
                if(!intersectsLines(redTiles.get(i), redTiles.get(j), lines)){
                    for(Tile tile : redTiles){
                        if(tile.isInRect(redTiles.get(i), redTiles.get(j))){
                            continue tilings;
                        }
                    }
                    long size = redTiles.get(i).squareSize(redTiles.get(j));

                    maxSize2 = Math.max(size, maxSize2);

                }
            }
        }
        System.out.println("Day 9 Part 2 " + maxSize2);
    }

    private static boolean intersectsLines(Tile tile1, Tile tile2, ArrayList<Line> lines) {
        for(Line line : lines){
            if(line.intersectsRect(Math.min(tile1.x, tile2.x), Math.min(tile1.y, tile2.y),Math.max(tile1.x, tile2.x), Math.max(tile1.y,tile2.y))){
                return true;
            }
        }
        return false;
    }
}
