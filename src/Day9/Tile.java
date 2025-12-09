package Day9;

public class Tile {
    public int x;
    public int y;

    public Tile(String position){
        String[] split = position.split(",");
        x = Integer.parseInt(split[0]);
        y = Integer.parseInt(split[1]);
    }

    public long squareSize(Tile otherTile){
        return (long) (Math.abs(x - otherTile.x) + 1) * (Math.abs(y - otherTile.y) + 1);
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
