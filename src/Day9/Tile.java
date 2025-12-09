package Day9;

public class Tile {
    public long x;
    public long y;

    public Tile(String position){
        String[] split = position.split(",");
        x = Integer.parseInt(split[0]);
        y = Integer.parseInt(split[1]);
    }

    public long squareSize(Tile otherTile){
        return (Math.abs(x - otherTile.x) + 1) * (Math.abs(y - otherTile.y) + 1);
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
